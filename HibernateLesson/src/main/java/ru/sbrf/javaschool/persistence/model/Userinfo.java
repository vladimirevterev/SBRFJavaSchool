package ru.sbrf.javaschool.persistence.model;

import javax.persistence.*;

@Entity
@Table(name = "USER")
public class Userinfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "age")
    private Long age;

    @Column(name = "TELEPHONE")
    private String telephone;

    @Column(name = "SALARY")
    @Transient
    private Long salary;

    public Userinfo() {

    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Long getAge() {
        return age;
    }

    public String getTelephone() {
        return telephone;
    }

    public Long getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Userinfo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", telephone='" + telephone + '\'' +
                ", salary=" + salary +
                '}';
    }
}
