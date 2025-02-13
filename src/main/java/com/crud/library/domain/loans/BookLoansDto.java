package com.crud.library.domain.loans;

import com.crud.library.domain.copies.CopiesOfBooks;
import com.crud.library.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;
import java.util.List;

@Getter
@AllArgsConstructor
public class BookLoansDto {

    private int id;
    private List<CopiesOfBooks> copiesOfBooks;
    private User user;
    private Date loanDate;
    private Date returnDate;

}
