package com.synergisticit.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Users {


    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long userId;

    @NonNull
    private String username;

    @NonNull
    private String password;

    @NonNull
    private boolean enabled;
}
