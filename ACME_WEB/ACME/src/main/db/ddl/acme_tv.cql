USE acme_space;

-------------------------------------
-- TABLE: acme_tv
-------------------------------------
DROP TABLE acme_tv;

CREATE TABLE acme_tv (
    tv_id uuid PRIMARY KEY,
    tv_name text,
    tm6 text,
    tech_cd text,
    tv_desc text,
    status text,
    update_time timestamp,
    update_user text,
    create_time timestamp,
    create_user text
) WITH COMPACT STORAGE;

-------------------------------------
-- INDEX
-------------------------------------
CREATE INDEX acme_tv_idx_tv_name ON acme_tv (tv_name);
CREATE INDEX acme_tv_idx_tm6 ON acme_tv (tm6);
CREATE INDEX acme_tv_idx_tech_cd ON acme_tv (tech_cd);
CREATE INDEX acme_tv_idx_status ON acme_tv (status);
CREATE INDEX acme_tv_idx_update_time ON acme_tv (update_time);
CREATE INDEX acme_tv_idx_update_user ON acme_tv (update_user);
CREATE INDEX acme_tv_idx_create_time ON acme_tv (create_time);
CREATE INDEX acme_tv_idx_create_user ON acme_tv (create_user);
    
