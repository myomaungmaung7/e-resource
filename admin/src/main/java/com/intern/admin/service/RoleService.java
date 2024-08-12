package com.intern.admin.service;

import com.intern.admin.dto.AddPermissionDTO;
import com.intern.admin.dto.RoleDTO;


public interface RoleService {
    RoleDTO saveEntity(RoleDTO roleDTO);

    String addPermission( AddPermissionDTO addPermissionDTO);
    

    RoleDTO getPermissionsByRoleId(Long roleId);

    void removePermissionsByRoleId(Long roleId, Long permissionId);


}
