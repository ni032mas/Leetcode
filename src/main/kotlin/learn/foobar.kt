package learn

fun main() {
    val car1 = Car()
    val car2 = Car()
    val engine2 = Engine2()
    val engine3 = Engine3()
    car1.drive()
    car2.drive()

    val stopFun: (String) -> Unit = { message -> println(message) }
    stopFun("Stop fun")
}