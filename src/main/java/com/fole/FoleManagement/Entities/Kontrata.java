package com.fole.FoleManagement.Entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "kontrata")
public class Kontrata {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer document_id;

    @Column
    private String student_id;

    @Lob
    @Column
    private byte[] pdf_file;

}

