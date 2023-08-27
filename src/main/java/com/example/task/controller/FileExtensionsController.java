package com.example.task.controller;

import com.example.task.domain.FileExtension;
import com.example.task.service.FileExtensionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

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
}
