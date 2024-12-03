--
-- Table `family_setting`
--
CREATE TABLE family_setting
(
    id         UUID      DEFAULT gen_random_uuid() PRIMARY KEY,
    family_id  UUID         NOT NULL,
    code       VARCHAR(255) NOT NULL,
    value      TEXT,
    created_by UUID      DEFAULT '00000000-0000-0000-0000-000000000000',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_by UUID      DEFAULT '00000000-0000-0000-0000-000000000000',
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (family_id) REFERENCES family (id)
);