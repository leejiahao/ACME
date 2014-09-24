USE acme_space;

-------------------------------------
-- TABLE: acme_gds_owner
-------------------------------------
DROP TABLE acme_gds_owner;

CREATE TABLE acme_gds_owner (
    owner_id uuid PRIMARY KEY,
    gds_id uuid,
    user_acct_name text,
    owner_type text,
    status text,
    update_time timestamp,
    update_user text,
    create_time timestamp,
    create_user text
) WITH COMPACT STORAGE;

-------------------------------------
-- INDEX
-------------------------------------
CREATE INDEX acme_gds_owner_idx_gds_id ON acme_gds_owner (gds_id);
CREATE INDEX acme_gds_owner_idx_user_acct_name ON acme_gds_owner (user_acct_name);
CREATE INDEX acme_gds_owner_idx_owner_type ON acme_gds_owner (owner_type);   
CREATE INDEX acme_gds_owner_idx_status ON acme_gds_owner (status);
CREATE INDEX acme_gds_owner_idx_update_time ON acme_gds_owner (update_time);
CREATE INDEX acme_gds_owner_idx_update_user ON acme_gds_owner (update_user);
CREATE INDEX acme_gds_owner_idx_create_time ON acme_gds_owner (create_time);
CREATE INDEX acme_gds_owner_idx_create_user ON acme_gds_owner (create_user);