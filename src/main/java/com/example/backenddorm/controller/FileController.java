package com.example.backenddorm.controller;

import com.example.backenddorm.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("file")
public class FileController {

    @Autowired
    private FileService fileService;

    @PostMapping("upload")
    public List upload(@RequestBody List<MultipartFile> files) {
        try {
            List<String> uriImage = new ArrayList<>();
            for (MultipartFile  file : files) {
                String uri = fileService.upload(file);
                uriImage.add(uri);
            }
            System.out.println(uriImage);
            return uriImage;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }

    }
}
