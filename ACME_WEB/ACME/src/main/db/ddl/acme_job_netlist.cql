USE acme_space;

-------------------------------------
-- TABLE: acme_job_netlist
-------------------------------------
DROP TABLE acme_job_netlist;

CREATE TABLE acme_job_netlist (
    job_netlist_id uuid PRIMARY KEY,
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
CREATE INDEX acme_job_netlist_idx_job_id ON acme_job_netlist (job_id);
CREATE INDEX acme_job_netlist_idx_file_id ON acme_job_netlist (file_id);
CREATE INDEX acme_job_netlist_idx_status ON acme_job_netlist (status);
CREATE INDEX acme_job_netlist_idx_update_time ON acme_job_netlist (update_time);
CREATE INDEX acme_job_netlist_idx_update_user ON acme_job_netlist (update_user);
CREATE INDEX acme_job_netlist_idx_create_time ON acme_job_netlist (create_time);
CREATE INDEX acme_job_netlist_idx_create_user ON acme_job_netlist (create_user);