package com.fole.FoleManagement.entities;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Table(name = "student")
@Entity
public class Student {

    @Id
    private String id;

    @Column
    private String emri;

    @Column
    private String mbiemri;

    @Column
    private String telefon;

    @Column
    private String email;

    @Column
    private Integer tarifa_mujore = 0;

    @Column
    private Integer detyrime_total;

    @Column
    private LocalDate data_fillimit;

    @Column
    private LocalDate data_mbarimit;

    @Column
    private String dhoma_id; //vendose by default Bosh

    @Column
    private Boolean enabled;
}
