package com.crud.library.repository.title;

import com.crud.library.domain.title.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends CrudRepository<Book, Integer> {


    Book save(Book book);

    Book getBookByTitle(String title);

}
