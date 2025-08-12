package com.example.library.service;

import com.example.library.model.LibraryItem;

import java.util.List;

/*Интерфейс поиска в реестре*/
public interface SearchService {

    List<LibraryItem> searchByInventoryNumber(String inventoryNumber);

    List<LibraryItem> searchByAuthor(String authorQuery);

    List<LibraryItem> search(String inventoryNumber, String authorQuery);
}