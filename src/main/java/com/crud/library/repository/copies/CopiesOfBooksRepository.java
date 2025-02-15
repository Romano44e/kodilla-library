package com.crud.library.repository.copies;

import com.crud.library.domain.copies.CopiesOfBooks;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CopiesOfBooksRepository extends CrudRepository<CopiesOfBooks, Integer> {

        CopiesOfBooks save(CopiesOfBooks copiesOfBooks);

        List<CopiesOfBooks> getCopiesOfBooksByTitleId(int titleId);

}
