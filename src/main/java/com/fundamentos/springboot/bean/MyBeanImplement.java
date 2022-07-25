package com.fundamentos.springboot.bean;

public class MyBeanImplement implements Mybean{


    @Override
    public void print() {
        System.out.println("hola desde mi implementacion propia del bean");
    }
}
