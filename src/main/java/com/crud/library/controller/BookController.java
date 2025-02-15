package com.crud.library.controller;

import com.crud.library.domain.title.Book;
import com.crud.library.domain.title.BookDto;
import com.crud.library.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/library/book")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping(value = "{bookId}")
    public BookDto getBook(@PathVariable("bookId") int bookId) {
        return new BookDto(1, "Potęga Teraźniejszości", "Eckhart Tolle", 2001);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createBook(@RequestBody BookDto bookDto) {
        Book book = new Book(bookDto.getId(), bookDto.getTitle(), bookDto.getAuthor(), bookDto.getYearOfPublication());

        bookService.saveBook(book);
        return ResponseEntity.ok().build();
    }

}
