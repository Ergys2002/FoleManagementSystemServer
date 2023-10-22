package com.fole.FoleManagement.services;

import com.fole.FoleManagement.entities.Dhoma;
import com.fole.FoleManagement.repositories.DhomaRepository;
import com.fole.FoleManagement.dto.KatiDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class KatiService {

    @Autowired
    private DhomaRepository dhomaRepository;

    public List<KatiDTO> getKatetInfo(String ndertesa){
        //vjen ndertesa A, B ose C si input
        List<Dhoma> dhomaList = dhomaRepository.dhomaPerNdertese(ndertesa);

        //kemi 9 kate per secilen ndertese, i inicializojme
        List<KatiDTO> list = KatiDTO.initFloors();

        for (int i = 0; i < dhomaList.size(); i++){
            //ndan me regex ne 2 pjese id tone, [building, floor+room] A dhe 101
            String[] parts = dhomaList.get(i).getId().split("(?<=\\D)(?=\\d)");
            String building = parts[0];
            int floor = Integer.parseInt(parts[1])/100;
            //int room = Integer.parseInt(parts[1])%100;
            if (Objects.equals(building, ndertesa)){
                //nqs jemi ne ndertesen e sakte:
                list.get(floor-1).setApartamenteTotal(list.get(floor-1).getApartamenteTotal() + 1);
                if (!dhomaList.get(i).getZene()){
                    //nqs dhoma s'eshte e zene:
                    list.get(floor-1).setApartamenteFree(list.get(floor-1).getApartamenteFree() + 1);
                }
            }
        }
        return list;
    }

}
