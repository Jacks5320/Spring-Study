package com.jk.b_DI_xml.demo6;

public class BeanLife {
    private String name;

    public BeanLife() {
        System.out.println("无参构造执行了。。。");
    }

    public void init(){
        System.out.println("初始化方法执行了。。。");
    }

    public void destroy(){
        System.out.println("对象消亡了。。。");
    }
}
