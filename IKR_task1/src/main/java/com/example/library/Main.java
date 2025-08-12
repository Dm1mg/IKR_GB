package com.example.library;
import com.example.library.model.*;
import com.example.library.registry.LibraryRegistry;
import com.example.library.service.LibrarySearchService;
import com.example.library.service.SearchService;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        LibraryRegistry registry = new LibraryRegistry();

        // Генерируем примеры объектов фонда
        registry.add(new Book("B-0001", "Преступление и наказание", "Фёдор Достоевский", 1866, "978-5-699-00001-1", 672));
        registry.add(new Book("B-0002", "Война и мир", "Лев Толстой", 1869, "978-5-699-00002-8", 1225));
        registry.add(new Magazine("M-1001", "Наука и жизнь", "Редакция", 2023, 7, "monthly"));
        registry.add(new Magazine("M-1002", "Вокруг света", "Редакция", 2024, 3, "monthly"));
        registry.add(new Letter("L-5001", "Личное письмо", "Иван Иванов", 1975, "Пётр Петров"));
        registry.add(new Microfilm("MF-9001", "Архив газеты 1950х", 1952, 12.5));
        registry.add(new Book("B-0003", "Капитал", "Карл Маркс", 1867, "978-5-699-00003-5", 980));
        registry.add(new Book("B-0004", "Анна Каренина", "Лев Толстой", 1878, "978-5-699-00004-2", 864));

        // Инициализируем сервис поиска
        SearchService searchService = new LibrarySearchService(registry);

        // Демонстрация поиска
        System.out.println("=== Поиск по инвентарному номеру 'B-0002' ===");
        printList(searchService.searchByInventoryNumber("B-0002"));

        System.out.println("\n=== Поиск по автору 'Лев Толстой' ===");
        printList(searchService.searchByAuthor("Лев Толстой"));

        System.out.println("\n=== Комбинированный поиск: inventory='B-0004' author='Толстой' ===");
        printList(searchService.search("B-0004", "Толстой"));

        System.out.println("\n=== Поиск по автору частичное: 'лев' (регистронезависимо) ===");
        printList(searchService.searchByAuthor("лев"));

        System.out.println("\n=== Показать весь реестр ===");
        printList(registry.getAll());
    }

    private static void printList(List<?> list) {
        if (list.isEmpty()) {
            System.out.println("Ничего не найдено.");
            return;
        }
        for (Object o : list) {
            System.out.println(o);
        }
    }
}
