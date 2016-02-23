--select 'drop table '||table_name||' cascade constraints;' from user_tables

drop table WOK_TYPES_ACTIONS cascade constraints;
drop table WOK_TYPES_PROFILES cascade constraints;
drop table WOK_PROFILES_ACTIONS cascade constraints;
drop table WOK_TYPES_DEMAND cascade constraints;
drop table WOK_OCCURRENCES_DEMAND cascade constraints;
drop table WOK_DEMANDS cascade constraints;
drop table WOK_CONFIGURATIONS_ITEM cascade constraints;
drop table WOK_WORKING_GROUPS cascade constraints;
drop table WOK_USERS_GROUP cascade constraints;
drop table WOK_TYPES_SYMPTOMS cascade constraints;
drop table WOK_NEXT_ACTIONS cascade constraints;
drop table WOK_DEMANDS_PRIORITY cascade constraints;
drop table WOK_TYPES_IMPACT cascade constraints;
drop table WOK_TYPES_OCCURRENCE cascade constraints;
drop table WOK_DEMANDS_ACTIVITIES cascade constraints;
drop table WOK_DAILY_OCURRENCES cascade constraints;
drop table WOK_CONFIGURATIONS_TYPES cascade constraints;
drop table WOK_DOCUMENTS_DEMAND cascade constraints;
drop table WOK_GENERAL_PARAMETERS cascade constraints;

@/run/media/orclqq/Home/TMP_Zaher/adminWKF/01_WOK_TYPES_SYMPTOMS.sql
@/run/media/orclqq/Home/TMP_Zaher/adminWKF/02_WOK_TYPES_DEMAND.sql
@/run/media/orclqq/Home/TMP_Zaher/adminWKF/03_WOK_TYPES_PROFILES.sql
@/run/media/orclqq/Home/TMP_Zaher/adminWKF/04_WOK_TYPES_ACTIONS.sql
@/run/media/orclqq/Home/TMP_Zaher/adminWKF/05_WOK_TYPES_IMPACT.sql
@/run/media/orclqq/Home/TMP_Zaher/adminWKF/06_WOK_CONFIGURATIONS_TYPES.sql
@/run/media/orclqq/Home/TMP_Zaher/adminWKF/07_WOK_CONFIGURATIONS_ITEM.sql
@/run/media/orclqq/Home/TMP_Zaher/adminWKF/08_WOK_WORKING_GROUPS.sql
@/run/media/orclqq/Home/TMP_Zaher/adminWKF/09_WOK_USERS_GROUP.sql
@/run/media/orclqq/Home/TMP_Zaher/adminWKF/10_WOK_DEMANDS_PRIORITY.sql
@/run/media/orclqq/Home/TMP_Zaher/adminWKF/11_WOK_TYPES_OCCURRENCES.sql
@/run/media/orclqq/Home/TMP_Zaher/adminWKF/12_WOK_NEXT_ACTIONS.sql
@/run/media/orclqq/Home/TMP_Zaher/adminWKF/13_WOK_PROFILES_ACTIONS.sql
@/run/media/orclqq/Home/TMP_Zaher/adminWKF/14_WOK_DEMANDS.sql
@/run/media/orclqq/Home/TMP_Zaher/adminWKF/15_WOK_OCCURRENCES_DEMAND.sql
@/run/media/orclqq/Home/TMP_Zaher/adminWKF/16_WOK_DEMANDS_ACTIVITIES.sql
@/run/media/orclqq/Home/TMP_Zaher/adminWKF/17_WOK_DAILY_OCURRENCES.sql
@/run/media/orclqq/Home/TMP_Zaher/adminWKF/18_WOK_DOCUMENTS_DEMAND.sql
@/run/media/orclqq/Home/TMP_Zaher/adminWKF/19_WOK_GENERAL_PARAMETERS.sql

