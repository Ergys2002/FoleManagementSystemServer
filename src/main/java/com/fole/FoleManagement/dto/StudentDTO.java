package com.fole.FoleManagement.dto;

import com.fole.FoleManagement.entities.Student;
import lombok.Data;

import java.util.Optional;

@Data
public class StudentDTO {
    private String id;
    private String emriDheMbiemri;

    private String dhoma_id;

    public StudentDTO(Optional<Student> student) {
        this.id = student.get().getId();
        this.emriDheMbiemri = student.get().getEmri() + " " + student.get().getMbiemri();
        this.dhoma_id = student.get().getDhoma_id();
    }
}
