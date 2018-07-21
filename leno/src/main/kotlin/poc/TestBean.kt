package poc

open class TestBean {
    private var message: String = "Hello Bean111"

    fun say(msg: String) = println(msg)
    fun setMessage(msg: String): Unit {
        message = msg
    }
    fun print() = println(message)
}