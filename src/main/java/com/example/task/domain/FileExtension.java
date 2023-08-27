package com.example.task.domain;


import lombok.Data;

@Data
public class FileExtension {

    private Long id;
    private String extensionName;
    private String fixedExtension;
    private String checked;

    public FileExtension() {
    }

    public FileExtension(Long id, String extensionName, String fixedExtension, String checked) {
        this.id = id;
        this.extensionName = extensionName;
        this.fixedExtension = fixedExtension;
        this.checked = checked;
    }
}
