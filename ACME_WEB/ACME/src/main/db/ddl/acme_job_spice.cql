USE acme_space;

-------------------------------------
-- TABLE: acme_job_spice
-------------------------------------
DROP TABLE acme_job_spice;

CREATE TABLE acme_job_spice (
    job_spice_id uuid PRIMARY KEY,
    job_id uuid,
    job_testline_id uuid,
    testline_name text,
    spice_model_id uuid,
    status text,
    update_time timestamp,
    update_user text,
    create_time timestamp,
    create_user text
) WITH COMPACT STORAGE;

-------------------------------------
-- INDEX
-------------------------------------
CREATE INDEX acme_job_spice_idx_job_id ON acme_job_spice (job_id);
CREATE INDEX acme_job_spice_idx_job_testline_id ON acme_job_spice (job_testline_id);
CREATE INDEX acme_job_spice_idx_testline_name ON acme_job_spice (testline_name);
CREATE INDEX acme_job_spice_idx_spice_model_id ON acme_job_spice (spice_model_id);
CREATE INDEX acme_job_spice_idx_status ON acme_job_spice (status);
CREATE INDEX acme_job_spice_idx_update_time ON acme_job_spice (update_time);
CREATE INDEX acme_job_spice_idx_update_user ON acme_job_spice (update_user);
CREATE INDEX acme_job_spice_idx_create_time ON acme_job_spice (create_time);
CREATE INDEX acme_job_spice_idx_create_user ON acme_job_spice (create_user);
    
