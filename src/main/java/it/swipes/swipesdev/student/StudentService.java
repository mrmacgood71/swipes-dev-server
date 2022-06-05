package it.swipes.swipesdev.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;


@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    public void save(Student student) {
        Optional<Student> studentOptional = studentRepository
                .findStudentByEmail(student.getEmail());

        if (studentOptional.isPresent()) {
            throw new IllegalStateException("email taken");
        }

        System.out.println(student);
        studentRepository.save(student);
    }

    public void delete(final Long id) {
        boolean exists = studentRepository.existsById(id);

        if(!exists) {
            throw new IllegalStateException(
                    "student with id = " + id + "does not exists");
        }

        studentRepository.deleteById(id);
    }

    @Transactional
    public void update(Long id, String name, String email) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException(
                        "student with id = " + id + "does not exists"
                ));

        if (name != null
                && name.length() > 0
                && !Objects.equals(student.getName(), name)
        ) {
            student.setName(name);
        }

        if (email != null
                && name.length() > 0
                && !Objects.equals(student.getName(), name)
        ) {
            Optional<Student> studentOptional = studentRepository
                    .findStudentByEmail(email);

            if (studentOptional.isPresent()) {
                throw new IllegalStateException("email taken");
            }

            student.setEmail(email);
        }
    }
}
