package com.example.javabasedemo.pojo;


import java.util.function.Predicate;

public class Employee {

    private Integer id;
    private Integer age;
    private String gender;
    private String firstName;
    private String lastName;

    //    谓词逻辑的复用
    public static Predicate<Employee> ageGreaterThan70 = item -> item.getAge() > 70;
    public static Predicate<Employee> genderM = item -> item.getGender().equals("M");


    public Employee() {
    }

    public Employee(Integer id, Integer age, String gender, String firstName, String lastName) {
        this.id = id;
        this.age = age;
        this.gender = gender;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
