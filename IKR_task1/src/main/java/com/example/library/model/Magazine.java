package com.example.library.model;
/*Журналы*/
public class Magazine extends LibraryItem {
    private final int issueNumber;
    private final String periodicity;

    public Magazine(String inventoryNumber, String title, String author, int year, int issueNumber, String periodicity) {
        super(inventoryNumber, title, author, year);
        this.issueNumber = issueNumber;
        this.periodicity = periodicity;
    }

    public int getIssueNumber() {
        return issueNumber;
    }

    public String getPeriodicity() {
        return periodicity;
    }

    @Override
    public String toString() {
        return "Magazine " + super.toString() + String.format(" [issue=%d, periodicity=%s]", issueNumber, periodicity);
    }
}