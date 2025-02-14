package com.crud.library.domain.loans;

import com.crud.library.domain.copies.CopiesOfBooks;
import com.crud.library.domain.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
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

//    @OneToMany(
//            targetEntity = CopiesOfBooks.class,
//            mappedBy = "bookLoans",
//            cascade = CascadeType.ALL,
//            fetch = FetchType.EAGER
//    )
//    private List<CopiesOfBooks> copiesOfBooks = new ArrayList<>();

//    @OneToOne
    @Column(name = "COPY_OF_BOOK_ID")
    private int copyOfBookId;

    @Column(name = "USER_ID")
    private int userId;

    @Column(name ="LOAN_DATE")
    private Date loanDate;

    @Column(name ="RETURN_DATE")
    private Date returnDate;

}
