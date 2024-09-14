ALTER TABLE tbl_course
    ADD COLUMN image VARCHAR(225) NULL;


INSERT INTO tbl_course (created_by, created_date, modified_date, modified_by, name, description, is_deleted, time)
VALUES
    ('admin', NOW(), NOW(), 'admin', 'Java Basics', 'Introduction to Java programming', 0, '10 hours'),
    ('admin', NOW(), NOW(), 'admin', 'Advanced Java', 'Deep dive into Java concepts', 0, '15 hours');

INSERT INTO tbl_chapter (created_by, created_date, modified_date, modified_by, name, description, is_deleted, course_id)
VALUES
    ('admin', NOW(), NOW(), 'admin', 'Chapter 1: Java Basics', 'Introduction to variables and data types', 0, 1),
    ('admin', NOW(), NOW(), 'admin', 'Chapter 2: Object-Oriented Programming', 'Classes, objects, inheritance', 0, 1),
    ('admin', NOW(), NOW(), 'admin', 'Chapter 1: Advanced Concepts', 'Streams, lambda expressions', 0, 2);

INSERT INTO tbl_assignment (created_by, created_date, modified_date, modified_by, name, description, chapter_id, is_deleted)
VALUES
    ('admin', NOW(), NOW(), 'admin', 'Assignment 1', 'Write a program to calculate sum of two numbers', 1, 0),
    ('admin', NOW(), NOW(), 'admin', 'Assignment 2', 'Implement a class structure to represent a bank account', 2, 0);

INSERT INTO tbl_user (id, created_by, created_date, modified_date, modified_by, full_name, age, is_deleted)
VALUES
    (UNHEX('D8F6A72F889C4F2FB7B7F8B9E7B77D4B'), 'admin', NOW(), NOW(), 'admin', 'John Doe', 25, 0),
    (UNHEX('6A1B4EBAFBC6412B82192A1F84EBA567'), 'admin', NOW(), NOW(), 'admin', 'Jane Smith', 28, 0);

INSERT INTO tbl_user_course (id_course, id_user)
VALUES
    (1, UNHEX('D8F6A72F889C4F2FB7B7F8B9E7B77D4B')),
    (2, UNHEX( '6A1B4EBAFBC6412B82192A1F84EBA567'));


INSERT INTO tbl_submission (created_by, created_date, modified_date, modified_by, link_github, status, user_id, assignment_id, is_deleted, review)
VALUES
    ('student1', NOW(), NOW(), 'student1', 'https://github.com/student1/java-assignment1', 'PASS',UNHEX('6A1B4EBAFBC6412B82192A1F84EBA567'), 1, 0, 'Good attempt, but needs improvement on edge cases'),
    ('student2', NOW(), NOW(), 'student2', 'https://github.com/student2/java-assignment2', 'PASS', UNHEX('D8F6A72F889C4F2FB7B7F8B9E7B77D4B'), 2, 0, 'Well done, passed all test cases'),
    ('student1', NOW(), NOW(), 'student1', 'https://github.com/student1/java-assignment1', 'PASS',UNHEX('6A1B4EBAFBC6412B82192A1F84EBA567'), 1, 0, 'Good attempt, but needs improvement on edge cases'),
    ('student2', NOW(), NOW(), 'student2', 'https://github.com/student2/java-assignment2', 'FAIL', UNHEX('D8F6A72F889C4F2FB7B7F8B9E7B77D4B'), 2, 0, 'Well done, passed all test cases'),
    ('student1', NOW(), NOW(), 'student1', 'https://github.com/student1/java-assignment1', 'FAIL',UNHEX('6A1B4EBAFBC6412B82192A1F84EBA567'), 1, 0, 'Good attempt, but needs improvement on edge cases'),
    ('student2', NOW(), NOW(), 'student2', 'https://github.com/student2/java-assignment2', 'FAIL', UNHEX('D8F6A72F889C4F2FB7B7F8B9E7B77D4B'), 2, 0, 'Well done, passed all test cases'),
    ('student1', NOW(), NOW(), 'student1', 'https://github.com/student1/java-assignment1', 'FAIL',UNHEX('6A1B4EBAFBC6412B82192A1F84EBA567'), 1, 0, 'Good attempt, but needs improvement on edge cases'),
    ('student2', NOW(), NOW(), 'student2', 'https://github.com/student2/java-assignment2', 'PASS', UNHEX('D8F6A72F889C4F2FB7B7F8B9E7B77D4B'), 2, 0, 'Well done, passed all test cases');


INSERT INTO tbl_review_config (prompt_structure, is_deleted, is_active)
VALUES
    ('Tôi đã làm {exercise}, Bây giờ tôi sẽ gửi cho bạn 1 chuỗi json được tôi giải mã ra khi gọi api github, nó trả về các class và nội dung của nó tôi cần bạn giải mã nội dung của từng class và làm các yêu cầu sau(với mục đích review bài tập). Cấu trúc review sẽ gồm: 1. có đúng yêu cầu bài tập không ( chỉ trả lời pass/fail ) 2. nêu ra điểm cần sửa  3.Kết quả (chỉ trả lời pass/fail). Chỉ review chung cho toàn project chứ không review riêng cho từng class. LƯU Ý KẾT QUẢ REVIEW ĐƯỢC TRẢ LỜI BẰNG TIẾNG VIỆT', false, false),
    ('Bây giờ tôi sẽ gửi cho bạn 1 chuỗi json được tôi giải mã ra khi gọi api github, nó trả về các class và nội dung của nó tôi cần bạn giải mã nội dung của từng class và làm các yêu cầu sau (với mục đích review bài tập). Hiện tại đây là bài tập có đề bài là {exercise}. Nếu nội dung của bài làm không giống với yêu cầu của bài tập thì chỉ trả lời lại là ''Bạn đã nộp sai bài tập''. Còn nếu bài làm phù hợp với đề bài và yêu cầu thì sẽ làm review với Cấu trúc review sẽ gồm: 1. Nhận xét chi tiết từng class 2. Đánh giá tổng quan 3.Kết quả (chỉ trả lời pass/fail). KẾT QUẢ REVIEW ĐƯỢC TRẢ VỀ BẰNG TIẾNG VIỆT và theo chuẩn HTML/text (bao gồm các thẻ html để thể hiện rõ nội dung), chỉ sử dụng thẻ h3 trở lên', false, true);
