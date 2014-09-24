USE acme_space;

-------------------------------------
-- TABLE: acme_basic_geom
-------------------------------------
DROP TABLE acme_basic_geom;

CREATE TABLE acme_basic_geom (
    geom_cd text PRIMARY KEY,
    geom_name text,
    geom_num float,
    create_time timestamp,
    create_user text
) WITH COMPACT STORAGE;

-------------------------------------
-- INDEX
-------------------------------------
CREATE INDEX acme_basic_geom_idx_geom_name ON acme_basic_geom (geom_name);
CREATE INDEX acme_basic_geom_idx_geom_num ON acme_basic_geom (geom_num);