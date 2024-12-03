ALTER TABLE wallet
    ADD COLUMN icon_id          UUID REFERENCES icon (id),
    ADD COLUMN credit_limit     DECIMAL,
    ADD COLUMN statement_date   SMALLINT,
    ADD COLUMN payment_due_date SMALLINT
;