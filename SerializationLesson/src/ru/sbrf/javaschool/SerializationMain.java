package ru.sbrf.javaschool;

import ru.sbrf.javaschool.entity.employee.Employee;
import ru.sbrf.javaschool.entity.person.Person;
import ru.sbrf.javaschool.serializer.Serializer;
import ru.sbrf.javaschool.serializer.impl.EmployeeSerializer;
import ru.sbrf.javaschool.serializer.impl.StudentSerializer;
import ru.sbrf.javaschool.entity.student.Student;

import java.io.IOException;
import java.time.Instant;

public class SerializationMain {

    public static final String FILENAME_PREFIX = "serialization_";

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Person person = new Person("BBB_NAME", "BBB_SECONDNAME", 30);
        Student student = new Student("AAA_NAME", "AAA_SECONDNAME", 20, 1);
        Employee employee = new Employee(person, 10, "IT engineer", Instant.now(), 100000.5D);

        Serializer<Student> studentSerializer = new StudentSerializer();
        studentSerializer.serialize(student, StudentSerializer.FILENAME);
        Student outStudent = studentSerializer.deserialize(StudentSerializer.FILENAME);
        System.out.println(outStudent);
        System.out.println();

        Serializer<Employee> employeeSerializer = new EmployeeSerializer();
        employeeSerializer.serialize(employee, EmployeeSerializer.FILENAME);
        Employee outEmployee = employeeSerializer.deserialize(EmployeeSerializer.FILENAME);
        System.out.println(outEmployee);
    }

}
