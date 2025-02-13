package com.crud.library.repository.copies;

import com.crud.library.domain.copies.CopiesOfBooks;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CopiesOfBooksRepository extends CrudRepository<CopiesOfBooks, Long> {

    

}
