package com.fole.FoleManagement.controller;

import com.fole.FoleManagement.dto.StudentDTO;
import com.fole.FoleManagement.entities.Student;
import com.fole.FoleManagement.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/htmlPage")
    public String redirectStudentPage() {
        return "redirect:/static/student.html";
    }

    @GetMapping //merr te gjithe studentet aktiv(dto me me pak te dhena)
    public List<StudentDTO> getAllStudentsDTO() {
        return studentService.getAllStudentsDTO();
    }

    @GetMapping("/all")
    public ResponseEntity<List<Optional<Student>>> getAllActiveStudents(){
        return new ResponseEntity<>(studentService.getAllActiveStudents(), HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable String id) {
        Optional<Student> student = studentService.getStudentById(id);
        return student.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        Student createdStudent = studentService.createStudent(student);
        return ResponseEntity.created(URI.create("/students/" + createdStudent.getId())).body(createdStudent);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable String id, @RequestBody Student updatedStudent) {
        Student student = studentService.updateStudent(id, updatedStudent);
        return student != null ? ResponseEntity.ok(student) : ResponseEntity.notFound().build();
    }

    @PutMapping("/delete/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable String id) {
        try {
            return new ResponseEntity<>(studentService.deleteStudent(id),HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/transfero")
    public ResponseEntity<String> transferoStudent(@RequestParam String id,
                                                   @RequestParam String dhomaId){
        String msg = studentService.transfero(id, dhomaId);
        return new ResponseEntity<>(msg, HttpStatus.OK);
    }

    @PutMapping("/hiqNgaDhoma")
    public ResponseEntity<String> hiqNgaDhoma(@RequestParam String id){
        studentService.hiqNgaDhoma(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<List<StudentDTO>> search(String q){
        return new ResponseEntity<>(studentService.search(q), HttpStatus.OK);
    }
}
