package com.intern.book.service.impl;

import com.intern.book.dto.CollectionDTO;
import com.intern.book.entity.Collection;
import com.intern.book.mapper.CollectionMapper;
import com.intern.book.repository.CollectionRepository;
import com.intern.book.service.CollectionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CollectionServiceImpl implements CollectionService {

    private final CollectionRepository collectionRepository;
    @Override
    public CollectionDTO saveCollection(CollectionDTO collectionDTO) {
        if (collectionRepository.existsByName(collectionDTO.getName())){
             throw new RuntimeException("Collection already exists");
        }
        final Collection collection=   collectionRepository.save(CollectionMapper.dtoToEntity(collectionDTO));
        return CollectionMapper.entityToDTO(collection);
    }

    @Override
    public String delete(Long collectionId) {
      collectionRepository.deleteById(collectionId);
      return collectionRepository.existsById(collectionId)?"Fail!":"Success";
    }

}
