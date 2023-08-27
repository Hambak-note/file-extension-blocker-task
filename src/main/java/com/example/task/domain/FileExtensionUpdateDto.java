package com.example.task.domain;

import lombok.Data;

@Data
public class FileExtensionUpdateDto {

    private String extensionName;
    private String checked;

    public FileExtensionUpdateDto() {
    }

    public FileExtensionUpdateDto(String extensionName, String checked) {
        this.extensionName = extensionName;
        this.checked = checked;
    }
}
