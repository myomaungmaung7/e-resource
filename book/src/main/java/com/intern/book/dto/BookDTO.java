package com.intern.book.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.intern.book.entity.Book;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookDTO {
    private Long bookId;
    private String mainTitle;
    private String subtitle;
    private String author;
    private String publisher;
    private String  publisherYear;

    private Long  collectionId;
    private CollectionDTO collectionDTO;

  //  private ResponseDTO collectionResponseDTO;

    private Long typesId;
    private BookTypesDTO bookTypesDTO;
    @JsonIgnore
    private String collectionName;
    @JsonIgnore
    private List<Book> books;
}
