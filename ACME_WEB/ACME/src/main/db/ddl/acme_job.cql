USE acme_space;

-------------------------------------
-- TABLE: acme_job
-------------------------------------
DROP TABLE acme_job;

CREATE TABLE acme_job (
    job_id uuid PRIMARY KEY,
    tv_id uuid,
    job_name text,
    job_type text,
    job_desc text,
    owner text,
    status text,
    update_time timestamp,
    update_user text,
    create_time timestamp,
    create_user text
) WITH COMPACT STORAGE;

-------------------------------------
-- INDEX
-------------------------------------
CREATE INDEX acme_job_idx_tv_id ON acme_job (tv_id);
CREATE INDEX acme_job_idx_job_name ON acme_job (job_name);
CREATE INDEX acme_job_idx_job_type ON acme_job (job_type);
CREATE INDEX acme_job_idx_owner ON acme_job (owner);
CREATE INDEX acme_job_idx_status ON acme_job (status);
CREATE INDEX acme_job_idx_update_time ON acme_job (update_time);
CREATE INDEX acme_job_idx_update_user ON acme_job (update_user);
CREATE INDEX acme_job_idx_create_time ON acme_job (create_time);
CREATE INDEX acme_job_idx_create_user ON acme_job (create_user);