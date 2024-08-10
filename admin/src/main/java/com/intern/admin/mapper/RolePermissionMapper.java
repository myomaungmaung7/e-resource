package com.intern.admin.mapper;

import com.intern.admin.dto.PermissionDTO;
import com.intern.admin.dto.RoleDTO;
import com.intern.admin.entity.Permission;
import com.intern.admin.entity.Role;

import java.util.List;
import java.util.stream.Collectors;

public class RolePermissionMapper {

    public RoleDTO entityToDto(Role entity) {
        return RoleDTO.builder()
                .roleId(entity.getRoleId())
                .roleName(entity.getRoleName())
                .roleDesc(entity.getDescription())
                .permissionsDTO(entity.getPermissions().stream()
                        .map(this::permissionToPermissionDTO)
                        .collect(Collectors.toList()))
                .build();
    }

    public Role dtoToEntity(RoleDTO dto) {
        Role role = new Role();
        role.setRoleId(dto.getRoleId());
        role.setRoleName(dto.getRoleName());
        role.setDescription(dto.getRoleDesc());
        role.setPermissions(dto.getPermissionsDTO().stream()
                .map(this::permissionDTOToPermission)
                .collect(Collectors.toList())
        );
        return role;
    }

    public PermissionDTO permissionToPermissionDTO(Permission permission) {
        return PermissionDTO.builder()
                .id(permission.getId())
                .description(permission.getDescription())
                .form(permission.getForm())
                .name(permission.getName())
                .build();
    }

    public Permission permissionDTOToPermission(PermissionDTO permissionDTO) {
        Permission permission = new Permission();
        permission.setId(permissionDTO.getId());
        permission.setDescription(permissionDTO.getDescription());
        permission.setForm(permissionDTO.getForm());
        permission.setName(permissionDTO.getName());
        return permission;
    }
}
