--drop table OAM_SUPPLIERS;

  CREATE TABLE OAM_SUPPLIERS 
   (	NUM_SUPPLIER            NUMBER(3)     not null, 
      NAM_SUPPLIER            VARCHAR2(50)  not null,
      NUM_COMPANY             NUMBER(4)     NOT NULL,  
      NAM_ADDRESS             VARCHAR2(50) not null,
      NAM_ADD_COMPLEMENT      VARCHAR2(50),
      NAM_RESPONSIBLE         VARCHAR2(50),
      NUM_TELEFONE            NUMBER(10),  
      NUM_MOBILE              NUMBER(10),  
      NUM_FAX                 NUMBER(10),  
      DES_OBSERVATION         VARCHAR2(300), 
      IND_ACTIVE              VARCHAR2(1) not null, 
      NAM_USER_MODIFY         VARCHAR2(10) not null,
      DAT_LAST_MODIFY         DATE not null,
      DES_EMAIL               VARCHAR2(50) ,
      IND_PROSPECT VARCHAR2(1) not null
   )    
    tablespace tbs_adminoam_tables_1m
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
  
  
  alter table OAM_SUPPLIERS
  add constraint OAM_SUP_PK primary key (NUM_SUPPLIER)
  using index 
  tablespace tbs_adminoam_indexes_1m
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
  
  alter table OAM_SUPPLIERS add   check (IND_ACTIVE IN ('Y', 'N'));
  
    alter table OAM_SUPPLIERS add   check (IND_PROSPECT IN ('Y', 'N'));
    

alter table OAM_SUPPLIERS
  add constraint OAM_SUP_COMP_FK foreign key (NUM_COMPANY)
  references COM_COMPANIES (NUM_COMPANY);
   

create index OAM_SUP_COMP_FK_I on OAM_SUPPLIERS (NUM_COMPANY)
  tablespace tbs_adminoam_indexes_1m
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
--drop public synonym OAM_SUPPLIERS;
--create public synonym OAM_SUPPLIERS for OAM_SUPPLIERS;
--grant select, insert, update, delete on OAM_SUPPLIERS TO ROLE_adminoam_FULL;


  
  
