package learn

fun main1() {
    val car1 = Car()
    val car2 = Car()
    val engine2 = Engine2()
    val engine3 = Engine3()
    car1.drive()
    car2.drive()

    val stopFun: (String) -> Unit = { message -> println(message) }
    stopFun("Stop fun")
}

class SharedRes {
    var x: Int = 0
    var y: Int = 0
}

fun main() {
   val sr = SharedRes()
    val t1 = Thread {
        sr.x = 1
        println(sr.y)
    }

    val t2 = Thread {
        sr.y = 1
        println(sr.x)
    }
    t1.start()
    t2.start()
    t1.join()
    t2.join()
}