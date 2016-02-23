--drop table RET_SUB_TYPES_EXPENSES;
-- Create table
create table RET_SUB_TYPES_EXPENSES
(
   num_SUB_TYPE_EXPENSE           NUMBER(5)     not null
  ,num_TYPE_EXPENSE           NUMBER(6)     not null
  ,DES_SUB_TYPE_EXPENSE          VARCHAR2(80)  not null
  ,IND_CRED_DEB             VARCHAR2(1)  not null
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
alter table RET_SUB_TYPES_EXPENSES
  add constraint RET_SUBTYPEXP_PK primary key (num_SUB_TYPE_EXPENSE)
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

ALTER TABLE RET_SUB_TYPES_EXPENSES ADD CONSTRAINT RET_SUBTYPEXPP_TYPEXP_FK FOREIGN KEY (num_TYPE_EXPENSE )
REFERENCES RET_TYPES_EXPENSES (num_TYPE_EXPENSE );


create index RET_SUBTYPEXPP_TYPEXP_FK_I on RET_SUB_TYPES_EXPENSES (num_TYPE_EXPENSE)
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
--drop public synonym RET_SUB_TYPES_EXPENSES;
--create public synonym RET_SUB_TYPES_EXPENSES for RET_SUB_TYPES_EXPENSES;
--grant select, insert, update, delete on RET_SUB_TYPES_EXPENSES TO ROLE_ADMINRET_FULL;

