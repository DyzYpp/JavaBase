package com.example.javabasedemo.test;

import com.example.javabasedemo.pojo.Employee;
import freemarker.cache.FileTemplateLoader;
import org.apache.commons.math3.analysis.function.Max;

import java.util.*;
import java.util.stream.Collectors;

public class StreamFilterPredicate {

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
        List<Employee> employees = emplooyees.stream()
                .filter(item -> item.getAge() > 70 && item.getGender().equals("M"))
                .collect(Collectors.toList());
//        System.out.println(employees);


//        调用
//    AND语法
        List<Employee> list = emplooyees.stream()
                .filter(Employee.ageGreaterThan70.and(Employee.genderM))
                .collect(Collectors.toList());
//        System.out.println(list);

//       or交集
        List<Employee> collect = emplooyees.stream()
                .filter(Employee.ageGreaterThan70.or(Employee.genderM))
                .collect(Collectors.toList());
//        System.out.println(collect);
//        negate取反
        List<Employee> collect1 = emplooyees.stream()
                .filter(Employee.ageGreaterThan70.or(Employee.genderM).negate())
                .collect(Collectors.toList());
//        System.out.println(collect1);

        Double collect2 = emplooyees.stream().collect(Collectors.summingDouble(Employee::getAge));
        Employee employee = new Employee();
        Optional<Employee> max = emplooyees.stream().max(Comparator.comparingDouble(Employee::getAge));
        Map<Integer, List<Employee>> collect3 = emplooyees.stream().collect(Collectors.groupingBy(Employee::getAge));
        System.out.println(collect2.floatValue());
        System.out.println();
        System.out.println(Collections.max(collect3.keySet()));
    }


}
