package com.fole.FoleManagement.repositories;

import com.fole.FoleManagement.entities.Kontrata;
import com.fole.FoleManagement.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface KontrataRepository extends JpaRepository<Kontrata, Integer> {

    @Query(value = "SELECT * FROM kontrata WHERE dhoma_id = :dhoma_id", nativeQuery = true)
    Optional<Kontrata> gjejNgaDhomaId(@Param("dhoma_id") String dhoma_id);

}
