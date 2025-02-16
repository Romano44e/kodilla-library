package com.crud.library.controller;

import com.crud.library.domain.loans.BorrowRequestDto;
import com.crud.library.domain.loans.ReturnRequestDto;
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

    @DeleteMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> returnBook(@RequestBody ReturnRequestDto returnRequestDto) {
        int signature = returnRequestDto.getSignature();
        String nickName = returnRequestDto.getNickName();

        String response = borrowsService.returnBook(signature, nickName);

        return ResponseEntity.ok(response);
    }

}
