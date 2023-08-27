package com.example.task.domain;


import com.example.task.repository.FileExtensionRepository;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Transactional
@SpringBootTest
class FileExtensionRepositoryTest {

    @Autowired
    FileExtensionRepository fileExtensionRepository;

    @Test
    @DisplayName("DB 에 저장된 모든 고정 리스트와 비고정 리스트 조회")
    void findAll() {

        FileExtension fileExtension1 = new FileExtension("test1", "Y", "Y");
        FileExtension fileExtension2 = new FileExtension("test2", "N", "Y");
        FileExtension fileExtension3 = new FileExtension("test3", "Y", "N");

        fileExtensionRepository.save(fileExtension1);
        fileExtensionRepository.save(fileExtension2);
        fileExtensionRepository.save(fileExtension3);

        List<FileExtension> saveFixedExtensions = new ArrayList<>();
        saveFixedExtensions.add(fileExtension1);
        saveFixedExtensions.add(fileExtension3);

        List<FileExtension> saveNotFixedExtensions = new ArrayList<>();
        saveNotFixedExtensions.add(fileExtension2);

        List<FileExtension> findFixedExtensions = fileExtensionRepository.findFixedExtension();
        List<FileExtension> findNotFixedExtensions = fileExtensionRepository.findNotFixedExtension();

        for (int i=0; i < findFixedExtensions.size(); i++) {

            FileExtension saveFileExtension = saveFixedExtensions.get(i);
            FileExtension findFileExtension = findFixedExtensions.get(i);

            Assertions.assertThat(saveFileExtension.getExtensionName()).isEqualTo(findFileExtension.getExtensionName());
            Assertions.assertThat(saveFileExtension.getChecked()).isEqualTo(findFileExtension.getChecked());
            Assertions.assertThat(saveFileExtension.getFixedExtension()).isEqualTo(findFileExtension.getFixedExtension());
        }

        for (int i=0; i < findNotFixedExtensions.size(); i++) {

            FileExtension saveFileExtension = saveNotFixedExtensions.get(i);
            FileExtension findFileExtension = findNotFixedExtensions.get(i);

            Assertions.assertThat(saveFileExtension.getExtensionName()).isEqualTo(findFileExtension.getExtensionName());
            Assertions.assertThat(saveFileExtension.getChecked()).isEqualTo(findFileExtension.getChecked());
            Assertions.assertThat(saveFileExtension.getFixedExtension()).isEqualTo(findFileExtension.getFixedExtension());
        }

    }

    @Test
    @DisplayName("업데이트 테스트")
    void update() {

        FileExtension fileExtension = new FileExtension("test", "Y", "N");
        FileExtensionUpdateDto fileExtensionUpdateDto = new FileExtensionUpdateDto("test", "Y");

        fileExtensionRepository.save(fileExtension);
        fileExtensionRepository.update(fileExtensionUpdateDto);
        Optional<FileExtension> findFileExtension = fileExtensionRepository.findByExtensionName(fileExtension.getExtensionName());

        FileExtension convertedFindFileExtension = findFileExtension.orElse(null);
        Assertions.assertThat(fileExtensionUpdateDto.getChecked()).isEqualTo(convertedFindFileExtension.getChecked());
    }

}