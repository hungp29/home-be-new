ALTER TABLE wallet
    ADD COLUMN amount                 DECIMAL,
    ADD COLUMN deposit_date           DATE,
    ADD COLUMN term                   SMALLINT,
    ADD COLUMN interest_rate          REAL,
    ADD COLUMN non_term_interest_rate REAL,
    ADD COLUMN closing_method         VARCHAR(10) DEFAULT 'ALL'-- ALL, INTEREST, NONE
;