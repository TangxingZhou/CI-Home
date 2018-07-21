package hello

import org.springframework.context.annotation.*
import poc.TestBean

@Configuration
open class TestCenter {
    @Bean(name = arrayOf("SomeBean")) open fun someBean(): SomeBean = SomeBean()
    //@Bean(name = arrayOf("TestBean")) open fun testBean(): TestBean = TestBean()
    //@Bean(name = arrayOf("HelloBean")) open fun helloBean(testBean: TestBean) = HelloBean(testBean)
    @Bean(name = arrayOf("HelloBean")) open fun helloBean() = HelloBean()
}