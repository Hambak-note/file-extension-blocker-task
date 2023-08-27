package com.example.task.domain;

import lombok.Data;

@Data
public class FileExtensionUpdateDto {

    private Long id;
    private String checked;

    public FileExtensionUpdateDto() {
    }

    public FileExtensionUpdateDto(Long id, String checked) {
        this.id = id;
        this.checked = checked;
    }
}
