package com.fole.FoleManagement.dto;

import com.fole.FoleManagement.Entities.Dhoma;
import com.fole.FoleManagement.Entities.Student;
import lombok.Data;

import java.util.List;
import java.util.Optional;

@Data
public class dhomaDTO extends Dhoma {
    private Integer size;
    private List<Student> students;


    public dhomaDTO(Optional<Dhoma> dhoma, List<Student> list) {
        setId(dhoma.get().getId());
        setZene(dhoma.get().getZene());
        setTipi(dhoma.get().getTipi());
        setKapaciteti(dhoma.get().getKapaciteti());
        setStudente_ne_dhome(dhoma.get().getStudente_ne_dhome());
        setStudents(list);
        setSize(list.size());
    }
}
