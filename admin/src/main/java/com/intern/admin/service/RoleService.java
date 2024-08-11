package com.intern.admin.service;

import com.intern.admin.dto.AddPermissionDTO;
import com.intern.admin.dto.PermissionDTO;
import com.intern.admin.dto.RoleDTO;

import java.util.List;

public interface RoleService {
    RoleDTO saveEntity(RoleDTO roleDTO);

    String addPermission( AddPermissionDTO addPermissionDTO);

    RoleDTO getPermissionsByRoleId(Long roleId);
}
