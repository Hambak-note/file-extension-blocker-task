package com.example.task.service;

import com.example.task.domain.FileExtension;
import com.example.task.domain.FileExtensionDeleteDto;
import com.example.task.domain.FileExtensionUpdateDto;
import com.example.task.repository.FileExtensionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FileExtensionServiceImpl implements FileExtensionService{

    private final FileExtensionRepository fileExtensionRepository;
    @Override
    public FileExtension save(FileExtension fileExtension) {
        return fileExtensionRepository.save(fileExtension);
    }

    @Override
    public void update(FileExtensionUpdateDto fileExtensionUpdateDto) {
        fileExtensionRepository.update(fileExtensionUpdateDto);
    }

    @Override
    public void delete(FileExtensionDeleteDto fileExtensionDeleteDto) {
        fileExtensionRepository.delete(fileExtensionDeleteDto);
    }

    @Override
    public Optional<FileExtension> findByExtensionName(String extensionName) {
        return fileExtensionRepository.findByExtensionName(extensionName);
    }

    @Override
    public List<FileExtension> findFixedExtension() {
        return fileExtensionRepository.findFixedExtension();
    }

    @Override
    public List<FileExtension> findNotFixedExtension() {
        return fileExtensionRepository.findNotFixedExtension();
    }

}
