package ru.sbrf.javaschool.entity.person;

import java.io.ObjectStreamField;
import java.io.Serializable;

public class Person {

    private static final long serialVersionUID = -1686061928787043566L;

    private String firstname;
    private String secondname;
    private int age;

    private static final ObjectStreamField[] serialPersistentFields = {new ObjectStreamField("firstname", String.class)};

    public Person(String firstname, String secondname, int age) {
        this.firstname = firstname;
        this.secondname = secondname;
        this.age = age;
    }

    public Person() {
        System.out.println("Contructor::Person");
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setSecondname(String secondname) {
        this.secondname = secondname;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getSecondname() {
        return secondname;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstname='" + firstname + '\'' +
                ", secondname='" + secondname + '\'' +
                ", age=" + age +
                '}';
    }
}
