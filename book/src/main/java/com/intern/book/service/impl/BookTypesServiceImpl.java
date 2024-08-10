package com.intern.book.service.impl;

import com.intern.book.dto.BookTypesDTO;
import com.intern.book.entity.BookTypes;
import com.intern.book.entity.Collection;
import com.intern.book.mapper.BookTypesMapper;
import com.intern.book.mapper.CollectionMapper;
import com.intern.book.repository.BookTypesRepository;
import com.intern.book.service.BookTypesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BookTypesServiceImpl implements BookTypesService {
    private final BookTypesRepository bookTypesRepository;

    @Override
    public BookTypesDTO saveBookTypes(BookTypesDTO bookTypesDTO) {
       if (bookTypesRepository.existsByName(bookTypesDTO.getName())) {
           throw new RuntimeException("BookTypes already exists");
        }
        final BookTypes bookTypes = bookTypesRepository.save(BookTypesMapper.dtoToEntity(bookTypesDTO));
        return BookTypesMapper.entityToDTO(bookTypes);
    }
}
