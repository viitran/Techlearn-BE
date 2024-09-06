CREATE TABLE assignment_user
(
    assignment_id BINARY(16) NOT NULL,
    user_id       BINARY(16) NOT NULL
);

CREATE TABLE tbl_assignment
(
    id            BINARY(16)   NOT NULL,
    created_by    VARCHAR(255) NULL,
    created_date  datetime NULL,
    modified_date datetime NULL,
    modified_by   VARCHAR(255) NULL,
    name          VARCHAR(255) NULL,
    `description` VARCHAR(255) NULL,
    course_id     BINARY(16)   NULL,
    submission_id BINARY(16)   NULL,
    is_deleted    BIT(1) NULL,
    CONSTRAINT pk_tbl_assignment PRIMARY KEY (id)
);

CREATE TABLE tbl_course
(
    id            BINARY(16)   NOT NULL,
    created_by    VARCHAR(255) NULL,
    created_date  datetime NULL,
    modified_date datetime NULL,
    modified_by   VARCHAR(255) NULL,
    name          VARCHAR(255) NULL,
    `description` VARCHAR(255) NULL,
    teacher_id    BINARY(16)   NULL,
    is_deleted    BIT(1) NULL,
    CONSTRAINT pk_tbl_course PRIMARY KEY (id)
);

CREATE TABLE tbl_feedback
(
    id            BINARY(16)   NOT NULL,
    created_by    VARCHAR(255) NULL,
    created_date  datetime NULL,
    modified_date datetime NULL,
    modified_by   VARCHAR(255) NULL,
    `description` MEDIUMTEXT NULL,
    question_id   BINARY(16)   NULL,
    is_deleted    BIT(1) NULL,
    CONSTRAINT pk_tbl_feedback PRIMARY KEY (id)
);

CREATE TABLE tbl_question
(
    id            BINARY(16)   NOT NULL,
    name          VARCHAR(255) NULL,
    `description` VARCHAR(255) NULL,
    status        SMALLINT NULL,
    assignment_id BINARY(16)   NULL,
    user_id       BINARY(16)   NULL,
    is_deleted    BIT(1) NULL,
    CONSTRAINT pk_tbl_question PRIMARY KEY (id)
);

CREATE TABLE tbl_submission
(
    id            BINARY(16)   NOT NULL,
    created_by    VARCHAR(255) NULL,
    created_date  datetime NULL,
    modified_date datetime NULL,
    modified_by   VARCHAR(255) NULL,
    link          VARCHAR(255) NULL,
    status        SMALLINT NULL,
    course_id     BINARY(16)   NULL,
    user_id       BINARY(16)   NULL,
    is_deleted    BIT(1) NULL,
    CONSTRAINT pk_tbl_submission PRIMARY KEY (id)
);

CREATE TABLE tbl_teacher
(
    id            BINARY(16)   NOT NULL,
    created_by    VARCHAR(255) NULL,
    created_date  datetime NULL,
    modified_date datetime NULL,
    modified_by   VARCHAR(255) NULL,
    full_name     VARCHAR(255) NULL,
    age           INT NULL,
    is_deleted    BIT(1) NULL,
    CONSTRAINT pk_tbl_teacher PRIMARY KEY (id)
);

ALTER TABLE tbl_feedback
    ADD CONSTRAINT uc_tbl_feedback_question UNIQUE (question_id);

ALTER TABLE tbl_assignment
    ADD CONSTRAINT FK_TBL_ASSIGNMENT_ON_COURSE FOREIGN KEY (course_id) REFERENCES tbl_course (id);

ALTER TABLE tbl_assignment
    ADD CONSTRAINT FK_TBL_ASSIGNMENT_ON_SUBMISSION FOREIGN KEY (submission_id) REFERENCES tbl_submission (id);

ALTER TABLE tbl_course
    ADD CONSTRAINT FK_TBL_COURSE_ON_TEACHER FOREIGN KEY (teacher_id) REFERENCES tbl_teacher (id);

ALTER TABLE tbl_feedback
    ADD CONSTRAINT FK_TBL_FEEDBACK_ON_QUESTION FOREIGN KEY (question_id) REFERENCES tbl_question (id);

ALTER TABLE tbl_question
    ADD CONSTRAINT FK_TBL_QUESTION_ON_ASSIGNMENT FOREIGN KEY (assignment_id) REFERENCES tbl_assignment (id);

ALTER TABLE tbl_question
    ADD CONSTRAINT FK_TBL_QUESTION_ON_USER FOREIGN KEY (user_id) REFERENCES tbl_user (id);

ALTER TABLE tbl_submission
    ADD CONSTRAINT FK_TBL_SUBMISSION_ON_COURSE FOREIGN KEY (course_id) REFERENCES tbl_course (id);

ALTER TABLE tbl_submission
    ADD CONSTRAINT FK_TBL_SUBMISSION_ON_USER FOREIGN KEY (user_id) REFERENCES tbl_user (id);

ALTER TABLE assignment_user
    ADD CONSTRAINT fk_assuse_on_assignment_entity FOREIGN KEY (assignment_id) REFERENCES tbl_assignment (id);

ALTER TABLE assignment_user
    ADD CONSTRAINT fk_assuse_on_user_entity FOREIGN KEY (user_id) REFERENCES tbl_user (id);

ALTER TABLE tbl_user
DROP
COLUMN test;