-- Check if the foreign key constraint exists before dropping
SET @constraint_name = 'FK_TBL_CHAPTER_ON_COURSE';
SET @table_name = 'tbl_chapter';

SELECT COUNT(*)
INTO @exists
FROM information_schema.table_constraints
WHERE constraint_name = @constraint_name
  AND table_name = @table_name;

SET @sql = IF(@exists > 0,
              CONCAT('ALTER TABLE ', @table_name, ' DROP FOREIGN KEY ', @constraint_name, ';'),
              'SELECT \'Foreign key constraint does not exist\' AS message;'
           );

PREPARE stmt FROM @sql;
EXECUTE stmt;
DEALLOCATE PREPARE stmt;

-- Proceed with the rest of the alterations
ALTER TABLE tbl_chapter
    DROP COLUMN description,
    CHANGE COLUMN name name_chapter VARCHAR(255) NULL,
    ADD COLUMN `order` INT NULL,
    CHANGE COLUMN course_id id_course BIGINT NULL;

ALTER TABLE tbl_course
    CHANGE COLUMN id id_course BIGINT AUTO_INCREMENT NOT NULL,
    CHANGE COLUMN name name_course VARCHAR(255) NULL,
    CHANGE COLUMN image thumbnail_URL VARCHAR(255) NULL,
    CHANGE COLUMN description description_course MEDIUMTEXT NULL,
    ADD COLUMN price_course DECIMAL(10, 2) NULL,
    ADD COLUMN point INT NULL,
    ADD COLUMN currency_unit VARCHAR(10) NULL,
    ADD COLUMN is_active BIT(1) NULL,
    ADD COLUMN is_public BIT(1) NULL,
    DROP COLUMN time;

ALTER TABLE tbl_chapter
    ADD CONSTRAINT fk_chapter_course
        FOREIGN KEY (id_course) REFERENCES tbl_course(id_course);

ALTER TABLE tbl_user
    ADD COLUMN point INT NULL;

SHOW TABLES LIKE 'tbl_chapter';
