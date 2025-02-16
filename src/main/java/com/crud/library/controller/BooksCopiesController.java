package com.crud.library.controller;

import com.crud.library.domain.copies.CopiesOfBooks;
import com.crud.library.domain.copies.CopiesOfBooksDto;
import com.crud.library.service.BooksCopiesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/library/bookcopy")
@RequiredArgsConstructor
public class BooksCopiesController {

    private final BooksCopiesService booksCopiesService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createBookCopy(@RequestBody CopiesOfBooksDto copiesOfBooksDto) {
        CopiesOfBooks copiesOfBooks = new CopiesOfBooks(copiesOfBooksDto.getId(), copiesOfBooksDto.getTitleId(), copiesOfBooksDto.getStatus(), copiesOfBooksDto.getSignature());

        booksCopiesService.saveCopyOfBook(copiesOfBooks);
        return ResponseEntity.ok().build();
    }

    @GetMapping("{title}")
    public ResponseEntity<String> getQuaintityOfBookCopies(@PathVariable String title) {

        String quantityOfAvailableCopies = booksCopiesService.getQuantityOfAvailableCopies(title);
        return ResponseEntity.ok(quantityOfAvailableCopies);
    }

}
