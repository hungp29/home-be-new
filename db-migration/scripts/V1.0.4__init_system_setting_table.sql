--
-- Table `application`
--
CREATE TABLE system_setting
(
    id         UUID      DEFAULT gen_random_uuid() PRIMARY KEY,
    code       VARCHAR(255) NOT NULL,
    value      VARCHAR(255),
    disabled   BOOLEAN   DEFAULT FALSE,
    created_by UUID      DEFAULT '00000000-0000-0000-0000-000000000000',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_by UUID      DEFAULT '00000000-0000-0000-0000-000000000000',
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

