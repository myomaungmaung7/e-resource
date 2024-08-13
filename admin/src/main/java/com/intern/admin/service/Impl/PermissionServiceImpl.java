package com.intern.admin.service.Impl;

import com.intern.admin.dto.PermissionDTO;
import com.intern.admin.entity.Permission;
import com.intern.admin.mapper.PermissionMapper;
import com.intern.admin.repository.PermissionRepository;
import com.intern.admin.service.PermissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PermissionServiceImpl implements PermissionService {

    private final PermissionRepository permissionRepository;

    @Override
    public PermissionDTO saveEntity(PermissionDTO permissionDTO) {
        if (permissionRepository.existsByName(permissionDTO.getName().toUpperCase()))
            throw new RuntimeException("save permission already exist");
        Permission permission = permissionRepository.save(PermissionMapper.dtoToEntity(permissionDTO));
        return PermissionMapper.entityToDto(permission);
    }

    @Override
    public void deletePermission(Long permissionId) {
        Permission permission = permissionRepository.findById(permissionId)
                .orElseThrow(() -> new RuntimeException("permission not found"));

        permissionRepository.delete(permission);
    }
}
