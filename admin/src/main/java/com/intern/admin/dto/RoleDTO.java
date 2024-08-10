package com.intern.admin.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RoleDTO {

    private String roleName;
    private String roleDesc;
    private Long roleId;
    private List<PermissionDTO> permissionsDTO = new ArrayList<>();
}
