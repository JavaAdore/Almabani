--drop table RET_ACCOUNTS_ENTRIES;
-- Create table
create table RET_ACCOUNTS_ENTRIES
(
   num_account_ENTRY         NUMBER(3)      not null
  ,NUM_COMPANY               NUMBER(4)      NOT NULL
  ,DES_account_ENTRY         VARCHAR2(80)   not null
  ,NUM_BANK                  NUMBER(4)      NOT NULL
  ,NUM_AGENCY                NUMBER(5)      NOT NULL
  ,NUM_ACCOUNT               NUMBER(10)     NOT NULL
  
  ,DAT_begin_VALIDity        DATE          not null
  ,DAT_end_VALIDity          DATE
  --
  ,COD_LOGIN_insert            VARCHAR2(10)  not null
  ,DAT_record_insert           DATE          not null
  ,cod_login_MODIFY            VARCHAR2(10)    NOT NULL
  ,DAT_LAST_MODIFY             DATE             NOT NULL
)
tablespace tbs_ADMINRET_tables_1m
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );

-- Create\Recreate primary, unique and foreign key constraints 
alter table RET_ACCOUNTS_ENTRIES
  add constraint RET_ACCENT_PK primary key (num_account_ENTRY)
  using index 
  tablespace tbs_ADMINRET_indexes_1m
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );

ALTER TABLE RET_ACCOUNTS_ENTRIES ADD CONSTRAINT RET_ACCENT_COMP_FK FOREIGN KEY (NUM_COMPANY )
REFERENCES COM_COMPANIES (NUM_COMPANY );


create index RET_ACCENT_COMP_FK_I on RET_ACCOUNTS_ENTRIES (NUM_COMPANY)
  tablespace tbs_ADMINRET_indexes_1m
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
  
  -- Grant\Revoke object privileges 
--drop public synonym RET_ACCOUNTS_ENTRIES;
--create public synonym RET_ACCOUNTS_ENTRIES for RET_ACCOUNTS_ENTRIES;
--grant select, insert, update, delete on RET_ACCOUNTS_ENTRIES TO ROLE_ADMINRET_FULL;

