package hello;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import poc.TestBean;


public class KotlinHello {
    public static void main(String[] args){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(TestCenter.class);
        ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
        TestBean testBean = new TestBean();
        beanFactory.registerSingleton("TestBean", testBean);
        //beanFactory.registerSingleton("HelloBean", HelloBean(testBean))
        context.refresh();
        //println(context.getBean("HelloBean"))
        //HelloBean().say()
        ((TestBean) context.getBean("TestBean")).setMessage("Hello Bean55");
        ((HelloBean) context.getBean("HelloBean")).print();
        new HelloBean().print();
        context.close();
    }
}
