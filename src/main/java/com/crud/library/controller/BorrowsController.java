package com.crud.library.controller;

import com.crud.library.domain.loans.BorrowRequestDto;
import com.crud.library.service.BorrowsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/library/borrows")
@RequiredArgsConstructor
public class BorrowsController {

    private final BorrowsService borrowsService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> borrowBook(@RequestBody BorrowRequestDto borrowRequestDto) {
        String title = borrowRequestDto.getTitle();
        String nickName = borrowRequestDto.getNickName();

        String response = borrowsService.borrowBook(title, nickName);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("{signature}")
    public String delete(@PathVariable String signature) {
        return "The book signatured " + signature + " returned successfully!";
    }

}
