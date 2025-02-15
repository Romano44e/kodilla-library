package com.crud.library.service;

import com.crud.library.domain.copies.CopiesOfBooks;
import com.crud.library.repository.copies.CopiesOfBooksRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BooksCopiesService {

    private final CopiesOfBooksRepository copiesOfBooksRepository;

    public CopiesOfBooks saveCopyOfBook(CopiesOfBooks copiesOfBooks) {
        return copiesOfBooksRepository.save(copiesOfBooks);
    }

}
