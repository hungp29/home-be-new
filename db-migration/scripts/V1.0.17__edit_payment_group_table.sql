ALTER TABLE payment_group
    DROP COLUMN icon_url,
    ADD COLUMN icon_id       UUID REFERENCES icon (id),
    ADD COLUMN default_group BOOLEAN,
    ADD COLUMN income        BOOLEAN;