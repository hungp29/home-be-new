--
-- Table `schedule_job`
--
CREATE TABLE schedule_job
(
    id         UUID      DEFAULT gen_random_uuid() PRIMARY KEY,
    code       VARCHAR(255) NOT NULL UNIQUE,
    name       VARCHAR(255) NOT NULL,
    disabled   BOOLEAN   DEFAULT FALSE,
    created_by UUID      DEFAULT '00000000-0000-0000-0000-000000000000',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_by UUID      DEFAULT '00000000-0000-0000-0000-000000000000',
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

--
-- Table `schedule_job_variable`
--
CREATE TABLE schedule_job_variable
(
    id              UUID      DEFAULT gen_random_uuid() PRIMARY KEY,
    schedule_job_id UUID         NOT NULL,
    name            VARCHAR(255) NOT NULL,
    value           TEXT,
    encrypted       BOOLEAN   DEFAULT FALSE,
    created_by      UUID      DEFAULT '00000000-0000-0000-0000-000000000000',
    created_at      TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_by      UUID      DEFAULT '00000000-0000-0000-0000-000000000000',
    updated_at      TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (schedule_job_id) REFERENCES schedule_job (id)
);