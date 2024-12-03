--
-- Table `icon`
--
CREATE TABLE icon
(
    id         UUID      DEFAULT gen_random_uuid() PRIMARY KEY,
    icon_url   TEXT,
    group_icon VARCHAR(50),
    created_by UUID      DEFAULT '00000000-0000-0000-0000-000000000000',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_by UUID      DEFAULT '00000000-0000-0000-0000-000000000000',
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

