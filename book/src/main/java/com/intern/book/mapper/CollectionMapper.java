package com.intern.book.mapper;

import com.intern.book.dto.CollectionDTO;
import com.intern.book.dto.ResponseDTO;
import com.intern.book.entity.Collection;
import com.intern.book.util.DateUtils;
import org.springframework.util.ObjectUtils;

public class CollectionMapper {
    public static Collection dtoToEntity(final CollectionDTO collectionDTO) {
        return Collection.builder()
                .id(collectionDTO.getId())
                .name(collectionDTO.getName())
                .createDate(ObjectUtils.isEmpty(collectionDTO.getCreateDate())
                        ? DateUtils.getNowDate()
                        : DateUtils.stringToLongDate(collectionDTO.getCreateDate()))
                .build();
    }

    public static CollectionDTO entityToDTO(final Collection collection) {
        return CollectionDTO.builder()
                .id(collection.getId())
                .name(collection.getName())
                .createDate(DateUtils.longToStringDate(collection.getCreateDate()))
                .build();
    }

    public static ResponseDTO response(Collection collection) {
        return ResponseDTO.builder()
                .name(collection.getName())
                .build();
    }
}
