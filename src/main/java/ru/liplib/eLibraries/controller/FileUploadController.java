package ru.liplib.eLibraries.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import ru.liplib.eLibraries.model.User;

import java.io.File;
import java.io.IOException;

@Controller
public class FileUploadController {
    private String uploadPath = System.getProperty("user.dir") + "/uploads";
    @Autowired
    private FileUtil fileUtil;
    
    @PostMapping("/manager")
    public String uploadFile(
            @AuthenticationPrincipal User user,
            @RequestParam("file")MultipartFile file,
            Model model) {
        if (file != null && !file.getOriginalFilename().isEmpty()) {
            File uploadFolder = new File(this.uploadPath);

            if (!uploadFolder.exists())
                uploadFolder.mkdir();

            String fileName = uploadPath + "/" + file.getOriginalFilename();

            try {
                File uploadFile = new File(fileName);
                file.transferTo(uploadFile);
                model.addAttribute("message", "Файл загружен");
                fileUtil.addAccounts(fileName, user);

                uploadFile.delete();
            } catch (IOException e) {
                model.addAttribute("message", "Ошибка загрузки файла");
            }
        }

        return "admin/manager";
    }
}
