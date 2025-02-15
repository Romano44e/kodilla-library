package com.crud.library.repository.title;

import com.crud.library.domain.title.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class BookRepositoryTestSuite {

    @Autowired
    private BookRepository bookRepository;

    @Test
    void testBookRepositorySave() {
        //Given
        Book book = new Book();
        book.setTitle("Anioły i Demony");
        book.setAuthor("Dan Brown");
        book.setYearOfPublication(2000);

        //When
        bookRepository.save(book);
        int id = book.getId();
        //Then
        assertEquals(2, id);
        //CleanUp
//        bookRepository.deleteById(id);

    }

    @Test
    void testGetBookByTitle() {
        //Given
        String title = "Potęga Teraźniejszości";

        //When
        Book book = bookRepository.getBookByTitle(title);
        int id = book.getId();

        //Then
        assertEquals(1, id);
        assertEquals("Eckhart Tolle", book.getAuthor());
        assertEquals(2001, book.getYearOfPublication());

    }

}
