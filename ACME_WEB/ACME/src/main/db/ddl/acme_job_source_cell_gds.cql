USE acme_space;

-------------------------------------
-- TABLE: acme_job_source_cell_gds
-------------------------------------
DROP TABLE acme_job_source_cell_gds;

CREATE TABLE acme_job_source_cell_gds (
    job_source_cell_gds_id uuid PRIMARY KEY,
    job_id uuid,
    gds_id uuid,
    status text,
    update_time timestamp,
    update_user text,
    create_time timestamp,
    create_user text
) WITH COMPACT STORAGE;
    
-------------------------------------
-- INDEX
-------------------------------------
CREATE INDEX acme_job_source_cell_gds_idx_job_id ON acme_job_source_cell_gds (job_id);
CREATE INDEX acme_job_source_cell_gds_idx_gds_id ON acme_job_source_cell_gds (gds_id);
CREATE INDEX acme_job_source_cell_gds_idx_status ON acme_job_source_cell_gds (status);
CREATE INDEX acme_job_source_cell_gds_idx_update_time ON acme_job_source_cell_gds (update_time);
CREATE INDEX acme_job_source_cell_gds_idx_update_user ON acme_job_source_cell_gds (update_user);
CREATE INDEX acme_job_source_cell_gds_idx_create_time ON acme_job_source_cell_gds (create_time);
CREATE INDEX acme_job_source_cell_gds_idx_create_user ON acme_job_source_cell_gds (create_user);