package com.example.task.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/fileExtensions")
@RequiredArgsConstructor
public class FileExtensionsController {

    @GetMapping
    public String fileExtensionBlockerForm() {
        return "fileExtensionBlockerForm";
    }
}
