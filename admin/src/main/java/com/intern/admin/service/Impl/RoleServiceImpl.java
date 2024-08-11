package com.intern.admin.service.Impl;

import com.intern.admin.dto.AddPermissionDTO;
import com.intern.admin.dto.PermissionDTO;
import com.intern.admin.dto.RoleDTO;
import com.intern.admin.entity.Permission;
import com.intern.admin.entity.Role;
import com.intern.admin.mapper.RoleMapper;
import com.intern.admin.repository.PermissionRepository;
import com.intern.admin.repository.RoleRepository;
import com.intern.admin.service.RoleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    private final PermissionRepository permissionRepository;

    @Override
    public RoleDTO saveEntity(RoleDTO roleDTO) {
        if (roleRepository.existsByRoleName(roleDTO.getRoleName().toUpperCase()))
            throw new RuntimeException("Role already exists");
        Role role = roleRepository.save(RoleMapper.dtoToEntity(roleDTO));
        return RoleMapper.entityToDto(role);
    }

    @Override
    public String addPermission(AddPermissionDTO addPermissionDTO) {
        Role role = roleRepository.findById(addPermissionDTO.getRoleId()).orElse(null);
        List<Permission> permissions = new ArrayList<>();
        addPermissionDTO.getPermissionIds().forEach(permissionId -> {
            Permission permission = permissionRepository.findById(permissionId).orElse(null);
            permissions.add(permission);
        });
            role.setPermissions(permissions);

        return ObjectUtils.isEmpty(roleRepository.save(role))?"success":"failed";
    }

    @Override
    @Transactional
    public RoleDTO getPermissionsByRoleId(Long roleId) {
        Role role = roleRepository.findById(roleId)
                .orElseThrow(() -> new RuntimeException("Role not found"));
        return RoleMapper.entityToDto(role);
    }
}
