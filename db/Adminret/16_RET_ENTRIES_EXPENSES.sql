--drop table RET_ENTRIES_EXPENSES;
-- Create table
create table RET_ENTRIES_EXPENSES
(
   num_ENTRY_EXPENSE            NUMBER(9)     not null
  ,NUM_ACCOUNT_ENTRY           NUMBER(3)  not null
  ,num_SUB_TYPE_EXPENSE         NUMBER(6)     not null
  ,DAT_ENTRY                    DATE          NOT NULL
  ,DAT_registration_ENTRY       DATE          NOT NULL
  ,ind_adjustment               VARCHAR2(1)   not null
  ,VAL_ENTRY                    NUMBER(15,2)  not null
  ,DES_observation              VARCHAR2(80)
  ,DES_motive_adjustment        VARCHAR2(80)
  --
  ,COD_LOGIN_insert            VARCHAR2(10)   not null
  ,DAT_record_insert           DATE           not null

)
tablespace tbs_ADMINRET_tables_5m
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 10M
    NEXT 5M
    minextents 1
    maxextents unlimited
  );

-- Create\Recreate primary, unique and foreign key constraints 
alter table RET_ENTRIES_EXPENSES
  add constraint RET_ENTEXP_PK primary key (num_ENTRY_EXPENSE)
  using index 
  tablespace tbs_ADMINRET_indexes_5m
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 10M
    NEXT 5M
    minextents 1
    maxextents unlimited
  );



 alter table RET_ENTRIES_EXPENSES
  add  check (ind_adjustment IN ('Y', 'N'));
  
ALTER TABLE RET_ENTRIES_EXPENSES ADD CONSTRAINT RET_ENTXPP_SUBTYPEXP_FK FOREIGN KEY (num_SUB_TYPE_EXPENSE )
REFERENCES RET_SUB_TYPES_EXPENSES (num_SUB_TYPE_EXPENSE );

ALTER TABLE RET_ENTRIES_EXPENSES ADD CONSTRAINT RET_ENTXPP_ACCENT_FK FOREIGN KEY (NUM_ACCOUNT_ENTRY )
REFERENCES RET_ACCOUNTS_ENTRIES (NUM_ACCOUNT_ENTRY );

create index RET_ENTXPP_SUBTYPEXP_FK_I on RET_ENTRIES_EXPENSES (num_SUB_TYPE_EXPENSE)
  tablespace tbs_ADMINRET_indexes_1m
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 10M
    NEXT 5M
    minextents 1
    maxextents unlimited
  );
  
  
  create index RET_ENTXPP_ACCENT_FK_I on RET_ENTRIES_EXPENSES (NUM_ACCOUNT_ENTRY)
  tablespace tbs_ADMINRET_indexes_5m
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 10M
    NEXT 5M
    minextents 1
    maxextents unlimited
  );
  
  -- Grant\Revoke object privileges 
--drop public synonym RET_ENTRIES_EXPENSES;
--create public synonym RET_ENTRIES_EXPENSES for RET_ENTRIES_EXPENSES;
--grant select, insert, update, delete on RET_ENTRIES_EXPENSES TO ROLE_ADMINRET_FULL;
