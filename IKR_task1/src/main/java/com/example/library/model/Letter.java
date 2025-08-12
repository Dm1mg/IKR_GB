package com.example.library.model;
/*Письма*/
public class Letter extends LibraryItem {
    private final String recipient;

    public Letter(String inventoryNumber, String title, String author, int year, String recipient) {
        super(inventoryNumber, title, author, year);
        this.recipient = recipient;
    }

    public String getRecipient() {
        return recipient;
    }

    @Override
    public String toString() {
        return "Letter " + super.toString() + String.format(" [to=%s]", recipient);
    }
}