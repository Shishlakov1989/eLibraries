package ru.liplib.eLibraries.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Map;

@Controller
public class FileUploadController {
    private String uploadPath = System.getProperty("user.dir") + "/uploads";
    
    @PostMapping("/uploadFile")
    public String uploadFile(@RequestParam("file")MultipartFile file, Map<String, Object> model) {
        if (file != null && !file.getOriginalFilename().isEmpty()) {
            File uploadFolder = new File(this.uploadPath);

            if (!uploadFolder.exists())
                uploadFolder.mkdir();

            String fileName = file.getOriginalFilename();

            try {
                file.transferTo(new File(uploadPath + "/" + fileName));
                model.put("message", "Файл загружен");
            } catch (IOException e) {
                model.put("message", "Ошибка загрузки файла");
            }
        }

        return "admin/manager";
    }
}
