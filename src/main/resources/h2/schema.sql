DROP TABLE IF EXISTS file_extension_blocking;

CREATE TABLE file_extension_blocking (
     id INT PRIMARY KEY,
     extension_name VARCHAR(20),
     fixed_extension CHAR(1) DEFAULT 'N',
     checked CHAR(1) DEFAULT 'N'
);
