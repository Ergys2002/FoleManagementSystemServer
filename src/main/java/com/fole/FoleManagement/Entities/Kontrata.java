package com.fole.FoleManagement.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "kontrata")
public class Kontrata {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer document_id;

    @Lob
    @Column
    private byte[] pdf_file;

    @Column
    private String dhoma_id;

}

