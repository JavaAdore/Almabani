--drop table RET_PAYMENTS_PLANS;
-- Create table
create table RET_PAYMENTS_PLANS
(
   num_PAYMENT_PLAN          NUMBER(5)     not null
  ,NUM_TYPE_PLAN             NUMBER(5)     not null
  ,NUM_TYPE_PAYMENT          NUMBER(3)     not null
  ,DAT_begin_VALIDity        DATE          not null
  ,DAT_end_VALIDity          DATE
  ,COD_LOGIN_insert            VARCHAR2(10)  not null
  ,DAT_record_insert           DATE          not null
  ,cod_login_MODIFY            VARCHAR2(10)    NOT NULL
  ,DAT_LAST_MODIFY             DATE             NOT NULL
  ,per_discount_pay_plan       NUMBER(5,2)     not null
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
alter table RET_PAYMENTS_PLANS
  add constraint RET_PAYpla_PK primary key (num_PAYMENT_PLAN)
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


ALTER TABLE RET_PAYMENTS_PLANS ADD CONSTRAINT RET_PAYpla_typPLA_FK FOREIGN KEY (NUM_TYPE_PLAN )
REFERENCES RET_TYPES_PLANS (NUM_TYPE_PLAN );

ALTER TABLE RET_PAYMENTS_PLANS ADD CONSTRAINT RET_PAYpla_typPAY_FK FOREIGN KEY (NUM_TYPE_PAYMENT )
REFERENCES RET_TYPES_PAYMENT (NUM_TYPE_PAYMENT );

create index RET_PAYpla_typPLA_FK_I on RET_PAYMENTS_PLANS (NUM_TYPE_PLAN)
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

create index RET_PAYpla_typPAY_FK_I on RET_PAYMENTS_PLANS (NUM_TYPE_PAYMENT)
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
--drop public synonym RET_PAYMENTS_PLANS;
--create public synonym RET_PAYMENTS_PLANS for RET_PAYMENTS_PLANS;
--grant select, insert, update, delete on RET_PAYMENTS_PLANS TO ROLE_adminret_FULL;

