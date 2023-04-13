package ru.faang.school.hashmap.task_3;

import java.util.Objects;

public class Faculty {
    private String faculty;
    private int year;

    public Faculty(String faculty, int year) {
        this.faculty = faculty;
        this.year = year;
    }

    public String getFaculty() {
        return faculty;
    }

    public int getYear() {
        return year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Faculty faculty1 = (Faculty) o;
        return year == faculty1.year && Objects.equals(faculty, faculty1.faculty);
    }

    @Override
    public int hashCode() {
        return Objects.hash(faculty, year);
    }
}
