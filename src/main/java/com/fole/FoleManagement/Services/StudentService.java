package com.fole.FoleManagement.Services;

import com.fole.FoleManagement.Entities.Dhoma;
import com.fole.FoleManagement.Entities.Student;
import com.fole.FoleManagement.Repositories.DhomaRepository;
import com.fole.FoleManagement.Repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private DhomaRepository dhomaRepository;
    public List<Optional<Student>> getAllStudents() {
        return studentRepository.merrStudentetAktiv();
    }

    public Optional<Student> getStudentById(String id) {
        return studentRepository.findById(id);
    }

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student updateStudent(String id, Student updatedStudent) {
        if (studentRepository.existsById(id)) {
            updatedStudent.setId(id); // Ensure the ID is set
            return studentRepository.save(updatedStudent); //override
        }
        return null; // Student with the given ID doesn't exist
    }

    public void deleteStudent(String id) {
        studentRepository.findById(id).get().setEnabled(false);
    }

    public String transfero(String studentId, String dhomaId){
        Optional<Student> student = studentRepository.findById(studentId);
        Optional<Dhoma> dhoma = dhomaRepository.findById(dhomaId);
        if (dhoma.get().getZene() || (dhoma.get().getKapaciteti() == dhoma.get().getStudente_ne_dhome())){
            return "Dhoma eshte e zene";
        }
        else {
            student.get().setDhoma_id(dhomaId);
            dhoma.get().setStudente_ne_dhome(dhoma.get().getStudente_ne_dhome() + 1);
        }
        return "Studenti u fut ne dhome me sukses";
    }

    public void hiqNgaDhoma(String studentId){
        Optional<Student> student = studentRepository.findById(studentId);
        Optional<Dhoma> dhoma = dhomaRepository.findById(student.get().getDhoma_id());
        if (dhoma.isPresent()){
            student.get().setDhoma_id("Bosh");
            dhoma.get().setStudente_ne_dhome(dhoma.get().getStudente_ne_dhome() - 1);
        }
    }


}
