package com.crud.library.repository.loans;

import com.crud.library.domain.loans.BookLoans;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookLoansRepository extends CrudRepository<BookLoans, Integer> {



}
