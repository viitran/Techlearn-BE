INSERT INTO tbl_user (id, created_by, created_date, modified_date, modified_by, full_name, age, email, password,
                      is_deleted)
VALUES (UUID_TO_BIN(UUID()), 'system', NOW(), NOW(), 'system', 'Trần Sương', 25, 'suongtran@gmail.com',
        '$2a$12$hSMTKrTDZjQtNvCJ0xBNdeJenSamThzjYS5k9hAliS/SvYUBk9fxy', 0),
       (UUID_TO_BIN(UUID()), 'system', NOW(), NOW(), 'system', 'nguyễn Kim Tuyết', 20, 'nktuyet@gmail.com',
        '$2a$12$hSMTKrTDZjQtNvCJ0xBNdeJenSamThzjYS5k9hAliS/SvYUBk9fxy', 0),
       (UUID_TO_BIN(UUID()), 'system', NOW(), NOW(), 'system', 'Tuấn Nguyễn', 28, 'tuanng@gmail.com',
        '$2a$12$hSMTKrTDZjQtNvCJ0xBNdeJenSamThzjYS5k9hAliS/SvYUBk9fxy', 0),
       (UUID_TO_BIN(UUID()), 'system', NOW(), NOW(), 'system', 'Vi Trần', 19, 'vtran123@gmail.com',
        '$2a$12$hSMTKrTDZjQtNvCJ0xBNdeJenSamThzjYS5k9hAliS/SvYUBk9fxy', 0),
       (UUID_TO_BIN(UUID()), 'system', NOW(), NOW(), 'system', 'Đạt Phan', 32, 'datphan1@gmail.com',
        '$2a$12$hSMTKrTDZjQtNvCJ0xBNdeJenSamThzjYS5k9hAliS/SvYUBk9fxy', 0);


-- add roles
SET @user1_id = (SELECT id
                 FROM tbl_user
                 WHERE email = 'suongtran@gmail.com');

SET @user2_id = (SELECT id
                 FROM tbl_user
                 WHERE email = 'datphan1@gmail.com');

SET @user3_id = (SELECT id
                 FROM tbl_user
                 WHERE email = 'tuanng@gmail.com');

SET @user4_id = (SELECT id
                 FROM tbl_user
                 WHERE email = 'vtran123@gmail.com');

INSERT INTO tbl_user_roles (user, role)
VALUES (@user1_id, 3),
       (@user2_id, 4),
       (@user3_id, 4),
       (@user4_id,2);
