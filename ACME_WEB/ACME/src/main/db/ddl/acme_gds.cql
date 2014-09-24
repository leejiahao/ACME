USE acme_space;

-------------------------------------
-- TABLE: acme_gds
-------------------------------------
DROP TABLE acme_gds;

CREATE TABLE acme_gds (
    gds_id uuid PRIMARY KEY,
    gds_path text,
    gds_name text,
    gds_type text,
    gds_desc text,
    status text,
    update_time timestamp,
    update_user text,
    create_time timestamp,
    create_user text
) WITH COMPACT STORAGE;
   
-------------------------------------
-- INDEX
-------------------------------------
CREATE INDEX acme_gds_idx_file_path ON acme_gds (gds_path);
CREATE INDEX acme_gds_idx_file_name ON acme_gds (gds_name);
CREATE INDEX acme_gds_idx_file_type ON acme_gds (gds_type);
CREATE INDEX acme_gds_idx_status ON acme_gds (status);
CREATE INDEX acme_gds_idx_update_time ON acme_gds (update_time);
CREATE INDEX acme_gds_idx_update_user ON acme_gds (update_user);
CREATE INDEX acme_gds_idx_create_time ON acme_gds (create_time);
CREATE INDEX acme_gds_idx_create_user ON acme_gds (create_user);
    
