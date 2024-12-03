--
-- Table `transaction`
--
CREATE TABLE transaction
(
    id                  UUID               DEFAULT gen_random_uuid() PRIMARY KEY,
    amount              DECIMAL   NOT NULL DEFAULT 0,
    wallet_id           UUID      NOT NULL,
    payment_group_id    UUID      NOT NULL,
    note                TEXT,
    trans_date          TIMESTAMP NOT NULL,
    exclude_from_report BOOLEAN   NOT NULL DEFAULT FALSE,
    created_by          UUID               DEFAULT '00000000-0000-0000-0000-000000000000',
    created_at          TIMESTAMP          DEFAULT CURRENT_TIMESTAMP,
    updated_by          UUID               DEFAULT '00000000-0000-0000-0000-000000000000',
    updated_at          TIMESTAMP          DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (wallet_id) REFERENCES wallet (id),
    FOREIGN KEY (payment_group_id) REFERENCES payment_group (id)
);