package com.crud.library.domain.title;

import com.crud.library.domain.copies.CopiesOfBooks;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@AllArgsConstructor
@Entity(name = "BOOKS")
public class Book {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    private int id;

    @Column(name ="TITLE")
    private String title;

    @Column(name ="AUTHOR")
    private String author;

    @Column(name ="YEAR_OF_PUBLICATION")
    private int yearOfPublication;

//    @OneToMany(
//            targetEntity = CopiesOfBooks.class,
//            mappedBy = "title",
//            cascade = CascadeType.ALL,
//            fetch = FetchType.EAGER
//    )
//    private List<CopiesOfBooks> copiesOfBooks = new ArrayList<>();


    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setYearOfPublication(int yearOfPublication) {
        this.yearOfPublication = yearOfPublication;
    }
}
