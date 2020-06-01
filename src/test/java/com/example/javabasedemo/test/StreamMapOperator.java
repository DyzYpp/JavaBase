package com.example.javabasedemo.test;

import com.example.javabasedemo.pojo.Employee;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName StreamMapOperator
 * @Author
 * @Date 2020/5/30
 * @description
 */
public class StreamMapOperator {
    public static void main(String[] args) {

        Employee e1 = new Employee(1, 23, "M", "Rick", "Beethovan");
        Employee e2 = new Employee(2, 56, "M", "Rick1", "Beethovan1");
        Employee e3 = new Employee(3, 78, "M", "Rick2", "Beethovan2");
        Employee e4 = new Employee(4, 89, "F", "Rick3", "Beethovan3");
        Employee e5 = new Employee(5, 26, "M", "Rick4", "Beethovan4");
        Employee e6 = new Employee(6, 88, "F", "Rick5", "Beethovan5");
        Employee e7 = new Employee(7, 73, "F", "Rick6", "Beethovan6");
        Employee e8 = new Employee(8, 43, "M", "Rick7", "Beethovan7");
        Employee e9 = new Employee(9, 13, "F", "Rick8", "Beethovan8");
        Employee e10 = new Employee(10, 53, "M", "Rick9", "Beethovan9");

        List<Employee> emplooyees = Arrays.asList(e1, e2, e3, e4, e5, e6, e7, e8, e9, e10);

        List<String> alpha = Arrays.asList("Monkey", " Lion", "   Giraffe    ", "   Lemur    ");
        List<Integer> alpha2 = Arrays.asList(6, 7, 5, 9);
//      不适用Stream管道流
        List<String> alphaUpper = new ArrayList<>();
        for (String s : alpha) {
            alphaUpper.add(s.toUpperCase());
        }
        System.out.println(alphaUpper);

//        使用Stream管道流
        List<String> collect = alpha.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println(collect);

//        处理非字符串类型集合元素
        List<Integer> integerList = alpha.stream()
                .map(String::length)
                .collect(Collectors.toList());
        System.out.println(integerList);

        List<Boolean> booleanList = alpha.stream()
                .map(String::isEmpty)
                .collect(Collectors.toList());
        System.out.println(booleanList);

        List<String> stringList = alpha.stream()
                .map(String::trim)
                .collect(Collectors.toList());
        System.out.println(stringList);

        List<byte[]> bytes = alpha.stream()
                .map(String::getBytes)
                .collect(Collectors.toList());
        System.out.println(bytes);

//        List<Integer> integerList1 = alpha2.stream()
//                .map(Integer::new)
//                .collect(Collectors.toList());
//        System.out.println(integerList1);
        List<Integer> collect1 = alpha.stream()
                .map(String::hashCode)
                .sorted(Integer::compareTo)
//                .sorted(Integer::min)
//                .collect(Collectors.joining());
                .collect(Collectors.toList());
        System.out.println(collect1);

        List<Employee> employees = emplooyees.stream()
                .map(item ->
                {
                    item.setAge(item.getAge() + 1);
                    item.setGender(item.getGender().equals("M") ? "male" : "female");
                    return item;
                })
                .collect(Collectors.toList());
        System.out.println(employees);

        List<Employee> employeeList = emplooyees.stream()
                .peek(item -> {
                    item.setAge(item.getAge() + 1);
                    item.setGender(item.getGender().equals("M") ? "male" : "female");
                })
                .collect(Collectors.toList());
        System.out.println(employeeList);
    }
}
