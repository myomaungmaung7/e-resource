package com.intern.book.controller;

import com.intern.book.dto.BookTypesDTO;
import com.intern.book.service.BookTypesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book-types")
@RequiredArgsConstructor
public class BookTypesController {
    private final BookTypesService bookTypesService;

    @PostMapping
    public ResponseEntity<?> saveBookTypes(@RequestBody BookTypesDTO bookTypesDTO) {
        return ResponseEntity.ok(bookTypesService.saveBookTypes(bookTypesDTO));
    }
}
