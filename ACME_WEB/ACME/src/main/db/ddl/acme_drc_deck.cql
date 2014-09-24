USE acme_space;

-------------------------------------
-- TABLE: acme_drc_deck
-------------------------------------
DROP TABLE acme_drc_deck;

CREATE TABLE acme_drc_deck (
    deck_id uuid PRIMARY KEY,
    tv_id uuid,
    deck_name text,
    deck_type text,
    deck_desc text,
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
CREATE INDEX acme_drc_deck_idx_tv_id ON acme_drc_deck (tv_id);
CREATE INDEX acme_drc_deck_idx_deck_name ON acme_drc_deck (deck_name);
CREATE INDEX acme_drc_deck_idx_deck_type ON acme_drc_deck (deck_type);
CREATE INDEX acme_drc_deck_idx_file_id ON acme_drc_deck (file_id);
CREATE INDEX acme_drc_deck_idx_is_primary ON acme_drc_deck (is_primary);
CREATE INDEX acme_drc_deck_idx_status ON acme_drc_deck (status);
CREATE INDEX acme_drc_deck_idx_update_time ON acme_drc_deck (update_time);
CREATE INDEX acme_drc_deck_idx_update_user ON acme_drc_deck (update_user);
CREATE INDEX acme_drc_deck_idx_create_time ON acme_drc_deck (create_time);
CREATE INDEX acme_drc_deck_idx_create_user ON acme_drc_deck (create_user);
