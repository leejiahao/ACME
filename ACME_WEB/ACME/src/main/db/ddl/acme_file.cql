USE acme_space;

-------------------------------------
-- TABLE: acme_file
-------------------------------------
DROP TABLE acme_file;

CREATE TABLE acme_file (
    file_id uuid PRIMARY KEY,
    file_path text,
    file_name text,
    file_type text,
    file_desc text,
    status text,
    update_time timestamp,
    update_user text,
    create_time timestamp,
    create_user text
) WITH COMPACT STORAGE;

-------------------------------------
-- INDEX
-------------------------------------
CREATE INDEX acme_file_idx_file_path ON acme_file (file_path);
CREATE INDEX acme_file_idx_file_name ON acme_file (file_name);
CREATE INDEX acme_file_idx_file_type ON acme_file (file_type);
CREATE INDEX acme_file_idx_status ON acme_file (status);
CREATE INDEX acme_file_idx_update_time ON acme_file (update_time);
CREATE INDEX acme_file_idx_update_user ON acme_file (update_user);
CREATE INDEX acme_file_idx_create_time ON acme_file (create_time);
CREATE INDEX acme_file_idx_create_user ON acme_file (create_user);
    
