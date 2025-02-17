package com.crud.library.controller;

import com.crud.library.domain.loans.BorrowRequestDto;
import com.crud.library.domain.loans.BorrowResponseDto;
import com.crud.library.domain.loans.ReturnRequestDto;
import com.crud.library.domain.loans.ReturnResponseDto;
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
    public ResponseEntity<BorrowResponseDto> borrowBook(@RequestBody BorrowRequestDto borrowRequestDto) {
        String title = borrowRequestDto.getTitle();
        String nickName = borrowRequestDto.getNickName();

        BorrowResponseDto borrowResponseDto = borrowsService.borrowBook(title, nickName);
        return ResponseEntity.ok(borrowResponseDto);
    }

    @PutMapping (consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ReturnResponseDto> returnBook(@RequestBody ReturnRequestDto returnRequestDto) {
        int signature = returnRequestDto.getSignature();
        String nickName = returnRequestDto.getNickName();

        ReturnResponseDto returnResponseDto = borrowsService.returnBook(signature, nickName);

        return ResponseEntity.ok(returnResponseDto);
    }

}
