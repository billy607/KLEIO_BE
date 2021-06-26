package com.kleio.app.controller;

import com.kleio.app.service.Impl.s3ServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(path = "api/v1/file")
@RestController
@AllArgsConstructor
public class FileController {

    @Autowired
    private final s3ServiceImpl s3;

    @GetMapping(path = "/test")
    public String test() {
        return s3.downloadFile("key");
    }

    @GetMapping(path = "/name/{fileName}")
    public ResponseEntity<Resource> getFileByName(@PathVariable("fileName") String fileName) throws Exception {
        return s3.downloadFileByName(fileName);
    }
}
