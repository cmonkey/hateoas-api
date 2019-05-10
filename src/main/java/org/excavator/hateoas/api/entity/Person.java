package org.excavator.hateoas.api.entity;

import java.time.Duration;

public class Person {
    private long id;
    private String firstName;
    private String secondName;
    private Duration dateOfBirth;
    private String profession;
    private int salary;

    public Person() {
    }

    public Person(long id, String firstName, String secondName, Duration dateOfBirth, String profession, int salary) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.dateOfBirth = dateOfBirth;
        this.profession = profession;
        this.salary = salary;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public Duration getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Duration dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
