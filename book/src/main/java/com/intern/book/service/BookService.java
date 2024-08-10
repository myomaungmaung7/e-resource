package com.intern.book.service;

import com.intern.book.dto.BookDTO;

import java.util.List;

public interface BookService {
    BookDTO saveBook(BookDTO bookDTO);
    BookDTO getBookById(Long id);
    List<BookDTO> getAllBooks();
    BookDTO updateBook(Long bookId,BookDTO bookDTO);
   // void deleteBook(Long bookId);
}
