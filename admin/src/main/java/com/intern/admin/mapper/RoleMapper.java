package com.intern.admin.mapper;

import com.intern.admin.dto.PermissionDTO;
import com.intern.admin.dto.RoleDTO;
import com.intern.admin.entity.Permission;
import com.intern.admin.entity.Role;

import java.util.List;
import java.util.stream.Collectors;

public class RoleMapper {

    public static Role dtoToEntity(RoleDTO dto) {
        return Role.builder()
                .description(dto.getRoleDesc())
                .roleName(dto.getRoleName().toUpperCase())
                .build();
    }

    public static RoleDTO entityToDto(Role entity) {
        List<PermissionDTO> permissionDTOS = entity.getPermissions().stream()
                .map(permission -> PermissionDTO.builder()
                        .id(permission.getId())
                        .name(permission.getName())
                        .form(permission.getForm())
                        .description(permission.getDescription())
                        .build())
                        .collect(Collectors.toList());

        return RoleDTO.builder()
                .roleId(entity.getRoleId())
                .roleName(entity.getRoleName())
                .roleDesc(entity.getDescription())
                .permissionDTOS(permissionDTOS)
                .build();
    }
}
