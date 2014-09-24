#!/bin/sh

CASSANDRA_HOST=$1
ID=$2
PW=$3

CDL_FILES="acme_tv.cql \
	acme_tv_owner.cql \
	acme_gds.cql \
	acme_gds_owner.cql \
	acme_file.cql \
	acme_file_owner.cql \
	acme_job.cql \
	acme_job_drc.cql \
	acme_job_lvs.cql \
	acme_job_rc.cql \
	acme_job_spice.cql \
	acme_control_circuit.cql \
	acme_drc_deck.cql \
	acme_lvs_deck.cql \
	acme_rc_deck.cql \
	acme_spice_model.cql \
	acme_emp.cql \
	acme_dept.cql \
	acme_basic_geom.cql"

for cdl_file in ${CDL_FILES};do
    cqlsh ${CASSANDRA_HOST} -u ${ID} -p ${PW} -f ${cdl_file}
done

