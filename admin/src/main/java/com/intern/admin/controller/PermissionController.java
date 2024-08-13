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

    @PostMapping
    public ResponseEntity<?> savePermission(@RequestBody PermissionDTO permissionDTO) {
        return ResponseEntity.ok(permissionService.saveEntity(permissionDTO));
    }

    @DeleteMapping("/permissions/{permissionId}")
    public ResponseEntity<Void> deletePermission(@PathVariable Long permissionId) {
        permissionService.deletePermission(permissionId);
        return ResponseEntity.noContent().build();
    }
}
