USE acme_space;

-------------------------------------
-- TABLE: acme_job_placement
-------------------------------------
DROP TABLE acme_job_placement;

CREATE TABLE acme_job_placement (
    job_placement_id uuid PRIMARY KEY,
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
CREATE INDEX acme_job_placement_idx_job_id ON acme_job_placement (job_id);
CREATE INDEX acme_job_placement_idx_file_id ON acme_job_placement (file_id);
CREATE INDEX acme_job_placement_idx_status ON acme_job_placement (status);
CREATE INDEX acme_job_placement_idx_update_time ON acme_job_placement (update_time);
CREATE INDEX acme_job_placement_idx_update_user ON acme_job_placement (update_user);
CREATE INDEX acme_job_placement_idx_create_time ON acme_job_placement (create_time);
CREATE INDEX acme_job_placement_idx_create_user ON acme_job_placement (create_user);