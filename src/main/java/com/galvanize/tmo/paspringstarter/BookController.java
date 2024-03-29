package com.galvanize.tmo.paspringstarter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/books")
public class BookController {

    @Autowired
    private BookService service;

    @PostMapping
    public ResponseEntity<Book> create(@RequestBody Book book) throws URISyntaxException {
        Book createdBook = service.create(book);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("{id}")
                .buildAndExpand(createdBook.getId())
                .toUri();

        return ResponseEntity.created(uri).body(createdBook);
    }

    @GetMapping
    public Map<String,List<Book>> read() {
        return service.readAll();
    }

    @DeleteMapping
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteAll() {
        service.deleteAll();
    }
}
