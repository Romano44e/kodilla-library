package com.crud.library.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/library/bookcopy")
@RequiredArgsConstructor
public class BookCopyController {

    @PostMapping
    public void bookCopy() {


    }

}
