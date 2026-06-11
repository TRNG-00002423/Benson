package com.revature.qa.week2;

/**
 * Hello world!
 */
public class Person {
    private final String name;
    private final int age;

    Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    public String getMessage(){
        return this.name + ":" + this.age;
    }


}
