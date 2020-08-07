package com.jk.h_aopOperate.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(value = {"com.jk.h_aopOperate.aopxml"})   // 等价于    <context:component-scan base-package="com.jk.aop.annotation"/>
@EnableAspectJAutoProxy(proxyTargetClass = true)    // 等价于    <aop:aspectj-autoproxy/>
public class AopConfig {

}
