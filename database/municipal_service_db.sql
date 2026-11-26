CREATE DATABASE IF NOT EXISTS municipal_service_db
  CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE municipal_service_db;

CREATE TABLE IF NOT EXISTS service_requests (
    request_id BIGINT NOT NULL AUTO_INCREMENT,
    citizen_name VARCHAR(100) NOT NULL,
    request_type VARCHAR(60) NOT NULL,
    description VARCHAR(1000) NOT NULL,
    status VARCHAR(30) NOT NULL DEFAULT 'SUBMITTED',
    created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (request_id)
);

INSERT INTO service_requests (citizen_name, request_type, description, status)
VALUES
('Lerato Mokoena', 'WATER_LEAK', 'Water is leaking near the community hall.', 'SUBMITTED'),
('Sipho Ndlovu', 'STREETLIGHT', 'Streetlight outside the library is not working.', 'IN_PROGRESS');
