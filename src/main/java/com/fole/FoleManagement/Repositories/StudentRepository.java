package com.fole.FoleManagement.repositories;

import com.fole.FoleManagement.dto.StudentDTO;
import com.fole.FoleManagement.entities.Student;
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

    @Query(value = "select * from student where enabled = 0", nativeQuery = true)
    List<Optional<Student>> merrStudentetJoAktiv();

    @Query("SELECT s FROM Student s WHERE s.emri = :query OR s.id = :query")
    List<Optional<Student>> findByEmriOrId(@Param("query") String query);
}
