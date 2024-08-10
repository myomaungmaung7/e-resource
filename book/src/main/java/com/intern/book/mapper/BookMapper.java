package com.intern.book.mapper;
import com.intern.book.dto.BookDTO;
import com.intern.book.entity.Book;
import com.intern.book.entity.BookTypes;
import com.intern.book.entity.Collection;
import com.intern.book.repository.BookTypesRepository;
import com.intern.book.repository.CollectionRepository;
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
    public static void updateEntityFromDTO(final BookDTO bookDTO, final Book book) {
        if (bookDTO == null || book == null) {
            return;
        }

        book.setMainTitle(bookDTO.getMainTitle());
        book.setSubtitle(bookDTO.getSubtitle());
        book.setAuthor(bookDTO.getAuthor());
        book.setPublisher(bookDTO.getPublisher());
        book.setPublisherYear(DateUtils.stringToLongDate(bookDTO.getPublisherYear()));

        // If the collection is being updated:
        if (bookDTO.getCollectionDTO() != null) {
            Collection collection = CollectionMapper.dtoToEntity(bookDTO.getCollectionDTO());
            book.setCollection(collection);
        }
        if(bookDTO.getBookTypesDTO()!=null){
            BookTypes bookTypes=BookTypesMapper.dtoToEntity(bookDTO.getBookTypesDTO());
            book.setBookTypes(bookTypes);
        }
    }

}
