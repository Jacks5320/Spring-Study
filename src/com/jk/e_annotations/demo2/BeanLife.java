package com.jk.e_annotations.demo2;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class BeanLife {

    String 变量 = "小明";

    public BeanLife() {
        System.out.println(变量 + "对象创建了。。。");
    }

    @PostConstruct
    public void init(){
        System.out.println(变量 +"初始化方法执行了。。。");
    }

    @PreDestroy
    public void destroy(){
        System.out.println(变量 + "对象销毁了。。。");
    }
}
