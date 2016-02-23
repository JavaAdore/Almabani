-- Create Sequence
-- No sequence

--drop table RET_SITUATIONS_CONTRACT;

-- Create table
create table RET_SITUATIONS_CONTRACT
(
  num_SITUATION_CONTRACT    NUMBER(19) NOT NULL  
 , dat_SITUATION_CONTRACT    DATE          not null
 , NUM_TYPE_CONTR_SITUATION  NUMBER(3) NOT NULL
 , NUM_COMPANY_CONTRACT      NUMBER(15) NOT NULL  
 , des_observation           varchar2(150)
--
,  COD_LOGIN_insert         VARCHAR2(10)  not null
,  DAT_record_insert        DATE          not null
,  cod_login_MODIFY         VARCHAR2(10)    NOT NULL
,  DAT_LAST_MODIFY          DATE             NOT NULL
 )
tablespace tbs_adminret_tables_5m
  pctfree 10
  pctused 40
  initrans 1
  maxtrans 255
  storage
  (
    initial 10m
    next 5m
     minextents 1
    maxextents unlimited
    pctincrease 0
  );
--
-- Create\Recreate primary, unique and foreign key constraints 
alter table RET_SITUATIONS_CONTRACT
  add constraint RET_SITCON_PK primary key (    num_SITUATION_CONTRACT)
  using index 
    tablespace tbs_adminret_indexes_5m
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
   initial 10m
    next 5m
     minextents 1
    maxextents unlimited
    pctincrease 0
  );
  
--
  
alter table RET_SITUATIONS_CONTRACT
  add constraint RET_SITCON_typCONSIT_FK foreign key (NUM_TYPE_CONTR_SITUATION)
  references RET_TYPES_CONTRACTS_SITUATION (NUM_TYPE_CONTR_SITUATION);
 
 alter table RET_SITUATIONS_CONTRACT
  add constraint RET_SITCON_COMCON_FK foreign key (NUM_COMPANY_CONTRACT)
  references RET_COMPANIES_CONTRACTS (NUM_COMPANY_CONTRACT);

   
--  
-- Create\Recreate indexes 
create index RET_SITCON_typCONSIT_FK_I on RET_SITUATIONS_CONTRACT (NUM_TYPE_CONTR_SITUATION)
  tablespace tbs_adminret_indexes_5m
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
   initial 10m
    next 5m
      minextents 1
    maxextents unlimited
    pctincrease 0
  );


create index RET_SITCON_COMCON_FK_i on RET_SITUATIONS_CONTRACT (NUM_COMPANY_CONTRACT)
  tablespace tbs_adminret_indexes_5m
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 10m
    next 5m
     minextents 1
    maxextents unlimited
    pctincrease 0
  );



-- Grant\Revoke object privileges 
--drop public synonym RET_SITUATIONS_CONTRACT;
--create public synonym RET_SITUATIONS_CONTRACT for RET_SITUATIONS_CONTRACT;
--grant select,insert, update, delete on RET_SITUATIONS_CONTRACT TO ROLE_adminret_FULL;


