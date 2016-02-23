
--select 'drop table '||table_name||' cascade constraints;' from user_tables

drop table RET_ACCOUNTS_ENTRIES cascade constraints;
drop table RET_TYPES_EXPENSES cascade constraints;
drop table RET_SUB_TYPES_EXPENSES cascade constraints;
drop table RET_ENTRIES_EXPENSES cascade constraints;
drop table RET_TYPES_COMPANIES_ACTIVITY cascade constraints;
drop table RET_TYPES_PAYMENT cascade constraints;
drop table RET_TYPES_PLANS cascade constraints;
drop table RET_PAYMENTS_PLANS cascade constraints;
drop table RET_CLIENTS_COMPANIES cascade constraints;
drop table RET_CLIENTS_COMP_TRACKING cascade constraints;
drop table RET_TYPES_DISCOUNT cascade constraints;
drop table RET_COMPANIES_CONTRACTS cascade constraints;
drop table RET_TYPES_CONTRACTS_SITUATION cascade constraints;
drop table RET_INSTALLMENTS_CONTRACT cascade constraints;
drop table RET_SITUATIONS_CONTRACT cascade constraints;
drop table RET_CLIENTS cascade constraints;

-- Create 
@/run/media/orclqq/Home/TMP_Zaher/Adminret/15_RET_ACCOUNTS_ENTRIES.sql
@/run/media/orclqq/Home/TMP_Zaher/Adminret/13_RET_TYPES_EXPENSES.sql
@/run/media/orclqq/Home/TMP_Zaher/Adminret/14_RET_SUB_TYPES_EXPENSES.sql
@/run/media/orclqq/Home/TMP_Zaher/Adminret/16_RET_ENTRIES_EXPENSES.sql
@/run/media/orclqq/Home/TMP_Zaher/Adminret/01_RET_TYPES_COMPANIES_ACTIVITY.sql
@/run/media/orclqq/Home/TMP_Zaher/Adminret/06_RET_TYPES_PAYMENT.sql
@/run/media/orclqq/Home/TMP_Zaher/Adminret/07_RET_TYPES_PLANS.sql
@/run/media/orclqq/Home/TMP_Zaher/Adminret/09_RET_PAYMENTS_PLANS.sql
@/run/media/orclqq/Home/TMP_Zaher/Adminret/02_RET_CLIENTS_COMPANIES.sql
@/run/media/orclqq/Home/TMP_Zaher/Adminret/04_RET_CLIENTS_COMP_TRACKING.sql
@/run/media/orclqq/Home/TMP_Zaher/Adminret/05_RET_TYPES_DISCOUNT.sql
@/run/media/orclqq/Home/TMP_Zaher/Adminret/10_RET_COMPANIES_CONTRACTS.sql
@/run/media/orclqq/Home/TMP_Zaher/Adminret/08_RET_TYPES_CONTRACTS_SITUATION.sql
@/run/media/orclqq/Home/TMP_Zaher/Adminret/11_RET_INSTALLMENTS_CONTRACT.sql
@/run/media/orclqq/Home/TMP_Zaher/Adminret/12_RET_SITUATIONS_CONTRACT.sql
@/run/media/orclqq/Home/TMP_Zaher/Adminret/03_RET_CLIENTS.sql


