package com.example.library.model;
/*Книги*/
public class Book extends LibraryItem {
    private final String isbn;
    private final int pages;

    public Book(String inventoryNumber, String title, String author, int year, String isbn, int pages) {
        super(inventoryNumber, title, author, year);
        this.isbn = isbn;
        this.pages = pages;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getPages() {
        return pages;
    }

    @Override
    public String toString() {
        return "Book " + super.toString() + String.format(" [ISBN=%s, pages=%d]", isbn, pages);
    }
}