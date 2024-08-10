package com.intern.admin.mapper;

import com.intern.admin.dto.PermissionDTO;
import com.intern.admin.entity.Permission;
import com.intern.admin.utils.DateUtils;
import org.springframework.util.ObjectUtils;

public class PermissionMapper {

    public static Permission dtoToEntity(PermissionDTO dto) {
        return Permission.builder()
                .name(dto.getName().toUpperCase())
                .description(dto.getDescription())
                .form(dto.getForm())
                .createdDate(ObjectUtils.isEmpty(dto.getCreateDate())
                        ?DateUtils.getNowDate()
                        :DateUtils.stringToLongDate(dto.getCreateDate()))
                .build();
    }

    public static PermissionDTO entityToDto(Permission entity) {
        return PermissionDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .description(entity.getDescription())
                .form(entity.getForm())
                .createDate(DateUtils.longToStringDate(entity.getCreatedDate()))
                .build();
    }
}
