package com.intern.book.mapper;
import com.intern.book.dto.BookDTO;

import com.intern.book.entity.Book;
import com.intern.book.util.DateUtils;
import org.springframework.util.ObjectUtils;
import java.util.List;
import java.util.stream.Collectors;


public class BookMapper {




    public static Book dtoToEntity(final BookDTO bookDTO) {

        Book.BookBuilder bookBuilder = Book.builder()
                .bookId(bookDTO.getBookId())
                .author(bookDTO.getAuthor())
                .mainTitle(bookDTO.getMainTitle())
                .publisher(bookDTO.getPublisher())

                //.collection(CollectionMapper.dtoToEntity(bookDTO.getCollectionDTO()))
                //.bookTypes(BookTypesMapper.dtoToEntity(bookDTO.getBookTypesDTO()))
                .publisherYear(ObjectUtils.isEmpty(bookDTO.getPublisherYear())
                        ? DateUtils.getNowDate()
                        : DateUtils.stringToLongDate(bookDTO.getPublisherYear()))
                .subtitle(bookDTO.getSubtitle());



        return bookBuilder.build();
    }
    public static BookDTO entityToDTO(final Book book) {
        BookDTO.BookDTOBuilder bookDTOBuilder = BookDTO.builder()
                .bookId(book.getBookId())
                .author(book.getAuthor())
                .mainTitle(book.getMainTitle())
                .publisher(book.getPublisher())
                .collectionDTO(CollectionMapper.entityToDTO(book.getCollection()))
                .bookTypesDTO(BookTypesMapper.entityToDTO(book.getBookTypes()))
                .publisherYear(ObjectUtils.isEmpty(book.getPublisherYear())
                        ? String.valueOf(DateUtils.getNowDate())
                        : DateUtils.longToStringDate(book.getPublisherYear()))
                .subtitle(book.getSubtitle());
        return bookDTOBuilder.build();
    }
    public static List<BookDTO> entityToDTOList(final List<Book> books) {
        return books.stream()
                .map(BookMapper::entityToDTO)
                .collect(Collectors.toList());

    }
}
