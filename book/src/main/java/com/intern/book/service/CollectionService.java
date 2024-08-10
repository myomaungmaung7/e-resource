package com.intern.book.service;

import com.intern.book.dto.CollectionDTO;

public interface CollectionService {
    CollectionDTO saveCollection(CollectionDTO collectionDTO);

    String delete(Long collectionId);
}
