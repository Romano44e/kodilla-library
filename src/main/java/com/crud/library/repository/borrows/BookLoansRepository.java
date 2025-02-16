package com.crud.library.repository.borrows;

import com.crud.library.domain.loans.BookLoans;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BookLoansRepository extends CrudRepository<BookLoans, Integer> {


    BookLoans save(BookLoans bookLoans);

    @Modifying
    @Transactional
    @Query("DELETE FROM BOOK_LOANS BL WHERE BL.copyOfBookId = :copyOfBookId")
    void deleteByCopyOfBookId(@Param("copyOfBookId") int copyOfBookId);

}
