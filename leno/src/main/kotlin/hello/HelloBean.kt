package hello

import org.springframework.beans.factory.annotation.Autowired
import poc.TestBean

open class HelloBean {
    @Autowired var bean: TestBean = TestBean()

    fun say(msg: String) = bean.say(msg)
    fun print() = bean.print()
}