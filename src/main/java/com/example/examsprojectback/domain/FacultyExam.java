package com.example.examsprojectback.domain;

import java.util.Objects;

public class FacultyExam {
    private int id;
    private Faculty faculty;
    private Exam exam;

    public  FacultyExam(int id){
        this.id = id;
    }

    public  FacultyExam(int id, int facultyId, int examId){
        this.id = id;
        this.exam = exam;
        this.faculty = faculty;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public Exam getExam() {
        return exam;
    }

    public void setExam(Exam exam) {
        this.exam = exam;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FacultyExam that = ( FacultyExam) o;
        return id == that.id && Objects.equals(faculty, that.faculty) && Objects.equals(exam, that.exam);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, faculty, exam);
    }

    @Override
    public String toString() {
        return "ExamFaculty{" +
                "id=" + id +
                ", faculty=" + faculty +
                ", exam=" + exam +
                '}';
    }
}
