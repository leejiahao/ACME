USE acme_space;

-------------------------------------
-- TABLE: acme_job_rc
-------------------------------------
DROP TABLE acme_job_rc;

CREATE TABLE acme_job_rc (
    job_rc_id uuid PRIMARY KEY,
    job_id uuid,
    job_testline_id uuid,
    rc_deck_id uuid,
    status text,
    update_time timestamp,
    update_user text,
    create_time timestamp,
    create_user text
) WITH COMPACT STORAGE;
    
-------------------------------------
-- INDEX
-------------------------------------
CREATE INDEX acme_job_rc_idx_job_id ON acme_job_rc (job_id);
CREATE INDEX acme_job_rc_idx_job_testline_id ON acme_job_rc (job_testline_id);
CREATE INDEX acme_job_rc_idx_rc_deck_id ON acme_job_rc (rc_deck_id);
CREATE INDEX acme_job_rc_idx_status ON acme_job_rc (status);
CREATE INDEX acme_job_rc_idx_update_time ON acme_job_rc (update_time);
CREATE INDEX acme_job_rc_idx_update_user ON acme_job_rc (update_user);
CREATE INDEX acme_job_rc_idx_create_time ON acme_job_rc (create_time);
CREATE INDEX acme_job_rc_idx_create_user ON acme_job_rc (create_user);