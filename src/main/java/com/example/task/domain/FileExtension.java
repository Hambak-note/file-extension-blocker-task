package com.example.task.domain;


import lombok.Data;

@Data
public class FileExtension {

    private String extensionName;
    private String fixedExtension;
    private String checked;

    public FileExtension() {
    }

    public FileExtension(String extensionName, String fixedExtension, String checked) {
        this.extensionName = extensionName;
        this.fixedExtension = fixedExtension;
        this.checked = checked;
    }
}
