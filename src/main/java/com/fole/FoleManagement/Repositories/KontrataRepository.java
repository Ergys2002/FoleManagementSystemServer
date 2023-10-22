package com.fole.FoleManagement.Repositories;

import com.fole.FoleManagement.Entities.Kontrata;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KontrataRepository extends JpaRepository<Kontrata, Integer> {
}
