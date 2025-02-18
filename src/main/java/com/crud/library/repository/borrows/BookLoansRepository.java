package com.crud.library.repository.borrows;

import com.crud.library.domain.loans.BookLoans;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookLoansRepository extends CrudRepository<BookLoans, Integer> {

    BookLoans save(BookLoans bookLoans);

    @Transactional
    @Query("SELECT bl.userId FROM BOOK_LOANS bl WHERE bl.copyOfBookId = :copyOfBookId")
    int getUserIdByCopyOfBookId(int copyOfBookId);

    @Modifying
    @Transactional
    @Query("UPDATE BOOK_LOANS bl SET bl.returnDate = :returnDate WHERE bl.id = :id")
    void setReturnDateOfBookCopy(@Param("id") int id, @Param("returnDate") LocalDate returnDate);

    List<BookLoans> getAllByUserId(int userId);

}
