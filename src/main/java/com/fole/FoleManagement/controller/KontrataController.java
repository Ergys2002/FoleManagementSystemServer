package com.fole.FoleManagement.controller;

import com.fole.FoleManagement.entities.Kontrata;
import com.fole.FoleManagement.services.KontrataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/kontrata")
public class KontrataController {

    @Autowired
    private KontrataService kontrataService;

    @PostMapping
    public ResponseEntity<String> uploadDocument(@RequestBody Kontrata kontrata) {
        Kontrata kontrataRuajtur = kontrataService.saveDocument(kontrata);
        return ResponseEntity.ok("Document saved with ID: " + kontrataRuajtur.getDocument_id());
    }

    @GetMapping("/{kontrataId}")
    public ResponseEntity<byte[]> downloadDocument(@PathVariable Integer kontrataId) {
        Kontrata document = kontrataService.getDocumentById(kontrataId);

        if (document != null) {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_PDF);
            return new ResponseEntity<>(document.getPdf_file(), headers, HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
