package ru.sbrf.javaschool.serializer.impl;

import ru.sbrf.javaschool.serializer.Serializer;
import ru.sbrf.javaschool.entity.student.Student;

public class StudentSerializer implements Serializer<Student> {

    public static final String FILENAME = Student.class.getSimpleName() + Serializer.FILENAME_SUFIX;

}
