package com.intern.book.service.impl;

import com.intern.book.dto.BookDTO;
import com.intern.book.dto.BookTypesDTO;
import com.intern.book.dto.CollectionDTO;

import com.intern.book.entity.Book;
import com.intern.book.entity.BookTypes;
import com.intern.book.entity.Collection;
import com.intern.book.mapper.BookMapper;

import com.intern.book.mapper.BookTypesMapper;
import com.intern.book.mapper.CollectionMapper;
import com.intern.book.repository.BookRepository;
import com.intern.book.repository.BookTypesRepository;
import com.intern.book.repository.CollectionRepository;
import com.intern.book.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;


import java.util.List;

@RequiredArgsConstructor
@Service
public class BookServiceImpl implements BookService {
    final BookRepository bookRepository;
    private final CollectionRepository collectionRepository;

    private final BookTypesRepository bookTypesRepository;

    @Override
    public BookDTO saveBook(BookDTO bookDTO) {
        //saveEntity
        final Book book = bookRepository.save(BookMapper.dtoToEntity(bookDTO));

        //search from database using bookDTO.getCollectionId()
        Collection collection = collectionRepository.findById(bookDTO.getCollectionId()).orElseThrow();
        collection.add(book);
        collectionRepository.save(collection);
        CollectionDTO collectionDTO = CollectionMapper.entityToDTO(collection);
       // ResponseDTO responseDTO = CollectionMapper.response(collection);

        //search from database using bookDTO.getBookTypesDTO()
        BookTypes bookTypes = bookTypesRepository.findById(bookDTO.getTypesId()).orElseThrow();
        bookTypes.add(book);
        bookTypesRepository.save(bookTypes);
        BookTypesDTO bookTypesDTO = BookTypesMapper.entityToDTO(bookTypes);

        //response Data
        BookDTO bookDTO1 = BookMapper.entityToDTO(book);
        bookDTO1.setCollectionDTO(collectionDTO);
      //  bookDTO1.setCollectionResponseDTO(responseDTO);
        bookDTO1.setBookTypesDTO(bookTypesDTO);

        return bookDTO1;
    }

    public BookDTO getBookById(Long id) {
        final Book book = bookRepository.findById(id).orElse(null);
        if (ObjectUtils.isEmpty(book.getCollection())) {
            book.setCollection(new Collection());
        }
        if (ObjectUtils.isEmpty(book.getBookTypes())) {
            book.setBookTypes(new BookTypes() );
        }
        return BookMapper.entityToDTO(book);
    }

    @Override
    public List<BookDTO> getAllBooks() {
        List<Book> books=bookRepository.findAll();

        return BookMapper.entityToDTOList(books);
    }

    @Override
    public BookDTO updateBook(Long bookId, BookDTO bookDTO) {

        Collection collection=collectionRepository.findById(bookDTO.getCollectionId()).orElseThrow();
      //  CollectionDTO collectionDTO = CollectionMapper.entityToDTO(collection);

        BookTypes bookTypes=bookTypesRepository.findById(bookDTO.getTypesId()).orElseThrow();
      //  BookTypesDTO bookTypesDTO = BookTypesMapper.entityToDTO(bookTypes);

        Book existingBook = bookRepository.findById(bookId)
                .orElseThrow(() -> new RuntimeException("Book not found"));
        existingBook.setBookTypes(bookTypes);
        existingBook.setCollection(collection);

        // Save the updated book back to the database
        Book updatedBook = bookRepository.save(existingBook);
        BookDTO bookDTO1 = BookMapper.entityToDTO(updatedBook);


        return bookDTO1;
    }

    @Override
    public void deleteBook(Long bookId) {
        bookRepository.deleteById(bookId);
    }

}

