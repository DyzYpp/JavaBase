package com.example.javabasedemo.test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @ClassName StreamTest
 * @Author
 * @Date 2020/5/28
 * @description
 */
public class StreamTest {

    public void test(){
        List<String> nameStrs = Arrays.asList("Monkey","Lion","Giraffe","Lemur");
        List<String> list = nameStrs.stream()
                .filter(item -> item.startsWith("L"))
                .map(String::toUpperCase)
                .sorted()
                .collect(Collectors.toList());
        System.out.println(list);
    }

    public void test2(){
//        将数组转换为管道流
      String[] array = {"Monkey","Lion","Giraffe","Lemur"};
        Stream<String> nameStr2 = Stream.of(array);
        System.out.println(nameStr2);
        Stream<String> nameStr3 = Stream.of("Monkey","Lion","Giraffe","Lemur");

        // 将集合转换为管道流
        List<String> list = Arrays.asList("Monkey","Lion","Giraffe","Lemur");
        Stream<String>  streamFormatList = list.stream();

        Set<String> set = new HashSet<>(list);
        Stream<String> steramFormatSet = set.stream();
        System.out.println(steramFormatSet);

//       将文本文件转为管道流
//        try {
//            Stream<String> lines = Files.lines(Paths.get("file.txt"));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

}
