USE acme_space;

-------------------------------------
-- TABLE: acme_dept
-------------------------------------
DROP TABLE acme_dept;

CREATE TABLE acme_dept (
    dept_id text PRIMARY KEY,
    dept_level text,
    dept_mgr text,
    dept_short_name text,
    dept_long_name text,
    dept_loc text,
    update_time timestamp,
    update_user text,
    create_time timestamp,
    create_user text
) WITH COMPACT STORAGE;

-------------------------------------
-- INDEX: acme_dept.dept_short_name
-------------------------------------
CREATE INDEX acme_dept_idx_dept_short_name ON acme_dept (dept_short_name);
    
