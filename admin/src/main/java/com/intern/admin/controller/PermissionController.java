package com.intern.admin.controller;

import com.intern.admin.dto.PermissionDTO;
import com.intern.admin.service.PermissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("per-con")
public class PermissionController {

    private final PermissionService permissionService;

    @PostMapping("save-permission")
    public ResponseEntity<?> savePermission(@RequestBody PermissionDTO permissionDTO) {
        return ResponseEntity.ok(permissionService.saveEntity(permissionDTO));
    }

    @DeleteMapping("delete-permissions")
    public ResponseEntity<Void> deletePermission(@RequestParam Long permissionId) {
        permissionService.deletePermission(permissionId);
        return ResponseEntity.noContent().build();
    }
}
