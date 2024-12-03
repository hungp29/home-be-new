--
-- Table `interest_rate`
--
CREATE TABLE interest_rate
(
    id            UUID      DEFAULT gen_random_uuid() PRIMARY KEY,
    wallet_id     UUID      NOT NULL,
    rate          REAL      NOT NULL,
    date_affected TIMESTAMP NOT NULL,
    created_by    UUID,
    created_at    TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_by    UUID,
    updated_at    TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (wallet_id) REFERENCES wallet (id)
);
