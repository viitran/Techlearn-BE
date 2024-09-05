CREATE DATABASE IF NOT EXISTS techlearn;

CREATE TABLE teacher (
    id BINARY(16) PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    avatar VARCHAR(250) NOT NULL
);

CREATE TABLE technical_teacher (
    id BINARY(16) PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    id_teacher BINARY(16) NOT NULL,
    FOREIGN KEY (id_teacher) REFERENCES teacher(id)
);

CREATE TABLE calendar (
    id BINARY(16) PRIMARY KEY,
    time_start TIME NOT NULL,
    time_end TIME NOT NULL
);

CREATE TABLE tbl_user
(
    id            BINARY(16)   NOT NULL,
    created_by    VARCHAR(255)  NULL,
    created_date  datetime     NULL,
    modified_date datetime     NULL,
    modified_by   VARCHAR(255) NULL,
    full_name     VARCHAR(255) NULL,
    age           INT          NULL,
    is_deleted    BIT(1)       NULL,
    CONSTRAINT pk_tbl_user PRIMARY KEY (id)
);

CREATE TABLE teacher_calendar (
    id_teacher BINARY(16),
    id_time BINARY(16),
    date_appointment DATE NOT NULL,
    status VARCHAR(50) NOT NULL,
    id_user BINARY(16),
    note VARCHAR(255),
    FOREIGN KEY (id_teacher) REFERENCES teacher(id),
    FOREIGN KEY (id_time) REFERENCES calendar(id),
    FOREIGN KEY (id_user) REFERENCES tbl_user(id),
    PRIMARY KEY (id_teacher, id_time)
);
