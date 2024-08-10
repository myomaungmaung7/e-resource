package com.intern.admin.entity;

import jakarta.persistence.*;
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
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String userName;

    private String password;

    private String email;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user",
            cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    private List<Role> roles;

    public void add(Role tempRole) {
        if (roles == null) {
            roles = new ArrayList<>();
        }
        roles.add(tempRole);
        tempRole.setUser(this);
    }
}
