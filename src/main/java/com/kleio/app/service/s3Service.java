package com.kleio.app.service;

public interface s3Service {
    String downloadFile(String keyName);

    void uploadFile(String keyName, String uploadFilePath);
}
