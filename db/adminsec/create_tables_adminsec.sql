--select 'drop table '||table_name||' cascade constraints;' from user_tables
drop table SEC_MODULES cascade constraints;
drop table SEC_SUB_MODULES cascade constraints;
drop table SEC_TYPES_APPLICATION cascade constraints;
drop table SEC_TYPES_PERFIL cascade constraints;
drop table SEC_APPLICATIONS cascade constraints;
drop table SEC_PROCESSING_APPLICATIONS cascade constraints;
drop table SEC_USERS cascade constraints;
drop table SEC_SYSTEMS cascade constraints;
drop table SEC_APPLICATIONS_COMPANIES cascade constraints;
drop table SEC_APPLICATIONS_GRANTS cascade constraints;
drop table SEC_LOG_PROCESSING_APPLICATION cascade constraints;


-- Create 
@/run/media/orclqq/Home/TMP_Zaher/adminsec/01_SEC_SYSTEMS.sql
@/run/media/orclqq/Home/TMP_Zaher/adminsec/02_SEC_MODULES.sql
@/run/media/orclqq/Home/TMP_Zaher/adminsec/03_SEC_SUB_MODULES.sql
@/run/media/orclqq/Home/TMP_Zaher/adminsec/04_SEC_TYPES_APPLICATION.sql
@/run/media/orclqq/Home/TMP_Zaher/adminsec/05_SEC_TYPES_PERFIL.sql
@/run/media/orclqq/Home/TMP_Zaher/adminsec/06_SEC_APPLICATIONS.sql
@/run/media/orclqq/Home/TMP_Zaher/adminsec/07_SEC_APPLICATIONS_COMPANIES.sql
@/run/media/orclqq/Home/TMP_Zaher/adminsec/09_SEC_USERS.sql
@/run/media/orclqq/Home/TMP_Zaher/adminsec/08_SEC_APPLICATIONS_GRANTS.sql
@/run/media/orclqq/Home/TMP_Zaher/adminsec/10_SEC_PROCESSING_APPLICATIONS.sql
@/run/media/orclqq/Home/TMP_Zaher/adminsec/11_SEC_LOG_PROCESSING_APPLICATION.sql
