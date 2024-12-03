ALTER TABLE wallet
    ADD COLUMN debt_type         VARCHAR(10),
    ADD COLUMN debt_amount       DECIMAL,
    ADD COLUMN disbursement_date TIMESTAMP;
