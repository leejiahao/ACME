USE acme_space;

-------------------------------------
-- TABLE: acme_tv_owner
-------------------------------------
DROP TABLE acme_tv_owner;

CREATE TABLE acme_tv_owner (
    owner_id uuid PRIMARY KEY,
    tv_id uuid,
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
CREATE INDEX acme_tv_owner_idx_tv_id ON acme_tv_owner (tv_id);
CREATE INDEX acme_tv_owner_idx_user_acct_name ON acme_tv_owner (user_acct_name);
CREATE INDEX acme_tv_owner_idx_owner_type ON acme_tv_owner (owner_type);
CREATE INDEX acme_tv_owner_idx_status ON acme_tv_owner (status);
CREATE INDEX acme_tv_owner_idx_update_time ON acme_tv_owner (update_time);
CREATE INDEX acme_tv_owner_idx_update_user ON acme_tv_owner (update_user);
CREATE INDEX acme_tv_owner_idx_create_time ON acme_tv_owner (create_time);
CREATE INDEX acme_tv_owner_idx_create_user ON acme_tv_owner (create_user);
    
