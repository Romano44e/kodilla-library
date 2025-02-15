package com.crud.library.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/library/borrows")
@RequiredArgsConstructor
public class BorrowsController {

    @PostMapping(value = "{title}")
    public String borrow(@PathVariable String title) {
        return title + " borrowed successfully!";
    }

    @DeleteMapping("{signature}")
    public String delete(@PathVariable String signature) {
        return "The book signatured " + signature + " returned successfully!";
    }

}
