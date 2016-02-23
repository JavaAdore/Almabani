--drop table OAM_MANUFACTURERS;

  CREATE TABLE OAM_MANUFACTURERS 
   (	NUM_MANUFACTURER   NUMBER(3)   not null, 
      NAM_MANUFACTURER   VARCHAR2(80) not null,
      NUM_COMPANY         NUMBER(4) NOT NULL,  
      IND_ACTIVE          VARCHAR2(1) not null, 
      NAM_USER_MODIFY     VARCHAR2(10) not null,
      DAT_LAST_MODIFY     DATE not null
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
  
  
  alter table OAM_MANUFACTURERS
  add constraint OAM_MAN_PK primary key (NUM_MANUFACTURER)
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
  
  alter table OAM_MANUFACTURERS add   check (IND_ACTIVE IN ('Y', 'N'));
  

alter table OAM_MANUFACTURERS
  add constraint oam_MAN_COMP_FK foreign key (NUM_COMPANY)
  references COM_COMPANIES (NUM_COMPANY);
   

create index oam_MAN_COMP_FK_I on OAM_MANUFACTURERS (NUM_COMPANY)
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
--drop public synonym OAM_MANUFACTURERS;
--create public synonym OAM_MANUFACTURERS for OAM_MANUFACTURERS;
--grant select, insert, update, delete on OAM_MANUFACTURERS TO ROLE_adminoam_FULL;
