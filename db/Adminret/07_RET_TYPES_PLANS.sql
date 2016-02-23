--drop table RET_TYPES_PLANS;
-- Create table
create table RET_TYPES_PLANS
(
  num_TYPE_PLAN                  NUMBER(5)     not null
 ,NUM_COMPANY                NUMBER(4)      NOT NULL
  ,DES_SERVICE_PLAN          VARCHAR2(80)  not null
  ,DAT_begin_VALIDity        DATE          not null
  ,DAT_end_VALIDity          DATE
  ,num_day_payment_delay     NUMBER(5)
  ,VAL_SERVICE_PLAN          NUMBER(15,2)     not null
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
alter table RET_TYPES_PLANS
  add constraint RET_TYPpla_PK primary key (num_TYPE_PLAN)
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

ALTER TABLE RET_TYPES_PLANS ADD CONSTRAINT RET_TYPpla_COMP_FK FOREIGN KEY (NUM_COMPANY )
REFERENCES COM_COMPANIES (NUM_COMPANY );


create index RET_TYPpla_COMP_FK_I on RET_TYPES_PLANS (NUM_COMPANY)
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
--drop public synonym RET_TYPES_PLANS;
--create public synonym RET_TYPES_PLANS for RET_TYPES_PLANS;
--grant select, insert, update, delete on RET_TYPES_PLANS TO ROLE_adminret_FULL;
--grant select on RET_TYPES_PLANS to ROLE_oem_CONS; 

