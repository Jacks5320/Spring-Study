package com.jk.e_annotations.demo3.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration，指定当前类为配置类,配置的字节码作为 AnnotationConfigApplicationContext 的参数时，可以省略这个注解。
 * ComponentScan，指定 Spring 创建容器时要扫描的包
 *      属性：
 *          - value：与 basePackage 的作用一样，都是用于指定创建容器时要扫描的包。
 *          - 此注解等同于在 xml 中配置了：<context:component-scan base-package="com.jk.f_annotations.demo1"/>
 * import，导入其他的配置类，使用这个注解后，导入的其他配置类中就可以不使用 Configuration 注解了，
 *          如果不使用Import注解，要使用其他配置类，要么都加上Configuration要么都作为字节码参数传入AnnotationConfigApplicationContext
 *          此时就失去包扫描的意义了。
 *      属性：
 *          value，用于指定其他配置类的字节码文件。
 *      注意：
 *          当使用 import 注解后，有 import 注解的类就是主配置类（父配置类），而导入的类都是子配置类。
 *
 */
@Configuration//把当前类作为配置类，用于替代 xml 配置文件
@ComponentScan(basePackages = {"com.jk.e_annotations.demo3"}) //包扫描
// @Import(JdbcConfig.class)
public class SpringConfig {

}
