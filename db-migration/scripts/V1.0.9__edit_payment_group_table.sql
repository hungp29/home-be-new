ALTER TABLE payment_group
    ALTER COLUMN type TYPE VARCHAR(8);

UPDATE payment_group
SET type = 'INCOME'
WHERE type = 'INC';

UPDATE payment_group
SET type = 'OUTCOME'
WHERE type = 'OUTC';