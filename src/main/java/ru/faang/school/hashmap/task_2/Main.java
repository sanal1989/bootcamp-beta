package ru.faang.school.hashmap.task_2;

import java.util.HashMap;
import java.util.Map;

public class Main {
    Map<Book, String> books = new HashMap<>();

    public static void main(String[] args) {
        Main main = new Main();
        Book bookOne = new Book("Book1", "Author1", 2000);
        Book bookTwo = new Book("Book2", "Author2", 2001);
        Book bookThree = new Book("Book3", "Author3", 2002);
        main.addBook(bookOne, "1");
        main.addBook(bookTwo, "2");
        main.addBook(bookThree, "3");
        main.printBook();
        System.out.println("---remove Book2---");
        main.remove(bookTwo);
        main.printBook();
        System.out.println("---Find Book1---");
        System.out.println(main.findBook(bookOne));
    }

    public void addBook(Book book, String number){
        books.put(book, number);
    }

    public void remove(Book book){
        books.remove(book);
    }

    public String findBook(Book book){
        return books.get(book);
    }

    public void printBook(){
        for (Map.Entry<Book, String> i: books.entrySet()) {
            System.out.println( i.getKey().getAuthor() + " "
                                + i.getKey().getTitle() + " "
                                + i.getKey().getYear() + " "
                                + i.getValue());
        }
    }
}
