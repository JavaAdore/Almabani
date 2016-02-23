
--select 'DROP public synonym '||table_name||';' from user_tables;
drop public synonym COM_COUNTRIES;
drop public synonym COM_CONTRACTORS;
drop public synonym COM_STATES;
drop public synonym COM_COMPANIES;
drop public synonym COM_PROJECTS;
drop public synonym COM_MUNICIPALITIES;
drop public synonym COM_ZIP_CODE;
drop public synonym COM_TYPES_HOLIDAYS;
drop public synonym COM_ESTABLISHMENTS;
drop public synonym COM_CALENDAR;
drop public synonym COM_TYPES_JOB_TITLE;
drop public synonym COM_DEPARTMENTS;
drop public synonym COM_DEP_SECTIONS;
drop public synonym COM_EMPLOYEES;


--select 'create public synonym '||table_name||' for '|| table_name||';' from user_tables;
create public synonym COM_COUNTRIES for COM_COUNTRIES;
create public synonym COM_CONTRACTORS for COM_CONTRACTORS;
create public synonym COM_STATES for COM_STATES;
create public synonym COM_COMPANIES for COM_COMPANIES;
create public synonym COM_PROJECTS for COM_PROJECTS;
create public synonym COM_MUNICIPALITIES for COM_MUNICIPALITIES;
create public synonym COM_ZIP_CODE for COM_ZIP_CODE;
create public synonym COM_TYPES_HOLIDAYS for COM_TYPES_HOLIDAYS;
create public synonym COM_ESTABLISHMENTS for COM_ESTABLISHMENTS;
create public synonym COM_CALENDAR for COM_CALENDAR;
create public synonym COM_TYPES_JOB_TITLE for COM_TYPES_JOB_TITLE;
create public synonym COM_DEPARTMENTS for COM_DEPARTMENTS;
create public synonym COM_DEP_SECTIONS for COM_DEP_SECTIONS;
create public synonym COM_EMPLOYEES for COM_EMPLOYEES;



--select 'DROP public synonym '||sequence_name||';' from user_sequences;
DROP public synonym COM_SEQ_COD_EMPLOYEE;
DROP public synonym COM_SEQ_NUM_COMPANY;
DROP public synonym COM_SEQ_NUM_CONTRACTOR;
DROP public synonym COM_SEQ_NUM_COUNTRY;
DROP public synonym COM_SEQ_NUM_DEPARTMENT;
DROP public synonym COM_SEQ_NUM_DEP_SECTION;
DROP public synonym COM_SEQ_NUM_ESTABLISHMENT;
DROP public synonym COM_SEQ_NUM_PROJECT;
DROP public synonym COM_SEQ_NUM_SEQ_CALENDAR;
DROP public synonym COM_SEQ_NUM_TYPE_JOB_TITLE;


--select 'CREATE public synonym  '||sequence_name||' for '||sequence_name||';' from user_sequences;

CREATE public synonym  COM_SEQ_COD_EMPLOYEE for COM_SEQ_COD_EMPLOYEE;
CREATE public synonym  COM_SEQ_NUM_COMPANY for COM_SEQ_NUM_COMPANY;
CREATE public synonym  COM_SEQ_NUM_CONTRACTOR for COM_SEQ_NUM_CONTRACTOR;
CREATE public synonym  COM_SEQ_NUM_COUNTRY for COM_SEQ_NUM_COUNTRY;
CREATE public synonym  COM_SEQ_NUM_DEPARTMENT for COM_SEQ_NUM_DEPARTMENT;
CREATE public synonym  COM_SEQ_NUM_DEP_SECTION for COM_SEQ_NUM_DEP_SECTION;
CREATE public synonym  COM_SEQ_NUM_ESTABLISHMENT for COM_SEQ_NUM_ESTABLISHMENT;
CREATE public synonym  COM_SEQ_NUM_PROJECT for COM_SEQ_NUM_PROJECT;
CREATE public synonym  COM_SEQ_NUM_SEQ_CALENDAR for COM_SEQ_NUM_SEQ_CALENDAR;
CREATE public synonym  COM_SEQ_NUM_TYPE_JOB_TITLE for COM_SEQ_NUM_TYPE_JOB_TITLE;

