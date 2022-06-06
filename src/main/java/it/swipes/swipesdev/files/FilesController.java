package it.swipes.swipesdev.files;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.EnvironmentVariableCredentialsProvider;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/v0/file")
public class FilesController {

    private static final String BUCKET_NAME = "swipes-storage";
    private static final String SERVICE_ENDPOINT = "storage.yandexcloud.net";
    private static final String REGION = "ru-central1";

    AWSCredentials credentials = null;

    AmazonS3 s3 = null;

    public FilesController() {
        credentials = new EnvironmentVariableCredentialsProvider().getCredentials();

        s3 = AmazonS3ClientBuilder.standard()
                .withCredentials(new AWSStaticCredentialsProvider(credentials))
                .withEndpointConfiguration(
                        new AmazonS3ClientBuilder.EndpointConfiguration(SERVICE_ENDPOINT, REGION)
                )
                .build();
    }

    @GetMapping
    public List<String> getTestImage() {

//        if (true) {
//
//        } else {
            S3Object img = s3.getObject(new GetObjectRequest(BUCKET_NAME, "Q.png"));

            S3ObjectInputStream s3Stream = img.getObjectContent();

            try {
                FileOutputStream fos = new FileOutputStream(new File("Q.png"));

                byte[] readBuf = new byte[1024];
                int readLength = 0;

                while ((readLength = s3Stream.read(readBuf)) > 0) {
                    fos.write(readBuf, 0, readLength);
                }

                s3Stream.close();
                fos.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
//        }

        return List.of(
                "code: 200",
                "state: successful"
        );
    }

    @GetMapping("/send")
    public List<String> uploadFile() {

//        if (true) {
//
//        } else {
            PutObjectRequest request = new PutObjectRequest(BUCKET_NAME, "text.txt", new File("text.txt"));

            ObjectMetadata metadata = new ObjectMetadata();
            metadata.setContentType("plain/text");
            metadata.addUserMetadata("title", "someTitle");
            request.setMetadata(metadata);
            s3.putObject(request);
//        }

        return List.of(
                "code: 200",
                "state: successful"
        );
    }
}
