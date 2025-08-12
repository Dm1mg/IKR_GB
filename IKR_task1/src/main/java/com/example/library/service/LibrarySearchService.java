package com.example.library.service;

import com.example.library.model.LibraryItem;
import com.example.library.registry.LibraryRegistry;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

/*
 * Реализация интерфейса SearchService.
 */
public class LibrarySearchService implements SearchService {
    private final LibraryRegistry registry;

    public LibrarySearchService(LibraryRegistry registry) {
        this.registry = registry;
    }

    @Override
    public List<LibraryItem> searchByInventoryNumber(String inventoryNumber) {
        if (inventoryNumber == null) return List.of();
        return registry.getAll().stream()
                .filter(i -> inventoryNumber.equals(i.getInventoryNumber()))
                .collect(Collectors.toList());
    }

    @Override
    public List<LibraryItem> searchByAuthor(String authorQuery) {
        if (authorQuery == null || authorQuery.trim().isEmpty()) return List.of();
        String q = authorQuery.toLowerCase(Locale.ROOT).trim();
        List<LibraryItem> result = new ArrayList<>();
        for (LibraryItem item : registry.getAll()) {
            String author = item.getAuthor();
            if (author != null && author.toLowerCase(Locale.ROOT).contains(q)) {
                result.add(item);
            }
        }
        return result;
    }

    @Override
    public List<LibraryItem> search(String inventoryNumber, String authorQuery) {
        boolean invGiven = inventoryNumber != null && !inventoryNumber.trim().isEmpty();
        boolean authorGiven = authorQuery != null && !authorQuery.trim().isEmpty();

        if (!invGiven && !authorGiven) {
            return registry.getAll();
        }

        List<LibraryItem> byInv = invGiven ? searchByInventoryNumber(inventoryNumber) : registry.getAll();
        if (!authorGiven) {
            return byInv;
        }


        String q = authorQuery.toLowerCase(Locale.ROOT).trim();
        return byInv.stream()
                .filter(i -> i.getAuthor() != null && i.getAuthor().toLowerCase(Locale.ROOT).contains(q))
                .collect(Collectors.toList());
    }
}