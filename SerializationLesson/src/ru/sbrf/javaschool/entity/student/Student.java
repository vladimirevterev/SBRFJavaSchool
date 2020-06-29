package ru.sbrf.javaschool.entity.student;

import ru.sbrf.javaschool.entity.person.Person;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Calendar;

public class Student extends Person implements Serializable {

    private static final long serialVersionUID = -14518038974618105L;

    private int course;

    public Student() {
        System.out.println("Contructor::Student");
    }

    public Student(String firstname, String secondname, int age, int course) {
        super(firstname, secondname, age);
        this.course = course;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }


    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        out.writeLong(Calendar.getInstance().getTimeInMillis());
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        long writeTime = in.readLong();
//        System.out.println(writeTime);
    }

    @Override
    public String toString() {
        return "Student{" +
                super.toString() +
                ", course=" + course +
                '}';
    }
}
