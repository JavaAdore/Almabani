


--select 'grant select, INSERT, update, delete on  '||table_name||' to USERONLINE;' from user_tables;

grant select, INSERT, update, delete on  RET_ACCOUNTS_ENTRIES to USERONLINE;
grant select, INSERT, update, delete on  RET_TYPES_EXPENSES to USERONLINE;
grant select, INSERT, update, delete on  RET_SUB_TYPES_EXPENSES to USERONLINE;
grant select, INSERT, update, delete on  RET_ENTRIES_EXPENSES to USERONLINE;
grant select, INSERT, update, delete on  RET_TYPES_COMPANIES_ACTIVITY to USERONLINE;
grant select, INSERT, update, delete on  RET_TYPES_PAYMENT to USERONLINE;
grant select, INSERT, update, delete on  RET_TYPES_PLANS to USERONLINE;
grant select, INSERT, update, delete on  RET_PAYMENTS_PLANS to USERONLINE;
grant select, INSERT, update, delete on  RET_CLIENTS_COMPANIES to USERONLINE;
grant select, INSERT, update, delete on  RET_CLIENTS_COMP_TRACKING to USERONLINE;
grant select, INSERT, update, delete on  RET_TYPES_DISCOUNT to USERONLINE;
grant select, INSERT, update, delete on  RET_COMPANIES_CONTRACTS to USERONLINE;
grant select, INSERT, update, delete on  RET_TYPES_CONTRACTS_SITUATION to USERONLINE;
grant select, INSERT, update, delete on  RET_INSTALLMENTS_CONTRACT to USERONLINE;
grant select, INSERT, update, delete on  RET_SITUATIONS_CONTRACT to USERONLINE;
grant select, INSERT, update, delete on  RET_CLIENTS to USERONLINE;

--select 'grant select on   '||sequence_name||' to USERONLINE;' from user_sequences;

grant select on   RET_SEQ_NUM_CLIENT to USERONLINE;
grant select on   RET_SEQ_NUM_CLIENT_COMPANY to USERONLINE;
grant select on   RET_SEQ_NUM_CLI_COMP_TRACKING to USERONLINE;
grant select on   RET_SEQ_NUM_COMPANY_CONTRACT to USERONLINE;
grant select on   RET_SEQ_NUM_ENTRY_EXPENSE to USERONLINE;
grant select on   RET_SEQ_NUM_PAYMENT_PLAN to USERONLINE;
grant select on   RET_SEQ_NUM_SITUATION_CONTRACT to USERONLINE;
grant select on   RET_SEQ_NUM_SUB_TYPE_EXPENSE to USERONLINE;
grant select on   RET_SEQ_NUM_TYPE_COMP_ACTIVITY to USERONLINE;
grant select on   RET_SEQ_NUM_TYPE_CONTR_SIT to USERONLINE;
grant select on   RET_SEQ_NUM_TYPE_DISCOUNT to USERONLINE;
grant select on   RET_SEQ_NUM_TYPE_EXPENSE to USERONLINE;
grant select on   RET_SEQ_NUM_TYPE_PAYMENT to USERONLINE;
grant select on   RET_SEQ_NUM_TYPE_PLAN to USERONLINE;