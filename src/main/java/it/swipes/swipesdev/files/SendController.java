package it.swipes.swipesdev.files;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.EnvironmentVariableCredentialsProvider;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.*;
import it.swipes.swipesdev.post.PhotoRepository;
import it.swipes.swipesdev.post.PhotoUrl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/v0/send")
public class SendController {

    private static final String BUCKET_NAME = "swipes-storage";
    private static final String SERVICE_ENDPOINT = "storage.yandexcloud.net";
    private static final String FULL_LINK = "https://storage.yandexcloud.net/swipes-storage/";
    private static final String REGION = "ru-central1";

    AWSCredentials credentials = null;

    AmazonS3 s3 = null;


    private final PhotoRepository repository;

    @Autowired
    public SendController(PhotoRepository repository) {
        credentials = new EnvironmentVariableCredentialsProvider().getCredentials();

        s3 = AmazonS3ClientBuilder.standard()
                .withCredentials(new AWSStaticCredentialsProvider(credentials))
                .withEndpointConfiguration(
                        new AmazonS3ClientBuilder.EndpointConfiguration(SERVICE_ENDPOINT, REGION)
                )
                .build();

        this.repository = repository;
    }

    @GetMapping(
            produces = MediaType.IMAGE_JPEG_VALUE
    )
    public ResponseEntity getTestImage() {

        byte[] readBuf = new byte[1024];

        if (true) {


        } else {


            S3Object img = s3.getObject(new GetObjectRequest(BUCKET_NAME, "Q.png"));

            S3ObjectInputStream s3Stream = img.getObjectContent();

            try {
                File file = new File("Q.png");
                FileOutputStream fos = new FileOutputStream(file);

                int readLength = 0;

                while ((readLength = s3Stream.read(readBuf)) > 0) {
                    fos.write(readBuf, 0, readLength);
                }


                s3Stream.close();
                fos.close();

                return ResponseEntity
                        .ok()
                        .header(HttpHeaders.CONTENT_DISPOSITION,  "attachment;filename=" + file.getName())
                        .contentType(MediaType.IMAGE_PNG)
                        .build();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return null;
    }

    @PostMapping()
    public List<String> uploadFile(
            @RequestParam String name,
            @RequestBody File file
    ) {

        if (false) {

        } else {
            PutObjectRequest request = new PutObjectRequest(BUCKET_NAME, name, file);

            ObjectMetadata metadata = new ObjectMetadata();
            metadata.setContentType("image/");
            metadata.addUserMetadata("title", "someTitle");
            request.setMetadata(metadata);
            s3.putObject(request);

            repository.save(new PhotoUrl(FULL_LINK + name));


        }

        return List.of(
                "code: 200",
                "state: successful"
        );
    }

    @GetMapping("/download")
    public void download(HttpServletResponse response) throws IOException {
        response.sendRedirect("https://storage.yandexcloud.net/swipes-storage/Q.png");

    }
}
