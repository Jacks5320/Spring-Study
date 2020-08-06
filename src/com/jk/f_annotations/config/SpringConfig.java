package com.jk.f_annotations.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration//把当前类作为配置类，用于替代 xml 配置文件
@ComponentScan(basePackages = {"com.jk"}) //包扫描
public class SpringConfig {

}
