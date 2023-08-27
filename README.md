# file-extension-blocker-task
[플로우 과제] 파일 확장자 차단

<br>

- 과제 진행 과정에서 등록한 이슈들 : https://github.com/Hambak-note/file-extension-blocker-task/issues
- 이슈들 수행 내역 : https://github.com/users/Hambak-note/projects/3

<br>

- 개발 환경
  - java: 11
  - spring boot: 2.7.15
  - DB
    - 테스트 환경: H2
    - 배포 환경: Maria DB
  - 서버: Amazon EC2

- DB 관련 사항
  - DB table
    ```sql
        CREATE TABLE file_extension_blocking (
         id INT AUTO_INCREMENT PRIMARY KEY,
         extension_name VARCHAR(20),
         fixed_extension CHAR(1) DEFAULT 'N',
         checked CHAR(1) DEFAULT 'N'
        );
    ```
  - 과제에 주어진 초기값이 자동으로 등록되도록 구현

<br>

- 과제 수행 시 추가 고민 사항
  - 초기값이 고정된 것이 아니라 수정에 따라 초기값을 유동적으로 사용할 수 있도록 구현
  - 실제 파일이 업로드 되었을 시 확장자를 확인하여 결과를 알려줄 수 있도록 구현

<br>

- 추가로 적용할 사항
  - Jenkins로 배포 자동화
  - 실제 파일을 업로드 받아 파일을 저장할 수 있는 기능 구현
    - 기존 테이블에 파일 경로를 저장하고 지정된 경로에 파일을 저장
    - 파일을 저장할 수 있는 저장소 구축 필요
