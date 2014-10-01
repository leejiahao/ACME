USE acme_space;

-------------------------------------
-- TABLE: acme_job_testbench
-------------------------------------
DROP TABLE acme_job_testbench;

CREATE TABLE acme_job_testbench (
    job_testbench_id uuid PRIMARY KEY,
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
CREATE INDEX acme_job_testbench_idx_job_id ON acme_job_testbench (job_id);
CREATE INDEX acme_job_testbench_idx_file_id ON acme_job_testbench (file_id);
CREATE INDEX acme_job_testbench_idx_status ON acme_job_testbench (status);
CREATE INDEX acme_job_testbench_idx_update_time ON acme_job_testbench (update_time);
CREATE INDEX acme_job_testbench_idx_update_user ON acme_job_testbench (update_user);
CREATE INDEX acme_job_testbench_idx_create_time ON acme_job_testbench (create_time);
CREATE INDEX acme_job_testbench_idx_create_user ON acme_job_testbench (create_user);