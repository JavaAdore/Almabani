


--select 'grant select, INSERT, update, delete on   admincor.'||table_name||' to USERONLINE;' from user_tables;

grant select, INSERT, update, delete on   COM_COUNTRIES to USERONLINE;
grant select, INSERT, update, delete on   COM_CONTRACTORS to USERONLINE;
grant select, INSERT, update, delete on   COM_STATES to USERONLINE;
grant select, INSERT, update, delete on   COM_COMPANIES to USERONLINE;
grant select, INSERT, update, delete on   COM_PROJECTS to USERONLINE;
grant select, INSERT, update, delete on   COM_MUNICIPALITIES to USERONLINE;
grant select, INSERT, update, delete on   COM_ZIP_CODE to USERONLINE;
grant select, INSERT, update, delete on   COM_TYPES_HOLIDAYS to USERONLINE;
grant select, INSERT, update, delete on   COM_ESTABLISHMENTS to USERONLINE;
grant select, INSERT, update, delete on   COM_CALENDAR to USERONLINE;
grant select, INSERT, update, delete on   COM_TYPES_JOB_TITLE to USERONLINE;
grant select, INSERT, update, delete on   COM_DEPARTMENTS to USERONLINE;
grant select, INSERT, update, delete on   COM_DEP_SECTIONS to USERONLINE;
grant select, INSERT, update, delete on   COM_EMPLOYEES to USERONLINE;



--select 'grant select on   '||sequence_name||' to USERONLINE;' from user_sequences;

grant select on   COM_SEQ_COD_EMPLOYEE to USERONLINE;
grant select on   COM_SEQ_NUM_COMPANY to USERONLINE;
grant select on   COM_SEQ_NUM_CONTRACTOR to USERONLINE;
grant select on   COM_SEQ_NUM_COUNTRY to USERONLINE;
grant select on   COM_SEQ_NUM_DEPARTMENT to USERONLINE;
grant select on   COM_SEQ_NUM_DEP_SECTION to USERONLINE;
grant select on   COM_SEQ_NUM_ESTABLISHMENT to USERONLINE;
grant select on   COM_SEQ_NUM_PROJECT to USERONLINE;
grant select on   COM_SEQ_NUM_SEQ_CALENDAR to USERONLINE;
grant select on   COM_SEQ_NUM_TYPE_JOB_TITLE to USERONLINE;



grant references on COM_COMPANIES to adminsec; 
grant select, insert, update, delete on COM_COMPANIES TO adminsec WITH GRANT OPTION;
--
grant references on COM_COMPANIES to adminwkf; 
grant select, insert, update, delete on COM_COMPANIES TO adminwkf  WITH GRANT OPTION;

grant references on COM_COMPANIES to adminoam; 
grant select, insert, update, delete on COM_COMPANIES TO adminoam  WITH GRANT OPTION;

grant references on COM_COMPANIES to adminret; 
grant select, insert, update, delete on COM_COMPANIES TO adminret  WITH GRANT OPTION;

------------------------------------------------
grant references on COM_PROJECTS to adminWKF; 
grant select, insert, update, delete on COM_PROJECTS TO adminWKF  WITH GRANT OPTION;

grant references on COM_PROJECTS to adminoam; 
grant select, insert, update, delete on COM_PROJECTS TO adminoam  WITH GRANT OPTION;
------------------------------------------------
grant references on COM_ZIP_CODE to adminret; 
grant select, insert, update, delete on COM_ZIP_CODE TO adminret WITH GRANT OPTION;
-----------------------------------------------

grant references on COM_TYPES_JOB_TITLE to adminret; 
grant select, insert, update, delete on COM_TYPES_JOB_TITLE TO adminret    WITH GRANT OPTION;

-----------------------------------------------

grant references on COM_DEPARTMENTS to adminwkf; 
grant select, insert, update, delete on COM_DEPARTMENTS TO adminwkf  WITH GRANT OPTION;


grant references on COM_DEPARTMENTS to adminSEC; 
grant select, insert, update, delete on COM_DEPARTMENTS TO adminSEC  WITH GRANT OPTION;

grant references on COM_DEPARTMENTS to adminoam; 
grant select, insert, update, delete on COM_DEPARTMENTS TO adminoam  WITH GRANT OPTION;


-----------------------------------------------

grant references on COM_DEP_SECTIONS to adminwkf; 
grant select, insert, update, delete on COM_DEP_SECTIONS TO adminwkf  WITH GRANT OPTION;

grant references on COM_DEP_SECTIONS to adminSEC; 
grant select, insert, update, delete on COM_DEP_SECTIONS TO adminSEC  WITH GRANT OPTION;

grant references on COM_DEP_SECTIONS to adminOAM; 
grant select, insert, update, delete on COM_DEP_SECTIONS TO adminOAM  WITH GRANT OPTION;
-------------------------------------------------

grant references on COM_EMPLOYEES to adminwkf; 
grant select, insert, update, delete on COM_EMPLOYEES TO adminwkf  WITH GRANT OPTION;

grant references on COM_EMPLOYEES to adminSEC; 
grant select, insert, update, delete on COM_EMPLOYEES TO adminSEC  WITH GRANT OPTION;

grant references on COM_EMPLOYEES to adminoam; 
grant select, insert, update, delete on COM_EMPLOYEES TO adminoam  WITH GRANT OPTION;

grant references on COM_EMPLOYEES to adminret; 
grant select, insert, update, delete on COM_EMPLOYEES TO adminret  WITH GRANT OPTION;
--------------------------------------------------

grant references on COM_ESTABLISHMENTS to adminsec; 
grant select, insert, update, delete on COM_ESTABLISHMENTS TO adminsec    WITH GRANT OPTION;

grant references on COM_ESTABLISHMENTS to adminOAM; 
grant select, insert, update, delete on COM_ESTABLISHMENTS TO adminOAM    WITH GRANT OPTION;

grant references on COM_ESTABLISHMENTS to adminret; 
grant select, insert, update, delete on COM_ESTABLISHMENTS TO adminret    WITH GRANT OPTION;

