package ru.sbrf.javaschool.entity.employee;

import ru.sbrf.javaschool.entity.person.Person;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.time.Instant;
import java.util.Base64;

public class Employee extends Person implements Externalizable {

    private static final long serialVersionUID = -7259002486088424853L;

    private Integer grade;
    private String position;
    private Instant employmentDate;
    private Double salary;

    public Employee() {
        System.out.println("Contructor::Employee");
    }

    public Employee(
            Person person,
            Integer grade,
            String position,
            Instant employmentDate,
            Double salary
    ) {
        super(person.getFirstname(), person.getSecondname(), person.getAge());
        this.grade = grade;
        this.position = position;
        this.employmentDate = employmentDate;
        this.salary = salary;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(super.getFirstname());
        out.writeObject(this.grade);
        out.writeObject(this.position);
        out.writeObject(this.employmentDate);
        out.writeObject(encrypt(this.salary));
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        super.setFirstname((String) in.readObject());
        grade = (Integer) in.readObject();
        position = (String) in.readObject();
        employmentDate = (Instant) in.readObject();
        salary = decrypt((String) in.readObject());
    }

    private String encrypt(Double number) {
        String encryptedNumber = Base64.getEncoder().encodeToString(number.toString().getBytes());
        System.out.println("Encrypted word = " + encryptedNumber);
        return encryptedNumber;
    }

    private Double decrypt(String word) {
        Double decryptedNumber = Double.valueOf(new String(Base64.getDecoder().decode(word)));
        System.out.println("Decrypted word = " + decryptedNumber);
        return decryptedNumber;
    }

    @Override
    public String toString() {
        return "Employee{" +
                super.toString() +
                ", grade=" + grade +
                ", position='" + position + '\'' +
                ", employmentDate=" + employmentDate +
                ", salary=" + salary +
                '}';
    }
}
