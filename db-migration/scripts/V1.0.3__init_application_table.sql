--
-- Table `application`
--
CREATE TABLE application
(
    id              UUID      DEFAULT gen_random_uuid() PRIMARY KEY,
    code            VARCHAR(255) NOT NULL,
    name            VARCHAR(255) NOT NULL,
    vie_name        VARCHAR(255) NOT NULL,
    allow_anonymous BOOLEAN   DEFAULT FALSE,
    disabled        BOOLEAN   DEFAULT FALSE,
    created_by      UUID      DEFAULT '00000000-0000-0000-0000-000000000000',
    created_at      TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_by      UUID      DEFAULT '00000000-0000-0000-0000-000000000000',
    updated_at      TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

--
-- Table `application_permission`
--
CREATE TABLE application_permission
(
    application_id UUID NOT NULL,
    family_id      UUID NOT NULL,
    PRIMARY KEY (application_id, family_id),
    FOREIGN KEY (application_id) REFERENCES application (id),
    FOREIGN KEY (family_id) REFERENCES family (id)
);
