package com.crud.library.repository.copies;

import com.crud.library.domain.copies.CopiesOfBooks;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CopiesOfBooksRepositoryTestSuite {

    @Autowired
    private CopiesOfBooksRepository copiesOfBooksRepository;

    @Test
    void testCopiesOfBooksRepositorySave() {
        //Given
        CopiesOfBooks copiesOfBooks = new CopiesOfBooks();
        copiesOfBooks.setTitleId(1);
        copiesOfBooks.setStatus("wypożyczona");

        //When
        copiesOfBooksRepository.save(copiesOfBooks);
        int id = copiesOfBooks.getId();
        //Then
        assertEquals(6, id);

        //CleanUp
//        copiesOfBooksRepository.deleteById(id);

    }

}
