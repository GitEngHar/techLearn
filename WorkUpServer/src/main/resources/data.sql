INSERT INTO root_bean (beantext) VALUES ('beantest');
INSERT INTO root_gamepoint (point) VALUES (100);
INSERT INTO root_secret_infomation (info) VALUES ('TOPSECRETINFO');
INSERT IGNORE INTO users(email, password, name, roles)
VALUES
('admin@example.com', '$2a$10$zQ/cWeug0REj71bF/v21qeKG.9tSFLy77gdW3lYO6I/Ld685.MHWm', 'admin', 'ROLE_ADMIN'),
('hoge@example.com', '$2a$10$T0YePRU9oH3xShJjWKjgSOS16BElIj4eai.YDSbMD0rCwmiNN1rqK', 'hoge', 'ROLE_USER');
