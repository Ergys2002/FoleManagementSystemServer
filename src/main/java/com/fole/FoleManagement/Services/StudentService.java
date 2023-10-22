package com.fole.FoleManagement.services;

import com.fole.FoleManagement.dto.StudentDTO;
import com.fole.FoleManagement.entities.Dhoma;
import com.fole.FoleManagement.entities.Student;
import com.fole.FoleManagement.repositories.DhomaRepository;
import com.fole.FoleManagement.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private DhomaRepository dhomaRepository;
    public List<Optional<Student>> getAllActiveStudents() {
        return studentRepository.merrStudentetAktiv();
    }

    public List<Optional<Student>> getAllNonActiveStudents() {
        return studentRepository.merrStudentetJoAktiv();
    }

    public List<StudentDTO> getAllStudentsDTO(){
        List<Optional<Student>> list = studentRepository.merrStudentetAktiv();
        List<StudentDTO> dtoList = new ArrayList<>();

        for (int i = 0; i < list.size(); i++){
            StudentDTO studentDTO = new StudentDTO(list.get(i));
            dtoList.add(studentDTO);
        }

        return dtoList;
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

    @Transactional
    public String deleteStudent(String id) {
        Optional<Student> st = studentRepository.findById(id);
        st.get().setEnabled(false);
        if (!st.get().getDhoma_id().equals("Bosh")){
            Optional<Dhoma> dhoma = dhomaRepository.findById(st.get().getDhoma_id());
            st.get().setDhoma_id("Bosh");
            dhoma.get().setStudente_ne_dhome(dhoma.get().getStudente_ne_dhome() - 1);
        }
        return "U fshi me sukses";
    }

    public String transfero(String studentId, String dhomaId){
        Optional<Student> student = studentRepository.findById(studentId);
        Optional<Dhoma> dhoma = dhomaRepository.findById(dhomaId);
        if (dhoma.get().getZene() || (dhoma.get().getKapaciteti() == dhoma.get().getStudente_ne_dhome())){
            return "Dhoma eshte e zene";
        }
        else {
            //ulim nr studentesh ne dhomen e vjeter
            Optional<Dhoma> dhomaVjeter = dhomaRepository.findById(student.get().getDhoma_id());
            dhomaVjeter.get().setStudente_ne_dhome(dhomaVjeter.get().getStudente_ne_dhome() - 1);
            //e transferojme ne dhomen e re
            student.get().setDhoma_id(dhomaId);
            //rrisim nr studentesh ne dhomen e re
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

    public List<StudentDTO> search(String query){
        List<Optional<Student>> list = studentRepository.findByEmriOrId(query);

        return list.stream().map(StudentDTO::new).collect(Collectors.toList());
    }


}
