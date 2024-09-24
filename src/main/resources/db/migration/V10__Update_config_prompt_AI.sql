CREATE TABLE tbl_struct_response_ai
(
    id             BIGINT AUTO_INCREMENT NOT NULL,
    content_struct LONGTEXT              NULL,
    is_active       BIT(1)              NULL,
    type           LONGTEXT              NULL,
    CONSTRAINT pk_tbl_struct_response_ai PRIMARY KEY (id)
);