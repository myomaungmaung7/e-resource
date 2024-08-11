package com.intern.book.controller;

import com.intern.book.dto.BookTypesDTO;
import com.intern.book.entity.Book;
import com.intern.book.entity.BookTypes;

import com.intern.book.repository.BookRepository;
import com.intern.book.repository.BookTypesRepository;
import com.intern.book.service.BookTypesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/book-types")
@RequiredArgsConstructor
public class BookTypesController {
    private final BookTypesService bookTypesService;
    private final BookTypesRepository bookTypesRepository;
    private final BookRepository bookRepository;

    @PostMapping
    public ResponseEntity<?> saveBookTypes(@RequestBody BookTypesDTO bookTypesDTO) {
        return ResponseEntity.ok(bookTypesService.saveBookTypes(bookTypesDTO));
    }
    @DeleteMapping
    public ResponseEntity<?> deleteBookTypes(@RequestParam Long bookTypesId) {


        Optional<BookTypes> bookTypes=bookTypesRepository.findById(bookTypesId);

        if (bookTypes.isPresent()) {
            BookTypes bookTypes1=bookTypes.get();
            List<Book> books=bookTypes1.getBooks();

            for (Book book : books) {
                book.setBookTypes(null);
                bookRepository.save(book);
            }

        }
        return ResponseEntity.ok(bookTypesService.delete(bookTypesId));
    }
}
