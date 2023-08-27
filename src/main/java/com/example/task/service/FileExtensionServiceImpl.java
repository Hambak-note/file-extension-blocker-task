package com.example.task.service;

import com.example.task.domain.FileExtension;
import com.example.task.domain.FileExtensionUpdateDto;
import com.example.task.repository.FileExtensionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
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
    public void update(FileExtensionUpdateDto fileExtensionParam) {
        fileExtensionRepository.update(fileExtensionParam);
    }

    @Override
    public Optional<FileExtension> findByExtensionName(String extensionName) {
        return fileExtensionRepository.findByExtensionName(extensionName);
    }

    @Override
    public List<FileExtension> findAll() {
        return fileExtensionRepository.findAll();
    }
}
