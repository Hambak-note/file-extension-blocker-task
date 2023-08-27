package com.example.task.repository;

import com.example.task.domain.FileExtension;
import com.example.task.domain.FileExtensionUpdateDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface FileExtensionMapper {

    void save(FileExtension fileExtension);

    void update(FileExtensionUpdateDto fileExtensionParam);
    List<FileExtension> findFixedExtension();
    List<FileExtension> findNotFixedExtension();
    Optional<FileExtension> findByExtensionName(String extensionName);

}
