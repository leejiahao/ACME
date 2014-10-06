USE acme_space;

-------------------------------------
-- TABLE: acme_control_circuit
-------------------------------------
DROP TABLE acme_control_circuit;

CREATE TABLE acme_control_circuit (
    circuit_id uuid PRIMARY KEY,
    tv_id uuid,
    circuit_name text,
    circuit_type text,
    circuit_desc text,
    circuit_gds_file_path text,
    circuit_gds_file_name text,
    circuit_gds_top_cell text,
    coordinate_file_path text,
    coordinate_file_name text,
    netlist_file_path text,
    netlist_file_name text,
    file_id uuid,
    is_primary boolean,
    status text,
    update_time timestamp,
    update_user text,
    create_time timestamp,
    create_user text
) WITH COMPACT STORAGE;   
    
-------------------------------------
-- INDEX
-------------------------------------
CREATE INDEX acme_control_circuit_idx_tv_id ON acme_control_circuit (tv_id);
CREATE INDEX acme_control_circuit_idx_circuit_name ON acme_control_circuit (circuit_name);
CREATE INDEX acme_control_circuit_idx_circuit_type ON acme_control_circuit (circuit_type);
CREATE INDEX acme_control_circuit_idx_circuit_gds_file_path ON acme_control_circuit (circuit_gds_file_path);
CREATE INDEX acme_control_circuit_idx_circuit_gds_top_cell ON acme_control_circuit (circuit_gds_top_cell);
CREATE INDEX acme_control_circuit_idx_file_id ON acme_control_circuit (file_id);
CREATE INDEX acme_control_circuit_idx_is_primary ON acme_control_circuit (is_primary);
CREATE INDEX acme_control_circuit_idx_status ON acme_control_circuit (status);
CREATE INDEX acme_control_circuit_idx_update_time ON acme_control_circuit (update_time);
CREATE INDEX acme_control_circuit_idx_update_user ON acme_control_circuit (update_user);
CREATE INDEX acme_control_circuit_idx_create_time ON acme_control_circuit (create_time);
CREATE INDEX acme_control_circuit_idx_create_user ON acme_control_circuit (create_user);
