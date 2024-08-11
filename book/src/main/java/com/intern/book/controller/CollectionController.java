package com.intern.book.controller;

import com.intern.book.dto.CollectionDTO;
import com.intern.book.entity.Book;
import com.intern.book.entity.Collection;
import com.intern.book.repository.BookRepository;
import com.intern.book.repository.CollectionRepository;
import com.intern.book.service.CollectionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/col-con")
@RequiredArgsConstructor
public class CollectionController {
    private final CollectionService collectionService;
    private final CollectionRepository collectionRepository;
    private final BookRepository bookRepository;

    @PostMapping
    public ResponseEntity<?> saveCollection(@RequestBody CollectionDTO collectionDTO) {
        return ResponseEntity.ok(collectionService.saveCollection(collectionDTO));
    }
    @DeleteMapping
    public ResponseEntity<?> deleteCollection(@RequestParam Long collectionId) {
        Optional<Collection> collection=collectionRepository.findById(collectionId);

       if (collection.isPresent()) {
           Collection collection1=collection.get();
           List<Book> books=collection1.getBooks();

           for (Book book : books) {
               book.setCollection(null);
               bookRepository.save(book);
           }

       }
        return ResponseEntity.ok(collectionService.delete(collectionId));
    }

}
