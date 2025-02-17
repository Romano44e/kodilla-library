package com.crud.library.service;

import com.crud.library.domain.copies.CopiesOfBooks;
import com.crud.library.domain.copies.QuantityOfAvailableCopiesDto;
import com.crud.library.domain.title.Book;
import com.crud.library.repository.copies.CopiesOfBooksRepository;
import com.crud.library.repository.title.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BooksCopiesService {

    private final CopiesOfBooksRepository copiesOfBooksRepository;
    private final BookRepository bookRepository;

    public CopiesOfBooks saveCopyOfBook(CopiesOfBooks copiesOfBooks) {
        return copiesOfBooksRepository.save(copiesOfBooks);
    }

    public QuantityOfAvailableCopiesDto getQuantityOfAvailableCopies(String title) {
        Book book = bookRepository.getBookByTitle(title);

        if (book == null) {
            return new QuantityOfAvailableCopiesDto(0, "nie ma takiej książki");
        }

        int id = book.getId();

        List<CopiesOfBooks> copiesOfBooksByTitleId = copiesOfBooksRepository.getCopiesOfBooksByTitleId(id);
        List<CopiesOfBooks> availableCopiesOfBook = copiesOfBooksByTitleId.stream()
                .filter(c -> c.getStatus().equals("dostępna"))
                .toList();

        if (availableCopiesOfBook.isEmpty()) {
            return  new QuantityOfAvailableCopiesDto(0, title);
        }

        int quantity = availableCopiesOfBook.size();


        return new QuantityOfAvailableCopiesDto(quantity, title);
    }

}
