--
-- Table `family`
--
CREATE TABLE family
(
    id         UUID      DEFAULT gen_random_uuid() PRIMARY KEY,
    name       VARCHAR(255) NOT NULL,
    disabled   BOOLEAN   DEFAULT FALSE,
    created_by UUID      DEFAULT '00000000-0000-0000-0000-000000000000',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_by UUID      DEFAULT '00000000-0000-0000-0000-000000000000',
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

--
-- Table `family_member`
--
CREATE TABLE family_member
(
    family_id UUID NOT NULL,
    user_id   UUID NOT NULL,
    PRIMARY KEY (family_id, user_id),
    FOREIGN KEY (family_id) REFERENCES family (id),
    FOREIGN KEY (user_id) REFERENCES "user" (id)
);