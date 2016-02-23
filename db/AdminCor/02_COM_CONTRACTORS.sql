--drop table COM_CONTRACTORS;

  CREATE TABLE COM_CONTRACTORS 
   (	NUM_CONTRACTOR        NUMBER(3)   not null, 
      DES_CONTRACTOR        VARCHAR2(60) not null,  
      dat_begin_validity    date not null, 
      dat_end_validity      date, 
      NAM_USER_MODIFY       VARCHAR2(10) not null,
      DAT_LAST_MODIFY       DATE not null,
      NUM_COUNTRY           NUMBER(5) NOT NULL 
   )    
    tablespace tbs_admincor_tables_1m
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
  
  
  alter table COM_CONTRACTORS
  add constraint COM_CONT_PK primary key (NUM_CONTRACTOR)
  using index 
  tablespace tbs_admincor_indexes_1m
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );


ALTER TABLE COM_CONTRACTORS ADD CONSTRAINT COM_cont_COUNT_FK1 FOREIGN KEY (NUM_COUNTRY )
REFERENCES COM_COUNTRIES (NUM_COUNTRY);


create index COM_cont_COUNT_FK1_I on COM_CONTRACTORS (NUM_COUNTRY)
  tablespace tbs_admincor_indexes_1m
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
--drop public synonym COM_CONTRACTORS;
--create public synonym COM_CONTRACTORS for COM_CONTRACTORS;
--grant select, insert, update, delete on COM_CONTRACTORS TO ROLE_admincor_FULL;



  
