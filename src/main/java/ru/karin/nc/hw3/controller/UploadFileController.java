package ru.karin.nc.hw3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import ru.karin.nc.hw3.UserFileOperating;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

@Controller
public class UploadFileController {

    @GetMapping("/upload")
    public String getFileUploadForm() {
        return "upload";
    }

    @PostMapping("/upload")
    public String fileUpload(@RequestParam("file") MultipartFile file){
        if (!file.isEmpty()) {
            try {
                Path uploadFile = Paths.get("uploadUserFile.txt");
                Files.write(uploadFile, file.getBytes(), StandardOpenOption.CREATE);
                UserFileOperating.addFromFile(uploadFile);
                Files.delete(uploadFile);
                return "success";
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return "error";
    }}
