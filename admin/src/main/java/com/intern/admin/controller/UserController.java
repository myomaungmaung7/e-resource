package com.intern.admin.controller;

import com.intern.admin.dto.UserDTO;
import com.intern.admin.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1")
public class UserController {

    private final UserService userService;

    @PostMapping("save-user")
    public ResponseEntity<UserDTO> saveUser(@RequestBody UserDTO userDTO) {
        userDTO.setDisable(true);
        UserDTO savedUser = userService.saveUser(userDTO);
        return ResponseEntity.ok(savedUser);
    }

    @PutMapping("update-user")
    public ResponseEntity<UserDTO> updateUser(@RequestParam Long userId, @RequestBody UserDTO userDTO) {
        UserDTO updatedUser = userService.updateUser(userId, userDTO);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("delete-user")
    public ResponseEntity<Void> deleteUser(@RequestParam Long userId) {
        userService.deleteUser(userId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("disable")
    public ResponseEntity<List<UserDTO>> getUsersByDisabled(@RequestParam boolean disable) {
        List<UserDTO> users = userService.getUsersByDisableStatus(disable);
        return ResponseEntity.ok(users);
    }

    @GetMapping("user-disable")
    public ResponseEntity<UserDTO> getUserIfDisabled(@RequestParam Long userId) {
        Optional<UserDTO> userDTO = userService.getUserIfDisabled(userId);
        return userDTO.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
