package it.swipes.swipesdev.student;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.AnonymousAWSCredentials;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@RestController
@RequestMapping(path = "api/v0/student")
public class StudentController {



    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> findAll() {
        return studentService.findAll();
    }

    @PostMapping
    public void save(@RequestBody final Student student) {
        studentService.save(student);
    }

    @PutMapping("{id}")
    public void update(
            @PathVariable final Long id,
            @RequestParam(required = false) final String name,
            @RequestParam(required = false) final String email
    ) {
        studentService.update(id, name, email);

    }

    @DeleteMapping ("{id}")
    public void delete(@PathVariable final Long id) {
        studentService.delete(id);
    }
}
