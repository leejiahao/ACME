USE acme_space;

-------------------------------------
-- TABLE: acme_job_testline
-------------------------------------
DROP TABLE acme_job_testline;

CREATE TABLE acme_job_testline (
    job_testline_id uuid PRIMARY KEY,
    job_id uuid,
    testline_name text,
    status text,
    update_time timestamp,
    update_user text,
    create_time timestamp,
    create_user text
) WITH COMPACT STORAGE;
    
-------------------------------------
-- INDEX
-------------------------------------
CREATE INDEX acme_job_testline_idx_job_id ON acme_job_testline (job_id);
CREATE INDEX acme_job_testline_idx_testline_name ON acme_job_testline (testline_name);
CREATE INDEX acme_job_testline_idx_status ON acme_job_testline (status);
CREATE INDEX acme_job_testline_idx_update_time ON acme_job_testline (update_time);
CREATE INDEX acme_job_testline_idx_update_user ON acme_job_testline (update_user);
CREATE INDEX acme_job_testline_idx_create_time ON acme_job_testline (create_time);
CREATE INDEX acme_job_testline_idx_create_user ON acme_job_testline (create_user);