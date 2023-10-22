package com.fole.FoleManagement.controller;

import com.fole.FoleManagement.Services.KatiService;
import com.fole.FoleManagement.dto.KatiDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/fole")
public class KatiController {
    @Autowired
    private KatiService katiService;

    @GetMapping("/{building}")
    public ResponseEntity<List<KatiDTO>> getKatetInfo(@PathVariable String building){
        return new ResponseEntity<>(katiService.getKatetInfo(building), HttpStatus.OK);
    }
}
