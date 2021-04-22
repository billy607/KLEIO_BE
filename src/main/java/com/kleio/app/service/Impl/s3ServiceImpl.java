package com.kleio.app.service.Impl;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.Response;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import com.kleio.app.service.s3Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.logging.Level;

@Service
public class s3ServiceImpl implements s3Service {
    private Logger logger = LoggerFactory.getLogger(s3ServiceImpl.class);

    @Autowired
    private AmazonS3 s3client;

    @Value("${mpd.s3.bucket}")
    private String bucketName;

    @Override
    public String downloadFile(String keyName) {
        String result = "";
        try {
            System.out.println("Downloading an object.");
            S3Object s3object = s3client.getObject(new GetObjectRequest(bucketName, keyName));
            System.out.println("Content-Type: " + s3object.getObjectMetadata().getContentType());
            //displayText(s3object.getObjectContent());
            result = getTextFrom(s3object.getObjectContent());
            logger.info("===================== Import File - Done! =====================");

        } catch (AmazonServiceException ase) {
            logger.info("Caught an AmazonServiceException from GET requests, rejected reasons:");
            logger.info("Error Message:    " + ase.getMessage());
            logger.info("HTTP Status Code: " + ase.getStatusCode());
            logger.info("AWS Error Code:   " + ase.getErrorCode());
            logger.info("Error Type:       " + ase.getErrorType());
            logger.info("Request ID:       " + ase.getRequestId());
        } catch (AmazonClientException ace) {
            logger.info("Caught an AmazonClientException: ");
            logger.info("Error Message: " + ace.getMessage());
        } catch (IOException ioe) {
            logger.info("IOE Error Message: " + ioe.getMessage());
        }
        return result;
    }

    public ResponseEntity<Resource> downloadAudio(String keyName) {
        S3Object s3object = null;
        try {
            System.out.println("Downloading an object.");
            s3object = s3client.getObject(new GetObjectRequest(bucketName, keyName));
            System.out.println("Content-Type: " + s3object.getObjectMetadata().getContentType());
            logger.info("===================== Import File - Done! =====================");

        } catch (AmazonServiceException ase) {
            logger.info("Caught an AmazonServiceException from GET requests, rejected reasons:");
            logger.info("Error Message:    " + ase.getMessage());
            logger.info("HTTP Status Code: " + ase.getStatusCode());
            logger.info("AWS Error Code:   " + ase.getErrorCode());
            logger.info("Error Type:       " + ase.getErrorType());
            logger.info("Request ID:       " + ase.getRequestId());
        } catch (AmazonClientException ace) {
            logger.info("Caught an AmazonClientException: ");
            logger.info("Error Message: " + ace.getMessage());
        }
        assert s3object != null;
        return ResponseEntity.ok()
                .contentType(MediaType.valueOf(s3object.getObjectMetadata().getContentType()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + keyName + "\"")
                .body(new InputStreamResource(s3object.getObjectContent()));
    }

    @Override
    public void uploadFile(String keyName, String uploadFilePath) {
        try {
            File file = new File(uploadFilePath);
            ObjectMetadata objMetadata = new ObjectMetadata();
            objMetadata.setContentLength(15L);

            s3client.putObject(new PutObjectRequest(bucketName, keyName, new FileInputStream(file), objMetadata).withCannedAcl(CannedAccessControlList.PublicRead));
            logger.info("===================== Upload File - Done! =====================");

        } catch (AmazonServiceException ase) {
            logger.info("Caught an AmazonServiceException from PUT requests, rejected reasons:");
            logger.info("Error Message:    " + ase.getMessage());
            logger.info("HTTP Status Code: " + ase.getStatusCode());
            logger.info("AWS Error Code:   " + ase.getErrorCode());
            logger.info("Error Type:       " + ase.getErrorType());
            logger.info("Request ID:       " + ase.getRequestId());
        } catch (AmazonClientException ace) {
            logger.info("Caught an AmazonClientException: ");
            logger.info("Error Message: " + ace.getMessage());
        } catch (FileNotFoundException ex) {
            java.util.logging.Logger.getLogger(s3ServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void displayText(InputStream input) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(input));
        while (true) {
            String line = reader.readLine();
            if (line == null) {
                break;
            }
            System.out.println("    " + line);
        }
    }

    private String getTextFrom(InputStream input) throws IOException{
        StringBuilder result = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(input));
        while (true) {
            String line = reader.readLine();
            if (line == null) {
                break;
            }
            result.append(line);
        }
        return result.toString();
    }
}
