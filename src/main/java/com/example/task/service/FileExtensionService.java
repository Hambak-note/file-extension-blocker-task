package com.example.task.service;

import com.example.task.domain.FileExtension;
import com.example.task.domain.FileExtensionUpdateDto;
import com.example.task.repository.FileExtensionRepository;

import java.util.List;
import java.util.Optional;


public interface FileExtensionService {

    FileExtension save(FileExtension fileExtension);

    void update(FileExtensionUpdateDto fileExtensionUpdateDto);
    Optional<FileExtension> findByExtensionName(String extensionName);

    List<FileExtension> findFixedExtension();
    List<FileExtension> findNotFixedExtension();


}
