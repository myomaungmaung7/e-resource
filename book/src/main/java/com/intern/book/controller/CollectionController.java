package com.intern.book.controller;

import com.intern.book.dto.CollectionDTO;
import com.intern.book.service.CollectionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/col-con")
@RequiredArgsConstructor
public class CollectionController {
    private final CollectionService collectionService;

    @PostMapping
    public ResponseEntity<?> saveCollection(@RequestBody CollectionDTO collectionDTO) {
        return ResponseEntity.ok(collectionService.saveCollection(collectionDTO));
    }

}
