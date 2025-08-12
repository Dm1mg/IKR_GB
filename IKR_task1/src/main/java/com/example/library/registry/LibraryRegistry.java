package com.example.library.registry;

import com.example.library.model.LibraryItem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * Реестр — хранилище всех элементов
 * Генерация экзампляров объекта
 */
public class LibraryRegistry {
    private final List<LibraryItem> items = new ArrayList<>();

    public void add(LibraryItem item) {
        items.add(item);
    }

    public void addAll(List<LibraryItem> toAdd) {
        items.addAll(toAdd);
    }

    public List<LibraryItem> getAll() {
        return Collections.unmodifiableList(items);
    }
}
