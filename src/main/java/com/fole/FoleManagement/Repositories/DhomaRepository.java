package com.fole.FoleManagement.Repositories;

import com.fole.FoleManagement.Entities.Dhoma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DhomaRepository extends JpaRepository<Dhoma, String> {

    @Query(value = "select * from dhoma where id LIKE :ndertese%", nativeQuery = true)
    List<Dhoma> dhomaPerNdertese(@Param("ndertese") String ndertese);

}
