package com.example.javabasedemo.test;

import com.github.houbb.junitperf.core.annotation.JunitPerfConfig;
import com.github.houbb.junitperf.core.report.impl.HtmlReporter;
import org.junit.jupiter.api.BeforeAll;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.Random;

/**
 * @ClassName StreamIntTest
 * @Author
 * @Date 2020/6/2
 * @description
 */
//@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class StreamIntTest {

    public static int[] arr;

    @BeforeAll
    public static void init() {
        arr = new int[50000000];
        randomInt(arr);
    }
    @JunitPerfConfig( warmUp = 1000, reporter = {HtmlReporter.class})
    public void testIntFor(){
        minIntFor(arr);
    }


    @JunitPerfConfig( warmUp = 1000, reporter = {HtmlReporter.class})
    public void testParallelInt(){
        minIntParallelStream(arr);
    }

    @JunitPerfConfig( warmUp = 1000, reporter = {HtmlReporter.class})
    public void testIntStream(){
        this.minIntStream(arr);
    }

    //    Stream串行查出最小值
    private int minIntStream(int[] arr) {
        int asInt = Arrays.stream(arr).min().getAsInt();
        return asInt;
    }

    //  Stream并行查出最小值
    private int minIntParallelStream(int[] array) {
        return Arrays.stream(arr).parallel().min().getAsInt();
    }


    //    for循环查出最小值
    private int minIntFor(int[] arr) {
        int min = Integer.MAX_VALUE;
        for (int i : arr) {
            if (i < min) {
                min = i;
            }
        }
        return min;
    }


    //    生成五亿的元素的随机数组
    private static void randomInt(int[] arr) {
        Random randomNum = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = randomNum.nextInt();
        }
    }
}
