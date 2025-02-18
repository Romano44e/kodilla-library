package com.crud.library.domain.loans;

import com.crud.library.domain.copies.CopiesOfBooks;
import com.crud.library.domain.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@AllArgsConstructor
@Entity(name = "BOOK_LOANS")
public class BookLoans {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    private int id;


    @Column(name = "COPY_OF_BOOK_ID")
    private int copyOfBookId;

    @Column(name = "USER_ID")
    private int userId;

    @Column(name ="LOAN_DATE")
    private LocalDate loanDate;

    @Column(name ="RETURN_DATE")
    private LocalDate returnDate;

    public void setCopyOfBookId(int copyOfBookId) {
        this.copyOfBookId = copyOfBookId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setLoanDate(LocalDate loanDate) {
        this.loanDate = loanDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }
}
