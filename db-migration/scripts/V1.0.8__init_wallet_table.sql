--
-- Table `wallet`
--
CREATE TABLE wallet
(
    id         UUID      DEFAULT gen_random_uuid() PRIMARY KEY,
    family_id  UUID         NOT NULL,
    name       VARCHAR(255) NOT NULL,
    type       VARCHAR(6),
    currency   VARCHAR(3),
    disabled   BOOLEAN   DEFAULT FALSE,
    created_by UUID      DEFAULT '00000000-0000-0000-0000-000000000000',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_by UUID      DEFAULT '00000000-0000-0000-0000-000000000000',
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (family_id) REFERENCES family (id)
);

--
-- Table `payment_group`
--
CREATE TABLE payment_group
(
    id         UUID      DEFAULT gen_random_uuid() PRIMARY KEY,
    parent_id  UUID,
    family_id  UUID,
    name       VARCHAR(255) NOT NULL,
    type       VARCHAR(6)   NOT NULL,
    icon_url   VARCHAR(255),
    disabled   BOOLEAN   DEFAULT FALSE,
    created_by UUID      DEFAULT '00000000-0000-0000-0000-000000000000',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_by UUID      DEFAULT '00000000-0000-0000-0000-000000000000',
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

--
-- Table `wallet_payment_group
--
CREATE TABLE wallet_payment_group
(
    wallet_id        UUID NOT NULL,
    payment_group_id UUID NOT NULL,
    PRIMARY KEY (wallet_id, payment_group_id),
    FOREIGN KEY (wallet_id) REFERENCES wallet (id),
    FOREIGN KEY (payment_group_id) REFERENCES payment_group (id)
);
