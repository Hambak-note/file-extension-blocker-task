package com.example.task.repository;

import com.example.task.domain.FileExtension;
import com.example.task.domain.FileExtensionUpdateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class FileExtensionRepositoryImpl implements FileExtensionRepository{

    private final FileExtensionMapper fileExtensionMapper;
    @Override
    public FileExtension save(FileExtension fileExtension) {
        fileExtensionMapper.save(fileExtension);
        return fileExtension;
    }

    @Override
    public void update(FileExtensionUpdateDto fileExtensionParam) {
        fileExtensionMapper.update(fileExtensionParam);
    }

    @Override
    public List<FileExtension> findAll() {
        return fileExtensionMapper.findAll();
    }

    @Override
    public Optional<FileExtension> findByExtensionName(String extensionName) {
        return fileExtensionMapper.findByExtensionName(extensionName);
    }
}