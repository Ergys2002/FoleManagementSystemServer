package com.fole.FoleManagement.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "user")
@Data
public class User {
    @Id
    private Integer id;

    @Column
    private String username;

    @Column
    private String password;
}