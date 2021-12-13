package ru.job4j.pojo;


public class Library {
    public static void main(String[] args) {
        Book book1 = new Book("Clean code", 464);
        Book book2 = new Book("LOL KEK", 1);
        Book book3 = new Book("Magicians", 402);
        Book book4 = new Book("Harry Potter", 4224);
        Book[] books = new Book[4];
        books[0] = book1;
        books[1] = book2;
        books[2] = book3;
        books[3] = book4;
        for (int i = 0; i < books.length; i++) {
            System.out.println(books[i].getName() + " - " + books[i].getCountOfPages());
        }
        System.out.println("replace Clean code with Harry Potter ");
        Book bookReplacer = books[3];
        books[3] = books[0];
        books[0] = bookReplacer;

        for (int i = 0; i < books.length; i++) {
            if (books[i].getName().equals("Clean code")) {
                System.out.println(books[i].getName() + " - " + books[i].getCountOfPages());
            }
        }


    }
}
