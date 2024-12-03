--
-- Table `"user"`
--
CREATE TABLE "user"
(
    id            UUID      DEFAULT gen_random_uuid() PRIMARY KEY,
    username      VARCHAR(255) NOT NULL UNIQUE,
    password      VARCHAR(255) NOT NULL,
    first_name    VARCHAR(255),
    last_name     VARCHAR(255),
    gender        VARCHAR(6),
    nickname      VARCHAR(255),
    email         VARCHAR(255),
    date_of_birth DATE,
    avatar_url    TEXT,
    address       TEXT,
    phone_number  VARCHAR(20),
    disabled      BOOLEAN   DEFAULT true,
    deleted       BOOLEAN   DEFAULT false,
    expire_date   TIMESTAMP,
    locked        BOOLEAN   DEFAULT false,
    created_by    UUID,
    created_at    TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_by    UUID,
    updated_at    TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

--
-- Table `role`
--
CREATE TABLE role
(
    id          UUID      DEFAULT gen_random_uuid() PRIMARY KEY,
    name        VARCHAR(255) NOT NULL,
    system_role BOOLEAN   DEFAULT false,
    created_by  UUID,
    created_at  TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_by  UUID,
    updated_at  TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

--
-- Table `user_role`
--
CREATE TABLE user_role
(
    user_id UUID NOT NULL,
    role_id UUID NOT NULL,
    PRIMARY KEY (user_id, role_id),
    FOREIGN KEY (user_id) REFERENCES "user" (id),
    FOREIGN KEY (role_id) REFERENCES role (id)
);

--
-- Creates default data
--
INSERT INTO role(name, system_role, created_by, updated_by)
VALUES ('System Admin', true, '00000000-0000-0000-0000-000000000000', '00000000-0000-0000-0000-000000000000'),
       ('User', false, '00000000-0000-0000-0000-000000000000', '00000000-0000-0000-0000-000000000000');

