package com.example.examsprojectback.domain;

import java.util.Objects;

public class Teacher{
    private int id;
    private String name;
    private String fname;
    private String surname;
    private User user;

    public Teacher(int id, String name, String fname, String surname){
        this.id = id;
        this.name = name;
        this.fname = fname;
        this.surname = surname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Teacher teacher = (Teacher) o;
        return id == teacher.id && Objects.equals(name, teacher.name) && Objects.equals(fname, teacher.fname) && Objects.equals(surname, teacher.surname) && Objects.equals(user, teacher.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, fname, surname, user);
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", fname='" + fname + '\'' +
                ", surname='" + surname + '\'' +
                ", user=" + user +
                '}';
    }
}
