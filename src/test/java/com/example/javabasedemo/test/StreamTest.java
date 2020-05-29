package com.example.javabasedemo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName StreamTest
 * @Author
 * @Date 2020/5/28
 * @description
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class StreamTest {

    @Test
    public void test(){
        List<String> nameStrs = Arrays.asList("Monkey","Lion","Giraffe","Lemur");
        List<String> list = nameStrs.stream()
                .filter(item -> item.startsWith("L"))
                .map(String::toUpperCase)
                .sorted()
                .collect(Collectors.toList());
        System.out.println(list);
    }

}
