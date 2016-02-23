


--select 'grant select, INSERT, update, delete on  '||table_name||' to USERONLINE;' from user_tables;

grant select, INSERT, update, delete on  WOK_TYPES_SYMPTOMS to USERONLINE;
grant select, INSERT, update, delete on  WOK_TYPES_DEMAND to USERONLINE;
grant select, INSERT, update, delete on  WOK_TYPES_PROFILES to USERONLINE;
grant select, INSERT, update, delete on  WOK_TYPES_ACTIONS to USERONLINE;
grant select, INSERT, update, delete on  WOK_TYPES_IMPACT to USERONLINE;
grant select, INSERT, update, delete on  WOK_CONFIGURATIONS_TYPES to USERONLINE;
grant select, INSERT, update, delete on  WOK_CONFIGURATIONS_ITEM to USERONLINE;
grant select, INSERT, update, delete on  WOK_WORKING_GROUPS to USERONLINE;
grant select, INSERT, update, delete on  WOK_USERS_GROUP to USERONLINE;
grant select, INSERT, update, delete on  WOK_DEMANDS_PRIORITY to USERONLINE;
grant select, INSERT, update, delete on  WOK_TYPES_OCCURRENCE to USERONLINE;
grant select, INSERT, update, delete on  WOK_NEXT_ACTIONS to USERONLINE;
grant select, INSERT, update, delete on  WOK_PROFILES_ACTIONS to USERONLINE;
grant select, INSERT, update, delete on  WOK_DEMANDS to USERONLINE;
grant select, INSERT, update, delete on  WOK_OCCURRENCES_DEMAND to USERONLINE;
grant select, INSERT, update, delete on  WOK_DEMANDS_ACTIVITIES to USERONLINE;
grant select, INSERT, update, delete on  WOK_DAILY_OCURRENCES to USERONLINE;
grant select, INSERT, update, delete on  WOK_DOCUMENTS_DEMAND to USERONLINE;
grant select, INSERT, update, delete on  WOK_GENERAL_PARAMETERS to USERONLINE;

--select 'grant select on   '||sequence_name||' to USERONLINE;' from user_sequences;

grant select on   WOK_SEQ_NUM_ACTIVITY to USERONLINE;
grant select on   WOK_SEQ_NUM_DAILY_OCCURRENCE to USERONLINE;
grant select on   WOK_SEQ_NUM_DEMAND to USERONLINE;
grant select on   WOK_SEQ_NUM_OCCURRENCE to USERONLINE;
grant select on   WOK_SEQ_NUM_PROFILE_ACTION to USERONLINE;
grant select on   WOK_SEQ_NUM_TYPE_ACTION to USERONLINE;
grant select on   WOK_SEQ_NUM_TYPE_PROFILE to USERONLINE;

grant references on WOK_CONFIGURATIONS_ITEM to adminoam; 
grant select, insert, update, delete on WOK_CONFIGURATIONS_ITEM TO adminoam  WITH GRANT OPTION;

grant references on wok_demands to adminoam; 
grant select, insert, update, delete on wok_demands TO adminoam  WITH GRANT OPTION;
