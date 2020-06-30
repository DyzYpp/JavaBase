package com.example.javabasedemo.test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @ClassName StreamStatus
 * @Author
 * @Date 2020/6/1
 * @description
 */
public class StreamStatus {
    public static void main(String[] args) {
//      limit 截取管道中的前N个元素 skip跳前几个元素
        List<String>  limitN = Stream.of("Monken","Lion","Gira","Lem")
                .limit(3)
                .collect(Collectors.toList());
        System.out.println(limitN);

        List<String>  limitN2 = Stream.of("Monken","Lion","Gira","Lem")
                .skip(3)
                .collect(Collectors.toList());
        System.out.println(limitN2);
//        distinct元素去重
        List<String>  limitN3 = Stream.of("Monken","Lion","Gira","Lem","Monken2","Lion")
                .distinct()
                .collect(Collectors.toList());
        System.out.println(limitN3);
//        sorted排序
        List<String>  limitN4 = Stream.of("Monken","Lion","Gira","Lem","Monken2","Lion")
                .sorted()
                .collect(Collectors.toList());
        System.out.println(limitN4);
//        对管道流中的元素并行处理(效率高,但顺序可能会乱)
        List<String>  limitN5 = Stream.of("Monken","Monken2","Monken3","Monken4","Monken5","Monken6","Monken7","Monken8","Monken11","Monken22","Monken33","Monken44","Monken55","Monken66","Monken77","Monken88")
                .parallel()
                .collect(Collectors.toList());
        System.out.println(limitN5);
    }
}
