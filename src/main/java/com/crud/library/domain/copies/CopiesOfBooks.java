package com.crud.library.domain.copies;

import com.crud.library.domain.loans.BookLoans;
import com.crud.library.domain.title.Title;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@AllArgsConstructor
@Entity(name = "COPIES_OF_BOOKS")
public class CopiesOfBooks {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    private int id;

    @ManyToOne
    @JoinColumn(name = "TITLE_ID")
    private Title title;

    @Column(name ="STATUS")
    private String status;

    @ManyToOne
    @JoinColumn(name = "BOOK_LOANS_ID")
    private BookLoans bookLoans;

}
