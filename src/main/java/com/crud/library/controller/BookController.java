package com.crud.library.controller;

import com.crud.library.domain.title.BookDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/library/book")
@RequiredArgsConstructor
public class BookController {

    @GetMapping(value = "{bookId}")
    public BookDto getBook(@PathVariable("bookId") int bookId) {
        return new BookDto(1, "Potęga Teraźniejszości", "Eckhart Tolle", 2001);
    }

    @PostMapping
    public void createBook() {

    }

}
