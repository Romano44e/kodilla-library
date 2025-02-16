package com.crud.library.repository.copies;

import com.crud.library.domain.copies.CopiesOfBooks;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CopiesOfBooksRepository extends CrudRepository<CopiesOfBooks, Integer> {

        CopiesOfBooks save(CopiesOfBooks copiesOfBooks);

        List<CopiesOfBooks> getCopiesOfBooksByTitleId(int titleId);
        CopiesOfBooks getCopyOfBookById(int id);

        @Transactional
        @Query("SELECT c.id FROM COPIES_OF_BOOKS c WHERE c.signature = :signature")
        int getCopyofBookIdBySignature(int signature);

        @Modifying
        @Transactional
        @Query("UPDATE COPIES_OF_BOOKS c SET c.status = :status WHERE c.id = :id")
        void updateStatus(@Param("id") int id, @Param("status") String status);

}
