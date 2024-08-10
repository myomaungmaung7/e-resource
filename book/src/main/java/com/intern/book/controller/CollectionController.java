package com.intern.book.controller;

import com.intern.book.dto.CollectionDTO;
import com.intern.book.service.CollectionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/col-con")
@RequiredArgsConstructor
public class CollectionController {
    private final CollectionService collectionService;

    @PostMapping
    public ResponseEntity<?> saveCollection(@RequestBody CollectionDTO collectionDTO) {
        return ResponseEntity.ok(collectionService.saveCollection(collectionDTO));
    }
    @DeleteMapping
    public ResponseEntity<?> deleteCollection(@RequestParam Long collectionId) {
        return ResponseEntity.ok(collectionService.delete(collectionId));

    }

}
