package com.galvanize.tmo.paspringstarter;

import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class BookService {

    private String BASE_URL = System.getenv("BASE_URL");

    private Map<Long, Book> repository = Arrays.asList(new Book[] {}).stream()
            .collect(Collectors.toMap(b-> b.getId(), Function.identity()));

    private AtomicLong sequence = new AtomicLong(0);

    public Map<String, List<Book>> readAll() {

       List<Book> books = repository.values().stream().sorted(new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return o1.getTitle().compareTo(o2.getTitle());
            }
        }).collect(Collectors.toList());

        Map<String, List<Book>> mapped =  new HashMap<String, List<Book>>();
        mapped.put("books", books);
        return mapped;
    }

    public Book read(Long id) {
        return repository.get(id);
    }

    public Book create(Book book) {
        long key = sequence.incrementAndGet();
        book.setId(key);
        repository.put(key, book);
        return book;
    }

    public void deleteAll() {
        sequence.set(0);
        repository = Arrays.asList(new Book[] {}).stream()
                .collect(Collectors.toMap(b-> b.getId(), Function.identity()));
    }
}
