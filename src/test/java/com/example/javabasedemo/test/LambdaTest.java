package com.example.javabasedemo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LambdaTest {
    //    定义函数
//    public void printSomething(String something) {
//        System.out.println(something);
//    }

    //    抽象功能接口
    interface Printer {
        void print(String val);
    }
    interface Print {
        void print();
    }

    //    通过参数传递功能接口
    public void printSomething(String something, Printer printer) {
        printer.print(something);
    }

    //    通过创建对象调用
    public static void main(String[] args) {
        LambdaTest lambdaTest = new LambdaTest();
        String something = "xxxxxx";
//        lambdaTest.printSomething(something);
        Printer printer = new Printer() {
            @Override
            public void print(String val) {
                System.out.println(val);
            }
        };
        lambdaTest.printSomething(something, printer);

        //    lambda表达式
        Printer printer2 = (String toPrint) -> {
            System.out.println(toPrint);
        };
//        简化lambda表达式
//        1.去掉参数类型
        Printer printer3 = (toPrint) ->{
            System.out.println(toPrint);
        };
//        2.去掉参数括号
        Printer printer4 = toPrint -> {
            System.out.println(toPrint);
        };
//        3.去掉函数体花括号
        Printer printer5 = toPrint -> {
            System.out.println(toPrint);
        };
//        4.若接口函数不带参数,可以用()代替
         Print print = () ->{
            System.out.println("无参数测试");
        };
//        lambdaTest.printSomething(something,printer2);
//        lambdaTest.printSomething(something,printer3);
//        lambdaTest.printSomething(something,printer4);
//        lambdaTest.printSomething(something,printer5);

//        最终简化的结果
        lambdaTest.printSomething(something,toPrint -> System.out.println(toPrint));
    }
}
