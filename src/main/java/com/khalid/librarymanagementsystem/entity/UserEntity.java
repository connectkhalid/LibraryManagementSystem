package com.khalid.librarymanagementsystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "user_entity")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String userId;
    private String firstName, lastName, email, password, address;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_entity_roles",
            joinColumns = @JoinColumn(name = "userEntity_userId"))
    private Set<RoleEntity> roles;
}
