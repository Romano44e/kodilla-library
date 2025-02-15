package com.crud.library.repository.copies;

import com.crud.library.domain.copies.CopiesOfBooks;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

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

    @Test
    void testGetListOfCopiesOfBooksByTitleId() {
        //Given
        int id = 1;

        //When
        List<CopiesOfBooks> copiesOfBooksByTitleId = copiesOfBooksRepository.getCopiesOfBooksByTitleId(id);
        CopiesOfBooks copiesOfBooks = copiesOfBooksByTitleId.get(0);
        CopiesOfBooks copiesOfBooks1 = copiesOfBooksByTitleId.get(1);

        //Then
        assertEquals(2, copiesOfBooksByTitleId.size());
        assertEquals(50000, copiesOfBooks.getSignature());
        assertEquals(50001, copiesOfBooks1.getSignature());

    }

}
