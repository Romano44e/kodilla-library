package com.crud.library.repository.borrows;

import com.crud.library.domain.loans.BookLoans;
import com.crud.library.repository.copies.CopiesOfBooksRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class BorrowsRepositoryTestSuite {

    @Autowired
    private BookLoansRepository bookLoansRepository;
    @Autowired
    private CopiesOfBooksRepository copiesOfBooksRepository;

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

    @Test
    void testGetCopyofBookIdBySignature() {
        //Given
        int signature = 50003;
        //When
        int copyofBookIdBySignature = copiesOfBooksRepository.getCopyofBookIdBySignature(signature);
        //Then
        assertEquals(8, copyofBookIdBySignature);
    }

    @Test
    void testGetUserIdByCopyOfBookId() {
        //Given
        int copyOfBookId = 5;
        //When
        int userIdByCopyOfBookId = bookLoansRepository.getUserIdByCopyOfBookId(copyOfBookId);
        //Then
        assertEquals(8, userIdByCopyOfBookId);

    }

    @Test
    void testSetReturnDateOfBookCopy() {
        //Given
        int borrowsRepositoryId = 10;
        int userId = 8;
        int copyofBookIdBySignature = 5;
        //When
        bookLoansRepository.setReturnDateOfBookCopy(borrowsRepositoryId, Date.valueOf(LocalDate.now()));
        List<BookLoans> allByUserId = bookLoansRepository.getAllByUserId(userId);
        List<BookLoans> list = allByUserId.stream()
                .filter(r -> r.getReturnDate() == null)
                .filter(c -> c.getCopyOfBookId() == copyofBookIdBySignature)
                .toList();

        //Then
        assertEquals(1, list.size());
    }

}
