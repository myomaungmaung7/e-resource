package com.intern.admin.controller;

import com.intern.admin.dto.PermissionDTO;
import com.intern.admin.service.PermissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("per-con")
public class PermissionController {

    private final PermissionService permissionService;

    @PostMapping
    public ResponseEntity<?> savePermission(@RequestBody PermissionDTO permissionDTO) {
        return ResponseEntity.ok(permissionService.saveEntity(permissionDTO));
    }
}
