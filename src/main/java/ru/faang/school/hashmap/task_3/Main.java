package ru.faang.school.hashmap.task_3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    Map<Faculty, List<Student>> hashMap = new HashMap<>();
    public static void main(String[] args) {
        Main main = new Main();
        List<Student> list1 = new ArrayList<>();
        List<Student> list2 = new ArrayList<>();
        List<Student> list3 = new ArrayList<>();
        Faculty f1 = new Faculty("F1", 2000);
        Faculty f2 = new Faculty("F2", 2001);
        Faculty f3 = new Faculty("F3", 2002);
        Student student1 = new Student("s1", "F1", 2000);
        Student student2 = new Student("s2", "F1", 2000);
        Student student3 = new Student("s3", "F1", 2000);
        Student student4 = new Student("s4", "F2", 2001);
        Student student5 = new Student("s5", "F2", 2001);
        Student student6 = new Student("s6", "F2", 2001);
        Student student7 = new Student("s7", "F3", 2002);
        Student student8 = new Student("s8", "F3", 2002);
        Student student9 = new Student("s9", "F3", 2002);
        list1.add(student1);
        list1.add(student2);
        list1.add(student3);
        list2.add(student4);
        list2.add(student5);
        list2.add(student6);
        list3.add(student7);
        list3.add(student8);
        list3.add(student9);
        main.hashMap.put(f1,list1);
        main.hashMap.put(f2,list2);
        main.hashMap.put(f3,list3);
        main.printStudents();
        System.out.println("---add Student---");
        Student student10 = new Student("s10", "F4", 2004);
        Student student11 = new Student("s11", "F1", 2000);
        main.addStudent(student10);
        main.addStudent(student11);
        main.printStudents();
        System.out.println("---find Student---");
        main.findStudents(f1).forEach(System.out::println);
        System.out.println("---remove Student");
        main.removeStudent(student1);
        main.printStudents();
    }

    public void addStudent(Student student){
        Faculty faculty = new Faculty(student.getFaculty(), student.getYear());
        if(hashMap.containsKey(faculty)){
            hashMap.get(faculty).add(student);
        }else {
            hashMap.put(faculty, new ArrayList<>());
            hashMap.get(faculty).add(student);
        }
    }

    public void removeStudent(Student student){
        Faculty faculty = new Faculty(student.getFaculty(), student.getYear());
        hashMap.get(faculty).remove(student);
    }

    public List<Student> findStudents(Faculty faculty){
        return hashMap.get(faculty);
    }

    public void printStudents(){
        for (Map.Entry<Faculty, List<Student>> i: hashMap.entrySet()) {
            System.out.println(i.getKey().getFaculty() + " " + i.getKey().getYear());
            for (Student s: i.getValue()) {
                System.out.println(s.getName() + " " + s.getFaculty() + " " + s.getYear());
            }
            System.out.println("---");
        }
    }
}
