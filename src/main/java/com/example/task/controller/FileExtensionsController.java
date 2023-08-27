package com.example.task.controller;

import com.example.task.domain.FileExtension;
import com.example.task.domain.FileExtensionUpdateDto;
import com.example.task.service.FileExtensionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/fileExtensions")
@RequiredArgsConstructor
public class FileExtensionsController {

    private final FileExtensionService fileExtensionService;

    @GetMapping
    public String fileExtensionBlockerForm(Model model) {

        List<FileExtension> fixedExtensions = fileExtensionService.findFixedExtension();
        List<FileExtension> notFixedExtensions = fileExtensionService.findNotFixedExtension();

        model.addAttribute("fixedExtensions", fixedExtensions);
        model.addAttribute("notFixedExtensions", notFixedExtensions);

        return "fileExtensionBlockerForm";
    }

    @PostMapping("/update")
    @ResponseBody
    public Map<String, String> updateExtension(@RequestBody FileExtensionUpdateDto fileExtensionUpdateDto) {
        try {
            fileExtensionService.update(fileExtensionUpdateDto);

            Map<String, String> response = new HashMap<>();
            response.put("message", "SUCCESS");

            return response;
        } catch (Exception e) {

            Map<String, String> response = new HashMap<>();
            response.put("error", "파일 처리 중 에러가 발생하였습니다.");

            return response;
        }
    }

}
