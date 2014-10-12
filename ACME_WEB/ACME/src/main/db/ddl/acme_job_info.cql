USE acme_space;

-------------------------------------
-- TABLE: acme_job_info
-------------------------------------
DROP TABLE acme_job_info;

CREATE TABLE acme_job_info (
    job_info_id uuid PRIMARY KEY,
    job_id uuid,
    file_id uuid,
    status text,
    update_time timestamp,
    update_user text,
    create_time timestamp,
    create_user text
) WITH COMPACT STORAGE;
    
-------------------------------------
-- INDEX
-------------------------------------
CREATE INDEX acme_job_info_idx_job_id ON acme_job_info (job_id);
CREATE INDEX acme_job_info_idx_file_id ON acme_job_info (file_id);
CREATE INDEX acme_job_info_idx_status ON acme_job_info (status);
CREATE INDEX acme_job_info_idx_update_time ON acme_job_info (update_time);
CREATE INDEX acme_job_info_idx_update_user ON acme_job_info (update_user);
CREATE INDEX acme_job_info_idx_create_time ON acme_job_info (create_time);
CREATE INDEX acme_job_info_idx_create_user ON acme_job_info (create_user);