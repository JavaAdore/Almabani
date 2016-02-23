
--select 'DROP public synonym '||table_name||';' from user_tables;
DROP public synonym SEC_SYSTEMS;
DROP public synonym SEC_MODULES;
DROP public synonym SEC_SUB_MODULES;
DROP public synonym SEC_TYPES_APPLICATION;
DROP public synonym SEC_TYPES_PERFIL;
DROP public synonym SEC_APPLICATIONS;
DROP public synonym SEC_APPLICATIONS_COMPANIES;
DROP public synonym SEC_APPLICATIONS_GRANTS;
DROP public synonym SEC_USERS;
DROP public synonym SEC_PROCESSING_APPLICATIONS;
DROP public synonym SEC_LOG_PROCESSING_APPLICATION;


--select 'create public synonym '||table_name||' for '|| table_name||';' from user_tables;
create public synonym SEC_SYSTEMS for SEC_SYSTEMS;
create public synonym SEC_MODULES for SEC_MODULES;
create public synonym SEC_SUB_MODULES for SEC_SUB_MODULES;
create public synonym SEC_TYPES_APPLICATION for SEC_TYPES_APPLICATION;
create public synonym SEC_TYPES_PERFIL for SEC_TYPES_PERFIL;
create public synonym SEC_APPLICATIONS for SEC_APPLICATIONS;
create public synonym SEC_APPLICATIONS_COMPANIES for SEC_APPLICATIONS_COMPANIES;
create public synonym SEC_APPLICATIONS_GRANTS for SEC_APPLICATIONS_GRANTS;
create public synonym SEC_USERS for SEC_USERS;
create public synonym SEC_PROCESSING_APPLICATIONS for SEC_PROCESSING_APPLICATIONS;
create public synonym SEC_LOG_PROCESSING_APPLICATION for SEC_LOG_PROCESSING_APPLICATION;


--select 'DROP public synonym '||sequence_name||';' from user_sequences;
DROP public synonym SEC_SEQ_NUM_APPLICATION_GRANT;
DROP public synonym SEC_SEQ_NUM_APP_COMPANY;
DROP public synonym SEC_SEQ_NUM_LOG_PROCESSING;
DROP public synonym SEC_SEQ_NUM_MODULE;
DROP public synonym SEC_SEQ_NUM_SUB_MODULE;
DROP public synonym SEC_SEQ_NUM_SYSTEM;
DROP public synonym SEC_SEQ_NUM_TYPE_APPLICATION;
DROP public synonym SEC_SEQ_NUM_USER_APP_GRANT;

--select 'CREATE public synonym  '||sequence_name||' for '||sequence_name||';' from user_sequences;

CREATE public synonym  SEC_SEQ_NUM_APPLICATION_GRANT for SEC_SEQ_NUM_APPLICATION_GRANT;
CREATE public synonym  SEC_SEQ_NUM_APP_COMPANY for SEC_SEQ_NUM_APP_COMPANY;
CREATE public synonym  SEC_SEQ_NUM_LOG_PROCESSING for SEC_SEQ_NUM_LOG_PROCESSING;
CREATE public synonym  SEC_SEQ_NUM_MODULE for SEC_SEQ_NUM_MODULE;
CREATE public synonym  SEC_SEQ_NUM_SUB_MODULE for SEC_SEQ_NUM_SUB_MODULE;
CREATE public synonym  SEC_SEQ_NUM_SYSTEM for SEC_SEQ_NUM_SYSTEM;
CREATE public synonym  SEC_SEQ_NUM_TYPE_APPLICATION for SEC_SEQ_NUM_TYPE_APPLICATION;
CREATE public synonym  SEC_SEQ_NUM_USER_APP_GRANT for SEC_SEQ_NUM_USER_APP_GRANT;
