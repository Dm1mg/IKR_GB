package com.example.library.model;
/*Абстракный класс элементов библиотеки*/
public abstract class LibraryItem {
    private final String inventoryNumber;
    private final String title;
    private final String author;
    private final int year;

    protected LibraryItem(String inventoryNumber, String title, String author, int year) {
        this.inventoryNumber = inventoryNumber;
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public String getInventoryNumber() {
        return inventoryNumber;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return String.format("[%s] %s (author=%s, year=%d)",
                inventoryNumber, title, author == null ? "-" : author, year);
    }
}