package com.fole.FoleManagement.Services;

import com.fole.FoleManagement.Entities.Kontrata;
import com.fole.FoleManagement.Repositories.KontrataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KontrataService {
    @Autowired
    private KontrataRepository kontrataRepository;

    public Kontrata saveDocument(Kontrata kontrata) {
        return kontrataRepository.save(kontrata);
    }

    public Kontrata getDocumentById(Integer kontrataId) {
        return kontrataRepository.findById(kontrataId).orElse(null);
    }
}
