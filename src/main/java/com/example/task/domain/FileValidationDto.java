package com.example.task.domain;

import lombok.Data;

@Data
public class FileValidationDto {

    private String extensionName;

    public FileValidationDto() {
    }

    public FileValidationDto(String extensionName) {
        this.extensionName = extensionName;
    }
}
