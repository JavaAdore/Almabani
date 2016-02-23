--drop table  RET_CLIENTS_COMP_TRACKING;

CREATE TABLE  RET_CLIENTS_COMP_TRACKING
  (
    NUM_client_COMP_tracking    number(15)        NOT NULL, 
    NUM_CLIENT_COMPANY          NUMBER(12)    NOT NULL, 
    DES_tracking                VARCHAR2(300) NOT NULL, 
    dat_next_reminder           date, 
    dat_process_reminder        date, 
    --
    COD_LOGIN_insert            VARCHAR2(10)  not null,
    DAT_record_insert           DATE          not null,
    cod_login_MODIFY            VARCHAR2(10)    NOT NULL,
    DAT_LAST_MODIFY             DATE             NOT NULL
  ) tablespace tbs_adminret_tables_5m
  pctfree 10
  pctused 40
  initrans 1
  maxtrans 255
  storage
  (
    initial 1m
    next 1m
    minextents 1
    maxextents unlimited
    pctincrease 0
  );

ALTER TABLE  RET_CLIENTS_COMP_TRACKING ADD CONSTRAINT RET_CLICOMTRA_PK PRIMARY KEY ( NUM_client_COMP_tracking ) using index 
  tablespace tbs_adminret_indexes_5m
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 1m
    next 1m
    minextents 1
    maxextents unlimited
    pctincrease 0
  );


--ALTER TABLE RET_CLIENTS_COMP_TRACKING ADD CHECK (ind_reminder IN ( 'Y' , 'N' ));

ALTER TABLE  RET_CLIENTS_COMP_TRACKING ADD CONSTRAINT RET_CLICOMTRA_CLICOM_FK 
FOREIGN KEY ( NUM_CLIENT_COMPANY ) REFERENCES  RET_CLIENTS_COMPANIES ( NUM_CLIENT_COMPANY ) ;

-- 
create index RET_CLICOMTRA_CLICOM_FK_I on RET_CLIENTS_COMP_TRACKING (NUM_CLIENT_COMPANY)
  tablespace tbs_adminret_indexes_5m
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 1m
    next 1m
    minextents 1
    maxextents unlimited
    pctincrease 0
  );

-- Grant\Revoke object privileges 
--drop public synonym RET_CLIENTS_COMP_TRACKING;
--create public synonym RET_CLIENTS_COMP_TRACKING for RET_CLIENTS_COMP_TRACKING;
--grant select, insert, update, delete on RET_CLIENTS_COMP_TRACKING TO ROLE_adminret_FULL;

