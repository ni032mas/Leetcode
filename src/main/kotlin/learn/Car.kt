package learn

class Car {
    var engine: Engine? = null

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