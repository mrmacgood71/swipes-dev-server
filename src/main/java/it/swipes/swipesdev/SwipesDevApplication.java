package it.swipes.swipesdev;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.EnvironmentVariableCredentialsProvider;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.*;
import it.swipes.swipesdev.student.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@SpringBootApplication
public class SwipesDevApplication {

    public static void main(String[] args) {
        SpringApplication.run(SwipesDevApplication.class, args);
    }
}

@RestController
class IndexController {

    @GetMapping("/")
    public List<String> index() {

        return List.of(
                "info: welcome",
                "page: index"
        );
    }
}
