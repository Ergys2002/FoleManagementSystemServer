package com.fole.FoleManagement.Entities;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "user")
@Data
public class User {
    @Id
    private Integer id;

    @Column
    private String username;

    @Column
    private Integer password;
}