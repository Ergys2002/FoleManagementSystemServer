package com.fole.FoleManagement.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class KatiDTO {
    private Integer kati;
    private Integer apartamenteFree = 0;
    private Integer apartamenteTotal = 0;

    public KatiDTO(Integer kati) {
        this.kati = kati;
    }

    public static List<KatiDTO> initFloors(){
        ArrayList<KatiDTO> list = new ArrayList<>();
        for (int i = 1; i <10; i++){
            list.add(new KatiDTO(i));
        }
        return list;
    }
}
