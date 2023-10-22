package com.khalid.onlinebooklibraryapplication.entity;

import jakarta.persistence.*;
import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Getter
@Setter
@Table(name = "user")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;
    @NonNull
    private String firstName;
    private String lastName;
    private String address;
    @NonNull
    private String email;
    @NonNull
    private String password;
    @NonNull
    private String role;
}
