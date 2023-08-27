package com.example.task.domain;

import lombok.Data;

@Data
public class FileExtensionDeleteDto {

    private String extensionName;

    public FileExtensionDeleteDto() {
    }

    public FileExtensionDeleteDto(String extensionName) {
        this.extensionName = extensionName;
    }
}
