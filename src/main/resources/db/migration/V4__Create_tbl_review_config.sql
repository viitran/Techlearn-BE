CREATE TABLE tbl_review_config
(
    id               BIGINT AUTO_INCREMENT NOT NULL,
    created_by       VARCHAR(255)          NULL,
    created_date     datetime              NULL,
    modified_date    datetime              NULL,
    modified_by      VARCHAR(255)          NULL,
    prompt_structure LONGTEXT              NULL,
    is_deleted       BIT(1)                NULL,
    CONSTRAINT pk_tbl_review_config PRIMARY KEY (id)
);

INSERT INTO tbl_review_config(prompt_structure, is_deleted)
VALUES ('Bây giờ tôi sẽ gửi cho bạn link github, tôi muốn bạn review bài tập ở link github đó. Đây là link github của tôi: [GITHUB_LINK]. Kết quả review được trả lời bằng tiếng việt. Cấu trúc review sẽ gồm: 1. Nhận xét chi tiết 2. Đánh giá tổng quan 3. Kết quả (chỉ trả lời pass/fail)', false);
