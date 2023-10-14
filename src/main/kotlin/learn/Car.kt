package learn

class Car {
    var engine: Engine2? = null

    fun drive() {
        engine?.start("Start engine")
        if (engine == null) {
            println("Engine not found")
        } else {
            println("Drive")
        }
    }

    fun stopDrive(stopper: (String) -> String): (Unit) -> Unit {
        return { println(stopper("Stop drive")) }
    }

}

fun main() {
    val car = Car()
    val engine = Engine2()
    car.engine = engine
}