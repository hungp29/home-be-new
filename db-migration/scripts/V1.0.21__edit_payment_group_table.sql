ALTER TABLE transaction
    ADD COLUMN payment_group_id_to UUID,
    ALTER COLUMN payment_group_id DROP NOT NULL;

ALTER TABLE transaction
    RENAME payment_group_id TO payment_group_id_from;
