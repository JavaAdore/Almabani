--drop table OAM_TYPES_MATERIAL;

  CREATE TABLE OAM_TYPES_MATERIAL 
   (	NUM_TYPE_MATERIAL   NUMBER(3)   not null, 
      DES_TYPE_MATERIAL   VARCHAR2(80) not null,
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
  
  
  alter table OAM_TYPES_MATERIAL
  add constraint OAM_TYPMAT_PK primary key (NUM_TYPE_MATERIAL)
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
  
  alter table OAM_TYPES_MATERIAL add   check (IND_ACTIVE IN ('Y', 'N'));
  

alter table OAM_TYPES_MATERIAL
  add constraint oam_TYPMAT_COMP_FK foreign key (NUM_COMPANY)
  references COM_COMPANIES (NUM_COMPANY);
   

create index oam_TYPMAT_COMP_FK_I on OAM_TYPES_MATERIAL (NUM_COMPANY)
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
--drop public synonym OAM_TYPES_MATERIAL;
--create public synonym OAM_TYPES_MATERIAL for OAM_TYPES_MATERIAL;
--grant select, insert, update, delete on OAM_TYPES_MATERIAL TO ROLE_adminoam_FULL;
  
  
