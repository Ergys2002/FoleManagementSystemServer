package com.fole.FoleManagement.Entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "dhoma")
@Entity
public class Dhoma {
    @Id
    private String id;

    @Column
    private String tipi;

    @Column
    private Integer kapaciteti;

    @Column
    private Boolean zene;

    @Column
    private Integer studente_ne_dhome;

}
