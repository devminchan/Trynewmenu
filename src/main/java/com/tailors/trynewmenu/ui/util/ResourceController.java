package com.tailors.trynewmenu.ui.util;

import com.tailors.trynewmenu.ui.dto.FileUploadResult;
import com.tailors.trynewmenu.infrastructure.resourcemanagement.FileUploadService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@RestController
public class ResourceController {

    @Autowired
    FileUploadService uploadService;

    @RequestMapping(value = "/file", method = RequestMethod.POST)
    public FileUploadResult upload(@RequestBody MultipartFile file) {
        String result = uploadService.upload(file);
        return new FileUploadResult(result);
    }
}