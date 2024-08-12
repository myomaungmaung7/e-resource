package com.intern.admin.controller;

import com.intern.admin.dto.AddPermissionDTO;
import com.intern.admin.dto.RoleDTO;
import com.intern.admin.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("role-con")
public class RoleController {

    private final RoleService roleService;

    @PostMapping("save-role")
    public ResponseEntity<?> saveRole(@RequestBody RoleDTO roleDTO) {
        return ResponseEntity.ok(roleService.saveEntity(roleDTO));
    }

    @PostMapping("add-permission")
    public ResponseEntity<String> addPermission(@RequestBody AddPermissionDTO addPermissionDTO) {
        return ResponseEntity.ok(roleService.addPermission(addPermissionDTO));
    }

    @GetMapping("/{roleId}/permissions")
    public ResponseEntity<RoleDTO> getPermissionsByRoleId(@PathVariable Long roleId) {
        RoleDTO roleDTO = roleService.getPermissionsByRoleId(roleId);
        return ResponseEntity.ok(roleDTO);
    }

    @DeleteMapping("/{roleId}/permissions/{permissionId}")
    public ResponseEntity<Void> removePermissionsByRoleId(@PathVariable Long roleId, @PathVariable Long permissionId) {
        roleService.removePermissionsByRoleId(roleId, permissionId);
        return ResponseEntity.noContent().build();
    }
}
