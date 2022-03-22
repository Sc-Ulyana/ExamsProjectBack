package com.example.examsprojectback.domain;

import java.util.Objects;

public class Applicant {
    private int id;
    private String name;
    private String surname;
    private Double averageMark;
    private User user;

    public Applicant(int id, String name, String surname, Double averageMark){
        this.id = id;
        this. name = name;
        this.surname = surname;
        this.averageMark = averageMark;
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Double getAverageMark() {
        return averageMark;
    }

    public void setAverageMark(Double averageMark) {
        this.averageMark = averageMark;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Applicant applicant = (Applicant) o;
        return id == applicant.id && Objects.equals(name, applicant.name) && Objects.equals(surname, applicant.surname) && Objects.equals(averageMark, applicant.averageMark) && Objects.equals(user, applicant.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, averageMark, user);
    }

    @Override
    public String toString() {
        return "Applicant{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", averageMark=" + averageMark +
                ", user=" + user +
                '}';
    }
}
