--drop table OAM_TYPES_DEVICE;

  CREATE TABLE OAM_TYPES_DEVICE 
   (	NUM_TYPE_DEVICE    NUMBER(3)   not null, 
      DES_TYPE_DEVICE    VARCHAR2(80) not null,
      IND_ACTIVE         VARCHAR2(1) not null, 
      NAM_USER_MODIFY    VARCHAR2(10) not null,
      DAT_LAST_MODIFY    DATE not null
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
  
  
  alter table OAM_TYPES_DEVICE
  add constraint OAM_TYPDEV_PK primary key (NUM_TYPE_DEVICE)
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
  
  alter table OAM_TYPES_DEVICE add   check (IND_ACTIVE IN ('Y', 'N'));
  

\*
alter table OAM_TYPES_DEVICE
  add constraint OAM_TYPDEV_DEP_FK foreign key (NUM_DEPARTMENT)
  references COM_DEPARTMENTS (NUM_DEPARTMENT);
  *\

  
  \*
   create index OAM_TYPDEV_DEP_FK_I on OAM_TYPES_DEVICE (NUM_DEPARTMENT)
  tablespace tbs_indexes_oem_1m
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );  
  *\
   


-- Grant\Revoke object privileges 
--drop public synonym OAM_TYPES_DEVICE;
--create public synonym OAM_TYPES_DEVICE for OAM_TYPES_DEVICE;
--grant select, insert, update, delete on OAM_TYPES_DEVICE TO ROLE_oem_FULL;
--grant select on OAM_TYPES_DEVICE to ROLE_oem_CONS;  



--Insert into OAM_TYPES_DEVICE  values (1,'VMS system','Y',user,sysdate);
--Insert into OAM_TYPES_DEVICE  values (2,'Fixed Cameras','Y',user,sysdate);
--Insert into OAM_TYPES_DEVICE  values (3,'PTZ Cameras','Y',user,sysdate);
--Insert into OAM_TYPES_DEVICE  values (4,'CCTV Cabinets','Y',user,sysdate);

--commit;

  
  
