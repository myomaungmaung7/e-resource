package com.intern.admin.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private Long userId;
    private String name;
    private String userName;
    private String password;
    private String email;
    private boolean disable;
    private List<RoleDTO> roles;
}
