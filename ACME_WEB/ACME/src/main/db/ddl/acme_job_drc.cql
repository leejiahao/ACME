USE acme_space;

-------------------------------------
-- TABLE: acme_job_drc
-------------------------------------
DROP TABLE acme_job_drc;

CREATE TABLE acme_job_drc (
    job_drc_id uuid PRIMARY KEY,
    job_id uuid,
    job_testline_id uuid,
    testline_name text,
    result_file_path text,
    result_file_name text,
    drc_deck_id uuid,
    status text,
    update_time timestamp,
    update_user text,
    create_time timestamp,
    create_user text
) WITH COMPACT STORAGE;
    
-------------------------------------
-- INDEX
-------------------------------------
CREATE INDEX acme_job_drc_idx_job_id ON acme_job_drc (job_id);
CREATE INDEX acme_job_drc_idx_job_testline_id ON acme_job_drc (job_testline_id);
CREATE INDEX acme_job_drc_idx_testline_name ON acme_job_drc (testline_name);
CREATE INDEX acme_job_drc_idx_drc_deck_id ON acme_job_drc (drc_deck_id);
CREATE INDEX acme_job_drc_idx_status ON acme_job_drc (status);
CREATE INDEX acme_job_drc_idx_update_time ON acme_job_drc (update_time);
CREATE INDEX acme_job_drc_idx_update_user ON acme_job_drc (update_user);
CREATE INDEX acme_job_drc_idx_create_time ON acme_job_drc (create_time);
CREATE INDEX acme_job_drc_idx_create_user ON acme_job_drc (create_user);