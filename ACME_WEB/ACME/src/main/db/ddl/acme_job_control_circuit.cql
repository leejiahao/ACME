USE acme_space;

-------------------------------------
-- TABLE: acme_job_control_circuit
-------------------------------------
DROP TABLE acme_job_control_circuit;

CREATE TABLE acme_job_control_circuit (
    job_circuit_id uuid PRIMARY KEY,
    job_id uuid,
    circuit_id uuid,
    status text,
    update_time timestamp,
    update_user text,
    create_time timestamp,
    create_user text
) WITH COMPACT STORAGE;
    
-------------------------------------
-- INDEX
-------------------------------------
CREATE INDEX acme_job_control_circuit_idx_job_id ON acme_job_control_circuit (job_id);
CREATE INDEX acme_job_control_circuit_idx_circuit_id ON acme_job_control_circuit (circuit_id);
CREATE INDEX acme_job_control_circuit_idx_status ON acme_job_control_circuit (status);
CREATE INDEX acme_job_control_circuit_idx_update_time ON acme_job_control_circuit (update_time);
CREATE INDEX acme_job_control_circuit_idx_update_user ON acme_job_control_circuit (update_user);
CREATE INDEX acme_job_control_circuit_idx_create_time ON acme_job_control_circuit (create_time);
CREATE INDEX acme_job_control_circuit_idx_create_user ON acme_job_control_circuit (create_user);