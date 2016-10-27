package com.demo;

/**
 * Created by xhp on 2016/10/21.
 */
public class Student {
    private String name;
    private Integer Id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public Student(String name, Integer id) {
        this.name = name;
        Id = id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", Id=" + Id +
                '}';
    }



}
