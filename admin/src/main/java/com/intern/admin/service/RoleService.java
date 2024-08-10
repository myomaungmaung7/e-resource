package com.intern.admin.service;

import com.intern.admin.dto.RoleDTO;

import java.util.List;

public interface RoleService {
    RoleDTO saveEntity(RoleDTO roleDTO);

    RoleDTO addPermission(Long roleId, List<Long> permissionIds);
}
