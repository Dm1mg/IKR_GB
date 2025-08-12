package com.example.library.model;
/*Микрофильмы - фильмы без автора (author = null)*/
public class Microfilm extends LibraryItem {
    private final double lengthMeters;

    public Microfilm(String inventoryNumber, String title, int year, double lengthMeters) {
        super(inventoryNumber, title, null, year);
        this.lengthMeters = lengthMeters;
    }

    public double getLengthMeters() {
        return lengthMeters;
    }

    @Override
    public String toString() {
        return "Microfilm " + super.toString() + String.format(" [length=%.2f m]", lengthMeters);
    }
}