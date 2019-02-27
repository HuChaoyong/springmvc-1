package com.hcyshmily.curd.entities;

public class Hero {

    private String name;
    private Integer age;

    public Hero(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public Hero() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Hero{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
