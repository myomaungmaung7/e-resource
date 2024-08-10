package com.intern.admin.service.Impl;

import com.intern.admin.dto.RoleDTO;
import com.intern.admin.entity.Permission;
import com.intern.admin.entity.Role;
import com.intern.admin.mapper.RoleMapper;
import com.intern.admin.mapper.RolePermissionMapper;
import com.intern.admin.repository.PermissionRepository;
import com.intern.admin.repository.RoleRepository;
import com.intern.admin.service.RoleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    private final PermissionRepository permissionRepository;

    private RolePermissionMapper rolePermissionMapper;

    @Override
    public RoleDTO saveEntity(RoleDTO roleDTO) {
        if (roleRepository.existsByRoleName(roleDTO.getRoleName().toUpperCase()))
            throw new RuntimeException("Role already exists");
        Role role = roleRepository.save(RoleMapper.dtoToEntity(roleDTO));
        return RoleMapper.entityToDto(role);
    }

    @Override
    @Transactional
    public RoleDTO addPermission(Long roleId, List<Long> permissionIds) {
        Optional<Role> roleOptional = roleRepository.findById(roleId);
        if (!roleOptional.isPresent()) {
            throw new RuntimeException("Role not found");
        }
        Role role = roleOptional.get();

        for (Long permissionId : permissionIds) {
            Optional<Permission> permissionOpt = permissionRepository.findById(permissionId);
            if (!permissionOpt.isPresent()) {
                throw new RuntimeException("Permission not found");
            }
            Permission permission = permissionOpt.get();

            if (role.getPermissions().contains(permission)) {
                throw new RuntimeException(String.format("Permission already exists"));
            }

            role.getPermissions().add(permission);
        }
        roleRepository.save(role);
        log.info(String.format("Permission added: %s", permissionIds, roleId));
        return rolePermissionMapper.entityToDto(role);
    }

}
