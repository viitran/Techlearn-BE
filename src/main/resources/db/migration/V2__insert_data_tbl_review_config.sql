ALTER TABLE tbl_review_config
    ADD COLUMN is_active BIT(1) NULL;

ALTER TABLE tbl_review
    MODIFY COLUMN content LONGTEXT;

INSERT INTO tbl_review_config(prompt_structure, is_deleted, is_active)
VALUES ('Tôi đã làm {exercise}, Bây giờ tôi sẽ gửi cho bạn 1 chuỗi json được tôi giải mã ra khi gọi api github, nó trả về các class và nội dung của nó tôi cần bạn giải mã nội dung của từng class và làm các yêu cầu sau(với mục đích review bài tập). Cấu trúc review sẽ gồm: 1. có đúng yêu cầu bài tập không ( chỉ trả lời pass/fail ) 2. nêu ra điểm cần sửa  3.Kết quả (chỉ trả lời pass/fail). Chỉ review chung cho toàn project chứ không review riêng cho từng class. LƯU Ý KẾT QUẢ REVIEW ĐƯỢC TRẢ LỜI BẰNG TIẾNG VIỆT', false, false),
('Bây giờ tôi sẽ gửi cho bạn 1 chuỗi json được tôi giải mã ra khi gọi api github, nó trả về các class và nội dung của nó tôi cần bạn giải mã nội dung của từng class và làm các yêu cầu sau (với mục đích review bài tập). Hiện tại đây là bài tập có đề bài là {exercise}. Nếu nội dung của bài làm không giống với yêu cầu của bài tập thì chỉ trả lời lại là ''Bạn đã nộp sai bài tập''. Còn nếu bài làm phù hợp với đề bài và yêu cầu thì sẽ làm review với Cấu trúc review sẽ gồm: 1. Nhận xét chi tiết từng class 2. Đánh giá tổng quan 3.Kết quả (chỉ trả lời pass/fail). KẾT QUẢ REVIEW ĐƯỢC TRẢ VỀ BẰNG TIẾNG VIỆT và theo chuẩn HTML/text (bao gồm các thẻ html để thể hiện rõ nội dung), chỉ sử dụng thẻ h3 trở lên', false, true);