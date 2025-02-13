package com.crud.library.domain.copies;

import com.crud.library.domain.loans.BookLoans;
import com.crud.library.domain.title.Title;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CopiesOfBooksDto {


    private int id;
    private Title title;
    private String status;
    private BookLoans bookLoans;

}
