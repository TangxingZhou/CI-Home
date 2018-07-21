package hello

import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import poc.TestBean

val KotlinHelloString : String = "Hello from Kotlin!"

fun getHelloStringFromJava() : String {
    return JavaHello.JavaHelloString!!;
}

fun getHelloString() : String {
    return "Hello, world!"
}

fun main(args : Array<String>) {
    //println(getHelloString())
    //print(getHelloStringFromJava())
    var context = AnnotationConfigApplicationContext()
    context.register(TestCenter::class.java)
    var beanFactory = context.beanFactory
    val testBean = TestBean()
    beanFactory.registerSingleton("TestBean", testBean)
    //beanFactory.registerSingleton("HelloBean", HelloBean(testBean))
    context.refresh()
    //println(context.getBean("HelloBean"))
    //HelloBean().say()
    //(context.getBean("TestBean") as TestBean).setMessage("Hello Bean55")
    //(context.getBean("HelloBean") as HelloBean).print()
    HelloBean().print()
    context.close()
}
