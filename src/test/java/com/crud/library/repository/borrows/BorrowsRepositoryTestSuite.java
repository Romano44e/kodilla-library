package com.crud.library.repository.borrows;

import com.crud.library.domain.loans.BookLoans;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class BorrowsRepositoryTestSuite {

    @Autowired
    private BookLoansRepository bookLoansRepository;

    @Test
    void saveBorrowBook() {
        //Given
        BookLoans bookLoan = new BookLoans();
        bookLoan.setCopyOfBookId(6);
        bookLoan.setUserId(4);
        bookLoan.setLoanDate(Date.valueOf(LocalDate.now()));
        bookLoan.setReturnDate(Date.valueOf(LocalDate.now().plusDays(30)));
        //When
        bookLoansRepository.save(bookLoan);
        //Then
        assertEquals(2, bookLoansRepository.count());

    }

}
