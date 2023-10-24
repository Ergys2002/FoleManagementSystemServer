package com.fole.FoleManagement.dto;

import com.fole.FoleManagement.entities.Dhoma;
import com.fole.FoleManagement.entities.Kontrata;
import com.fole.FoleManagement.entities.Student;
import lombok.Data;

import java.util.List;
import java.util.Optional;

@Data
public class DhomaDTO extends Dhoma {
    private Integer size;
    private List<Student> students;
    //todo: add kontrata to dto
//    private Kontrata kontrata;


    public DhomaDTO(Optional<Dhoma> dhoma, List<Student> list) {
        setId(dhoma.get().getId());
        setZene(dhoma.get().getZene());
        setTipi(dhoma.get().getTipi());
        setKapaciteti(dhoma.get().getKapaciteti());
        setStudente_ne_dhome(dhoma.get().getStudente_ne_dhome());
        setStudents(list);
        setSize(list.size());
    }
}
