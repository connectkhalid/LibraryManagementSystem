package com.khalid.librarymanagementsystem.entity;

import jakarta.persistence.*;
import lombok.*;
@Data
@Builder
@Entity
@Table(name = "role_entity")
@NoArgsConstructor
@AllArgsConstructor
public class RoleEntity {
    @Id
    @Column(name = "role_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.UUID)
    private String roleId;
    private String roleName;
}