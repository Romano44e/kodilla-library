package com.crud.library.service;

import com.crud.library.domain.copies.CopiesOfBooks;
import com.crud.library.domain.loans.BookLoans;
import com.crud.library.domain.title.Book;
import com.crud.library.domain.user.User;
import com.crud.library.repository.borrows.BookLoansRepository;
import com.crud.library.repository.copies.CopiesOfBooksRepository;
import com.crud.library.repository.title.BookRepository;
import com.crud.library.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BorrowsService {

    private final BookLoansRepository bookLoansRepository;
    private final BookRepository bookRepository;
    private final CopiesOfBooksRepository copiesOfBooksRepository;
    private final UserRepository userRepository;

    public String borrowBook(String title, String nickName) {
        Book book = bookRepository.getBookByTitle(title);

        int id = book.getId();

        List<CopiesOfBooks> copiesOfBooksByTitleId = copiesOfBooksRepository.getCopiesOfBooksByTitleId(id);
        List<CopiesOfBooks> availableCopiesOfBook = copiesOfBooksByTitleId.stream()
                .filter(c -> c.getStatus().equals("dostępna"))
                .toList();

        CopiesOfBooks firstAvailableBook = availableCopiesOfBook.getFirst();
        copiesOfBooksRepository.updateStatus(firstAvailableBook.getId(), "wypożyczona");

        User userByNickName = userRepository.getUserByNickName(nickName);
        int userId = userByNickName.getId();

        BookLoans bookLoan = new BookLoans();
        bookLoan.setCopyOfBookId(firstAvailableBook.getId());
        bookLoan.setUserId(userId);
        bookLoan.setLoanDate(Date.valueOf(LocalDate.now()));
        bookLoan.setReturnDate(Date.valueOf(LocalDate.now().plusDays(30)));

        bookLoansRepository.save(bookLoan);

        return "Wypożyczono " + title + " o sygnaturze " + firstAvailableBook.getSignature() + " czytelnikowi " + nickName;

    }

    public String returnBook(int signature, String nickName) {

        int copyofBookIdBySignature = copiesOfBooksRepository.getCopyofBookIdBySignature(signature);
        copiesOfBooksRepository.updateStatus(copyofBookIdBySignature, "dostępna");
        bookLoansRepository.deleteByCopyOfBookId(copyofBookIdBySignature);

        return "Czytelnik " + nickName + " oddał książkę o sygnaturze " + signature;
    }

}
