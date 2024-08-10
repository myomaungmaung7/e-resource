package com.intern.admin.mapper;

import com.intern.admin.dto.RoleDTO;
import com.intern.admin.entity.Role;

public class RoleMapper {

    public static Role dtoToEntity(RoleDTO dto) {
        return Role.builder()
                .description(dto.getRoleDesc())
                .roleName(dto.getRoleName().toUpperCase())
                .build();
    }

    public static RoleDTO entityToDto(Role entity) {
        return RoleDTO.builder()
                .roleId(entity.getRoleId())
                .roleName(entity.getRoleName())
                .roleDesc(entity.getDescription())
                .build();
    }
}
