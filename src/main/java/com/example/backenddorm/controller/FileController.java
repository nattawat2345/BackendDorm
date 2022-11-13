package com.example.backenddorm.controller;

import com.example.backenddorm.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("file")
public class FileController {

    @Autowired
    private FileService fileService;

    @PostMapping("upload")
    public String upload(@RequestBody MultipartFile file) {
        try {
            System.out.println(fileService.upload(file));
            return fileService.upload(file);
        }
        catch (Exception e){
            return e.getMessage();
        }

    }
}
