package ru.sbrf.javaschool.serializer.impl;

import ru.sbrf.javaschool.entity.employee.Employee;
import ru.sbrf.javaschool.serializer.Serializer;

public class EmployeeSerializer implements Serializer<Employee> {

    public static final String FILENAME = Employee.class.getSimpleName() + Serializer.FILENAME_SUFIX;

}
