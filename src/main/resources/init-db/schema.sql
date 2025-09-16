CREATE
    DATABASE IF NOT EXISTS `dagobah_lab`;
USE dagobah_lab;
CREATE
    USER IF NOT EXISTS `master`@`localhost` IDENTIFIED BY 'yoda';
CREATE
    USER `master`@`%` IDENTIFIED BY 'yoda';
GRANT all privileges ON `dagobah_lab`.* TO `master`@`localhost`;
GRANT all privileges ON `dagobah_lab`.* TO `master`@`%`;


CREATE TABLE `MEMBER`
(
    `user_id`    VARCHAR(255)           NOT NULL COMMENT '사용자 ID',
    `password`   VARCHAR(255)           NOT NULL COMMENT '사용자 Password',
    `role`       BIGINT                 NOT NULL COMMENT '권한; 등급; ADMIN(99), USER(1)',
    `nick_name`  VARCHAR(255)           NOT NULL COMMENT '별명',
    `created_at` DATETIME DEFAULT NOW() NOT NULL,
    `updated_at` DATETIME DEFAULT NOW() NOT NUll,
    PRIMARY KEY (user_id)
);

CREATE TABLE `CATEGORY`
(
    `id`         VARCHAR(255)           NOT NULL COMMENT '카테고리 ID',
    `name`       VARCHAR(255)           NOT NULL COMMENT '카테고리명',
    `color`      BIGINT                 NOT NULL COMMENT '카테고리 색상',
    `created_at` DATETIME DEFAULT NOW() NOT NULL,
    `updated_at` DATETIME DEFAULT NOW() NOT NUll,
    UNIQUE KEY uq_id_name_color (id, name, color),
    PRIMARY KEY (id, name)
);

CREATE TABLE `TASK`
(
    `id`           BIGINT AUTO_INCREMENT  NOT NULL COMMENT '상품 ID',
    `category_id`  VARCHAR(255)           NOT NULL COMMENT '상품 ID',
    `user_id`      VARCHAR(255)           NOT NULL COMMENT '상품 ID',
    `title`        VARCHAR(255)           NOT NULL COMMENT '상품명',
    `description`  TINYTEXT               NOT NULL COMMENT '가격',
    `status`       VARCHAR(255)           NOT NULL COMMENT '사이즈',
    `due_date`     DATETIME DEFAULT NOW() NOT NULL,
    `completed_at` DATETIME DEFAULT NOW() NOT NUll,
    `created_at`   DATETIME DEFAULT NOW() NOT NULL,
    `updated_at`   DATETIME DEFAULT NOW() NOT NUll,
    PRIMARY KEY (id)
);

