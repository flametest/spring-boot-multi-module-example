CREATE TABLE if not exists user
(
    id         BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT 'Primary key ID',
    first_name VARCHAR(32)                         not null COMMENT 'First Name',
    last_name  VARCHAR(32)                         not null COMMENT 'Last Name',
    username   VARCHAR(64) COMMENT 'Username/Nickname',
    email      VARCHAR(128) COMMENT 'Email address',
    gender     VARCHAR(16) COMMENT 'User Gender',
    created_by VARCHAR(64)                         not null COMMENT 'Creator',
    updated_by VARCHAR(64) COMMENT 'Updater',
    deleted_by VARCHAR(64) COMMENT 'Deleter',
    deleted_at TIMESTAMP COMMENT 'Deletion timestamp',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP not null COMMENT 'Creation timestamp',
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP COMMENT 'Update timestamp'
) engine = InnoDB
  default charset = utf8mb4
  collate utf8mb4_unicode_ci COMMENT 'User table';