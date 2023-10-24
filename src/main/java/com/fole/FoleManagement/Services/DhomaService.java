package com.fole.FoleManagement.services;

import com.fole.FoleManagement.entities.Dhoma;
import com.fole.FoleManagement.entities.Kontrata;
import com.fole.FoleManagement.entities.Student;
import com.fole.FoleManagement.repositories.DhomaRepository;
import com.fole.FoleManagement.repositories.KontrataRepository;
import com.fole.FoleManagement.repositories.StudentRepository;
import com.fole.FoleManagement.dto.DhomaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DhomaService {

    @Autowired
    private DhomaRepository dhomaRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private KontrataRepository kontrataRepository;

    public List<Dhoma> dhomaKati(String ndertesa, Integer kati){
        List<Dhoma> dhomaList = dhomaRepository.findAll();
        //TODO: merr me query dhomat e nderteses dhe katit

        List<Dhoma> dhomatReturn = new ArrayList<>();

        for (int i = 0; i < dhomaList.size(); i++){
            //ndan me regex ne 2 pjese id tone, [building, floor+room]
            String[] parts = dhomaList.get(i).getId().split("(?<=\\D)(?=\\d)");
            String building = parts[0];
            int floor = Integer.parseInt(parts[1])/100;
            //int room = Integer.parseInt(parts[1])%100;
            if (Objects.equals(building, ndertesa) && floor == kati){
                dhomatReturn.add(dhomaList.get(i));
            }
        }
        return dhomatReturn;
    }

    public DhomaDTO infoDhome(String id){ //dhoma id
        Optional<Dhoma> dhoma = dhomaRepository.findById(id);
        List<Student> studentList = studentRepository.gjejNgaDhomaId(id);
//        Optional<Kontrata> kontrata = kontrataRepository.gjejNgaDhomaId(id);
        //krijon nje objekt dto dhe i vendos te dhenat e dhomes qe e dime qe ekziston
        DhomaDTO dto = new DhomaDTO
                (dhoma,
                        //metode qe kthen te tere users qe kane dhoma_id sa id
                        studentList);

        return dto;
    }

    //metode admini kur klikon butonin zij
    public void zijDhomen(String dhomaId){
        Optional<Dhoma> dhoma = dhomaRepository.findById(dhomaId);
        dhoma.ifPresent(value -> value.setZene(true));
    }

    public void liroDhomen(String dhomaId){
        Optional<Dhoma> dhoma = dhomaRepository.findById(dhomaId);
        dhoma.ifPresent(value -> value.setZene(false));
    }

}
