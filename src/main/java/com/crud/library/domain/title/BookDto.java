package com.crud.library.domain.title;

import com.crud.library.domain.copies.CopiesOfBooks;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class BookDto {

    private int id;
    private String title;
    private String author;
    private int yearOfPublication;

}
