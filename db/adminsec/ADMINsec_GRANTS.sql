


--select 'grant select, INSERT, update, delete on  '||table_name||' to USERONLINE;' from user_tables;

grant select, INSERT, update, delete on  SEC_SYSTEMS to USERONLINE;
grant select, INSERT, update, delete on  SEC_MODULES to USERONLINE;
grant select, INSERT, update, delete on  SEC_SUB_MODULES to USERONLINE;
grant select, INSERT, update, delete on  SEC_TYPES_APPLICATION to USERONLINE;
grant select, INSERT, update, delete on  SEC_TYPES_PERFIL to USERONLINE;
grant select, INSERT, update, delete on  SEC_APPLICATIONS to USERONLINE;
grant select, INSERT, update, delete on  SEC_APPLICATIONS_COMPANIES to USERONLINE;
grant select, INSERT, update, delete on  SEC_APPLICATIONS_GRANTS to USERONLINE;
grant select, INSERT, update, delete on  SEC_USERS to USERONLINE;
grant select, INSERT, update, delete on  SEC_PROCESSING_APPLICATIONS to USERONLINE;
grant select, INSERT, update, delete on  SEC_LOG_PROCESSING_APPLICATION to USERONLINE;


--select 'grant select on   '||sequence_name||' to USERONLINE;' from user_sequences;

grant select on   SEC_SEQ_NUM_APPLICATION_GRANT to USERONLINE;
grant select on   SEC_SEQ_NUM_APP_COMPANY to USERONLINE;
grant select on   SEC_SEQ_NUM_LOG_PROCESSING to USERONLINE;
grant select on   SEC_SEQ_NUM_MODULE to USERONLINE;
grant select on   SEC_SEQ_NUM_SUB_MODULE to USERONLINE;
grant select on   SEC_SEQ_NUM_SYSTEM to USERONLINE;
grant select on   SEC_SEQ_NUM_TYPE_APPLICATION to USERONLINE;
grant select on   SEC_SEQ_NUM_USER_APP_GRANT to USERONLINE;


grant references on sec_MODULES to adminwkf; 
grant select, insert, update, delete on sec_MODULES TO adminwkf  WITH GRANT OPTION;

grant references on sec_SUB_MODULES to adminwkf; 
grant select, insert, update, delete on sec_SUB_MODULES TO adminwkf  WITH GRANT OPTION;

------------------
grant references on SEC_APPLICATIONS to adminwkf; 
grant select, insert, update, delete on SEC_APPLICATIONS TO adminwkf  WITH GRANT OPTION;

------------------
grant references on sec_USERS to adminwkf; 
grant select, insert, update, delete on sec_USERS TO adminwkf  WITH GRANT OPTION;

grant references on sec_USERS to ADMINOAM; 
grant select, insert, update, delete on sec_USERS TO ADMINOAM  WITH GRANT OPTION;