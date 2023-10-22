package com.fole.FoleManagement.Repositories;

import com.fole.FoleManagement.Entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, String> {

    @Query(value = "select * from student where enabled = 1", nativeQuery = true)
    List<Optional<Student>> merrStudentetAktiv();




    @Query(value = "SELECT * FROM student WHERE dhoma_id = :dhoma_id", nativeQuery = true)
    List<Student> gjejNgaDhomaId(@Param("dhoma_id") String dhoma_id);
}
