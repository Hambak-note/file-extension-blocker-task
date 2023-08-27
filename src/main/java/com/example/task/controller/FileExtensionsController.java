package com.example.task.controller;

import com.example.task.domain.*;
import com.example.task.service.FileExtensionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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
        model.addAttribute("maxCustomExtension", Constant.MAX_EXTENSION_COUNT.getValue());

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

    @PostMapping("/save")
    @ResponseBody
    public Map<String, String> saveExtension(@RequestBody FileExtension fileExtension) {
        try {

            Map<String, String> response = new HashMap<>();
            Optional<FileExtension> findExtensionName = fileExtensionService.findByExtensionName(fileExtension.getExtensionName());

            if(findExtensionName.isPresent()) {
                response.put("message", "DUPLICATE");
                return response;
            }

            FileExtension savedFileExtension = fileExtensionService.save(fileExtension);

            response.put("message", "SUCCESS");
            response.put("savedFileExtension", savedFileExtension.getExtensionName());

            return response;
        } catch (Exception e) {

            Map<String, String> response = new HashMap<>();
            response.put("error", "파일 처리 중 에러가 발생하였습니다.");

            return response;
        }
    }

    @PostMapping("/delete")
    @ResponseBody
    public Map<String, String> deleteExtension(@RequestBody FileExtensionDeleteDto fileExtensionDeleteDto) {
        try {
            fileExtensionService.delete(fileExtensionDeleteDto);

            Map<String, String> response = new HashMap<>();
            response.put("message", "SUCCESS");

            return response;
        } catch (Exception e) {

            Map<String, String> response = new HashMap<>();
            response.put("error", "파일 삭제 중 에러가 발생하였습니다.");

            return response;
        }
    }

    @PostMapping("/validation")
    @ResponseBody
    public Map<String, String> validationExtension(@RequestBody FileValidationDto fileValidationDto) {
        try {

            Map<String, String> response = new HashMap<>();
            Optional<FileExtension> findExtensionName = fileExtensionService.findByExtensionName(fileValidationDto.getExtensionName());

            if(findExtensionName.isPresent()) {
                response.put("message", "RESTRICT");
                return response;
            }

            response.put("message", "SUCCESS");

            return response;
        } catch (Exception e) {

            Map<String, String> response = new HashMap<>();
            response.put("error", "파일 확장자 검증 중 에러가 발생하였습니다.");

            return response;
        }
    }

}
