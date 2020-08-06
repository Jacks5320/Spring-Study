package com.jk.g_aopProxy.demo2;

/**
 * 生产者
 */
public class Producer {
    public void saleProduct(float money) {
        System.out.println("销售产品，拿到钱~" + money);
    }

    public void afterService(float money) {
        System.out.println("提供售后服务，并拿到钱~" + money);
    }
}
