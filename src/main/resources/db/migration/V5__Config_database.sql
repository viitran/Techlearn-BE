CREATE TABLE tbl_user_course
(
    id_course BIGINT NOT NULL,
    id_user   BINARY(16) NOT NULL
);

ALTER TABLE tbl_user_course
    ADD CONSTRAINT fk_tblusecou_on_course_entity FOREIGN KEY (id_course) REFERENCES tbl_course (id);

ALTER TABLE tbl_user_course
    ADD CONSTRAINT fk_tblusecou_on_user_entity FOREIGN KEY (id_user) REFERENCES tbl_user (id);

ALTER TABLE tbl_course
    ADD COLUMN time VARCHAR(100) NULL;

ALTER TABLE tbl_chapter
    CHANGE COLUMN title name VARCHAR (255) NULL;

ALTER TABLE tbl_chapter DROP COLUMN position;

ALTER TABLE tbl_assignment
DROP
FOREIGN KEY FK_TBL_ASSIGNMENT_ON_COURSE;

ALTER TABLE tbl_assignment
DROP
COLUMN course_id;

DROP TABLE tbl_assignment_user;

ALTER TABLE tbl_submission
    CHANGE COLUMN link link_github VARCHAR (255) NULL;

ALTER TABLE tbl_submission
DROP
FOREIGN KEY FK_TBL_SUBMISSION_ON_COURSE;

DROP TABLE tbl_review;

DROP TABLE tbl_githublink;

DROP TABLE tbl_submit_feedback;

ALTER TABLE tbl_submission
    ADD COLUMN review LONGTEXT NULL;

ALTER TABLE tbl_submission
DROP
COLUMN course_id;




