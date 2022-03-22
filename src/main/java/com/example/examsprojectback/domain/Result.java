package com.example.examsprojectback.domain;

import java.util.Objects;

public class Result {
    private int id;
    private int mark;
    private Applicant applicant;
    private Teacher teacher;
    private  FacultyExam facultyExam;

    public Result(int id, int mark){
        this.id = id;
        this.mark = mark;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public int getMark() {
        return mark;
    }

    public void setApplicant(Applicant applicant) {
        this.applicant = applicant;
    }

    public Applicant getApplicant() {
        return applicant;
    }

    public void setFacultyExam(FacultyExam facultyExam) {
        this.facultyExam = facultyExam;
    }

    public FacultyExam getFacultyExam() {
        return facultyExam;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Result result = (Result) o;
        return id == result.id && mark == result.mark && Objects.equals(applicant, result.applicant) && Objects.equals(teacher, result.teacher) && Objects.equals(facultyExam, result.facultyExam);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, mark, applicant, teacher, facultyExam);
    }

    @Override
    public String toString() {
        return "Result{" +
                "id=" + id +
                ", mark=" + mark +
                ", applicant=" + applicant +
                ", teacher=" + teacher +
                ", examFaculty=" + facultyExam +
                '}';
    }
}

