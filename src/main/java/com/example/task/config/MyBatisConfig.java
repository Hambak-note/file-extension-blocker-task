package com.example.task.config;

import com.example.task.repository.FileExtensionMapper;
import com.example.task.repository.FileExtensionRepository;
import com.example.task.repository.FileExtensionRepositoryImpl;
import com.example.task.service.FileExtensionService;
import com.example.task.service.FileExtensionServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class MyBatisConfig {

    private final FileExtensionMapper fileExtensionMapper;

    @Bean
    public FileExtensionService fileExtensionService() {
        return new FileExtensionServiceImpl(fileExtensionRepository());
    }

    @Bean
    public FileExtensionRepository fileExtensionRepository() {
        return new FileExtensionRepositoryImpl(fileExtensionMapper);
    }

}
