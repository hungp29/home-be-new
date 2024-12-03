ALTER TABLE payment_group
    ADD COLUMN special_group      BOOLEAN DEFAULT FALSE,
    ADD COLUMN special_group_code VARCHAR(20);