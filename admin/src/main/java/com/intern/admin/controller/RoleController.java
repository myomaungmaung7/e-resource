package com.intern.admin.controller;

import com.intern.admin.dto.RoleDTO;
import com.intern.admin.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("role-con")
public class RoleController {

    private final RoleService roleService;

    @PostMapping("save-role")
    public ResponseEntity<?> saveRole(@RequestBody RoleDTO roleDTO) {
        return ResponseEntity.ok(roleService.saveEntity(roleDTO));
    }

    @PostMapping("/roles/{roleId}/permissions/{permissionId}")
    public ResponseEntity<RoleDTO> addPermission(@RequestBody @RequestParam Long roleId, @RequestParam List<Long> permissionIds) {
        return ResponseEntity.ok(roleService.addPermission(roleId, permissionIds));
    }
}
