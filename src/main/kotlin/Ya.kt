import kotlinx.coroutines.*
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import kotlin.coroutines.coroutineContext
import kotlin.coroutines.suspendCoroutine


class Test {
    private val mutex = Mutex()

    @Volatile
    var value = 0
        private set

    suspend fun run() {
        mutex.withLock {
            repeat(10_000) {
                increment()
            }
        }
    }

    private suspend fun increment() {
        mutex.withLock {
            value++
        }
    }
}

//fun main() {
//    val test = Test()
//    val coroutineScope = CoroutineScope(Dispatchers.Default)
//    repeat(1_000) {
//        coroutineScope.launch { test.run() }
//    }
//    Thread.sleep(300)
//    println(test.value)
//}

var a = 0
var b = 0

val firstThread = Thread {
    a = 1
    secondThread.start()
    print("b = $b, ")
}

val secondThread = Thread {
    b = 1
    print("a = $a, ")
}

fun main() {
    println(
        flowering(
            listOf(
                listOf(5, 10),
                listOf(4, 6, 7),
                listOf(2, 3, 3),
                listOf(1, 1, 4),
                listOf(2, 3, 1),
                listOf(2, 4, 5),
            )
        )
    )

    println(
        flowering(
            listOf(
                listOf(3, 10),
                listOf(1, 5, 10),
                listOf(2, 3, 4),
                listOf(2, 6, 5),
            )
        )
    )
}

fun flowering(data: List<List<Int>>): String {
    if (data.isEmpty() || data[0].isEmpty() || data[0][0] > data.size) return "No"
    val t = data[0].last()
    val period = IntArray(t)
    data.subList(1, data.size).forEach { valueList ->
        if (valueList[1] - valueList[0] < valueList[2]) {
            for (i in valueList[1] - 1..valueList[0] + valueList[2] - 2) {
                period[i] = 1
            }
        }
    }

    return if (period.any { it == 0 }) {
        "No"
    } else {
        "Yes"
    }
}

fun main1() {
    val lock = Any()
    var value = 0
    runBlocking {
        repeat(1_000) {
            launch(Dispatchers.Default) {
                lock.withLock {
                    value++
                }
            }
        }
    }
}

inline fun Any.withLock(block: () -> Unit) {
    synchronized(this) { block() }
}