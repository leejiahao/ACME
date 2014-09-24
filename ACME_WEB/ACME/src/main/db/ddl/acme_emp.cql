USE acme_space;

-------------------------------------
-- TABLE: acme_emp
-------------------------------------
DROP TABLE acme_emp;

CREATE TABLE acme_emp (
    empl_id text PRIMARY KEY,
    user_acct_name text,
    co_cd text,
    dept_id text,
    user_engl_name text,
    user_chns_name text,
    user_email_addr text,
    supv_user_acct_name text,
    phone_no text,
    update_time timestamp,
    update_user text,
    create_time timestamp,
    create_user text
) WITH COMPACT STORAGE;

-------------------------------------
-- INDEX: acme_emp.user_acct_name
-------------------------------------
CREATE INDEX acme_emp_idx_user_acct_name
    ON acme_emp (user_acct_name);
    
-------------------------------------
-- INDEX: acme_emp.dept_id
-------------------------------------
CREATE INDEX acme_emp_idx_dept_id
    ON acme_emp (dept_id);
    
-------------------------------------
-- INDEX: acme_emp.supv_user_acct_name
-------------------------------------
CREATE INDEX acme_emp_idx_supv_user_acct_name
    ON acme_emp (supv_user_acct_name);