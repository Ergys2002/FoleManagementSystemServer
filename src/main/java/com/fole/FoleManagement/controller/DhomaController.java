package com.fole.FoleManagement.controller;

import com.fole.FoleManagement.Entities.Dhoma;
import com.fole.FoleManagement.Services.DhomaService;
import com.fole.FoleManagement.dto.dhomaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fole")
public class DhomaController {

    @Autowired
    private DhomaService dhomaService;

    @GetMapping("/dhoma")
    public ResponseEntity<dhomaDTO> getInfoById(@RequestParam String id) {
        return new ResponseEntity<>(dhomaService.infoDhome(id), HttpStatus.OK);
    }

    @GetMapping("/{ndertesa}/{kati}")
    public ResponseEntity<List<Dhoma>> getDhomat(@PathVariable String ndertesa,
                                                 @PathVariable Integer kati){
        return new ResponseEntity<>(dhomaService.dhomaKati(ndertesa,kati), HttpStatus.OK);
    }

    @PutMapping("/dhoma/liro")
    public ResponseEntity<Void> liroDhomen(@RequestParam String dhomaId){
        dhomaService.liroDhomen(dhomaId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/dhoma/zij")
    public ResponseEntity<Void> zijDhomen(@RequestParam String dhomaId){
        dhomaService.zijDhomen(dhomaId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
