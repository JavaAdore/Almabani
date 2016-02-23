--drop table OAM_SITE_LOCATIONS;

  CREATE TABLE OAM_SITE_LOCATIONS 
   (	NUM_site_location            NUMBER(6)     not null, 
      cod_site_location            VARCHAR2(10)  not null,
      DES_site_location            VARCHAR2(80)  not null,
      NUM_site_direction    NUMBER(5)     not null, 
      IND_TYPE_location       VARCHAR2(1)     not null, 
      IND_ACTIVE          VARCHAR2(1)   not null, 
      NAM_USER_MODIFY     VARCHAR2(10)  not null,
      DAT_LAST_MODIFY     DATE          not null
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
  
  
  alter table OAM_SITE_LOCATIONS
  add constraint OAM_sitloc_PK primary key (NUM_site_location)
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

  alter table OAM_SITE_LOCATIONS add   check (IND_ACTIVE IN ('Y', 'N'));

  alter table OAM_SITE_LOCATIONS add   check (IND_TYPE_location IN ('S', 'T', 'B'));

  
  
alter table OAM_SITE_LOCATIONS
  add constraint OAM_sitloc_sitdir_FK foreign key (NUM_site_direction)
  references OAM_SITE_directions (NUM_site_direction);

\*
alter table OAM_TYPES_PROFILES
  add constraint OAM_typPRO_DEP_FK foreign key (NUM_DEPARTMENT)
  references COM_DEPARTMENTS (NUM_DEPARTMENT);
*\
create index OAM_sitloc_sitdir_FK_I on OAM_SITE_LOCATIONS (NUM_site_direction)
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
--drop public synonym OAM_SITE_LOCATIONS;
--create public synonym OAM_SITE_LOCATIONS for OAM_SITE_LOCATIONS;
--grant select, insert, update, delete on OAM_SITE_LOCATIONS TO ROLE_oem_FULL;
--grant select on OAM_SITE_LOCATIONS to ROLE_oem_CONS;  

\*
  
--Oroba west east
Insert into OAM_SITE_LOCATIONS  values (oam_SEQ_NUM_site_location.nextval,'OR1','OR1',4,'S','Y',user,sysdate);
Insert into OAM_SITE_LOCATIONS  values (oam_SEQ_NUM_site_location.nextval,'OR2a','OR2a',4,'S','Y',user,sysdate);
Insert into OAM_SITE_LOCATIONS  values (oam_SEQ_NUM_site_location.nextval,'OR2b','OR2b',4,'S','Y',user,sysdate);
Insert into OAM_SITE_LOCATIONS  values (oam_SEQ_NUM_site_location.nextval,'OR2c','OR2c',4,'S','Y',user,sysdate);
Insert into OAM_SITE_LOCATIONS  values (oam_SEQ_NUM_site_location.nextval,'OR3','OR3',4,'S','Y',user,sysdate);
Insert into OAM_SITE_LOCATIONS  values (oam_SEQ_NUM_site_location.nextval,'T01','T01',4,'T','Y',user,sysdate);
Insert into OAM_SITE_LOCATIONS  values (oam_SEQ_NUM_site_location.nextval,'OR4','OR4',4,'S','Y',user,sysdate);
Insert into OAM_SITE_LOCATIONS  values (oam_SEQ_NUM_site_location.nextval,'OR5','OR5',4,'S','Y',user,sysdate);
Insert into OAM_SITE_LOCATIONS  values (oam_SEQ_NUM_site_location.nextval,'T02','T02',4,'T','Y',user,sysdate);
Insert into OAM_SITE_LOCATIONS  values (oam_SEQ_NUM_site_location.nextval,'OR6','OR6',4,'S','Y',user,sysdate);
Insert into OAM_SITE_LOCATIONS  values (oam_SEQ_NUM_site_location.nextval,'OR7','OR7',4,'S','Y',user,sysdate);
Insert into OAM_SITE_LOCATIONS  values (oam_SEQ_NUM_site_location.nextval,'BR1','BR1',4,'B','Y',user,sysdate);
Insert into OAM_SITE_LOCATIONS  values (oam_SEQ_NUM_site_location.nextval,'OR8a','OR8a',4,'S','Y',user,sysdate);
Insert into OAM_SITE_LOCATIONS  values (oam_SEQ_NUM_site_location.nextval,'OR8b','OR8b',4,'S','Y',user,sysdate);

Insert into OAM_SITE_LOCATIONS  values (oam_SEQ_NUM_site_location.nextval,'OR1','OR1',3,'S','Y',user,sysdate);
Insert into OAM_SITE_LOCATIONS  values (oam_SEQ_NUM_site_location.nextval,'OR2a','OR2a',3,'S','Y',user,sysdate);
Insert into OAM_SITE_LOCATIONS  values (oam_SEQ_NUM_site_location.nextval,'OR2b','OR2b',3,'S','Y',user,sysdate);
Insert into OAM_SITE_LOCATIONS  values (oam_SEQ_NUM_site_location.nextval,'OR2c','OR2c',3,'S','Y',user,sysdate);
Insert into OAM_SITE_LOCATIONS  values (oam_SEQ_NUM_site_location.nextval,'OR3','OR3',3,'S','Y',user,sysdate);
Insert into OAM_SITE_LOCATIONS  values (oam_SEQ_NUM_site_location.nextval,'T01','T01',3,'T','Y',user,sysdate);
Insert into OAM_SITE_LOCATIONS  values (oam_SEQ_NUM_site_location.nextval,'OR4','OR4',3,'S','Y',user,sysdate);
Insert into OAM_SITE_LOCATIONS  values (oam_SEQ_NUM_site_location.nextval,'OR5','OR5',3,'S','Y',user,sysdate);
Insert into OAM_SITE_LOCATIONS  values (oam_SEQ_NUM_site_location.nextval,'T02','T02',3,'T','Y',user,sysdate);
Insert into OAM_SITE_LOCATIONS  values (oam_SEQ_NUM_site_location.nextval,'OR6','OR6',3,'S','Y',user,sysdate);
Insert into OAM_SITE_LOCATIONS  values (oam_SEQ_NUM_site_location.nextval,'OR7','OR7',3,'S','Y',user,sysdate);
Insert into OAM_SITE_LOCATIONS  values (oam_SEQ_NUM_site_location.nextval,'BR1','BR1',3,'B','Y',user,sysdate);
Insert into OAM_SITE_LOCATIONS  values (oam_SEQ_NUM_site_location.nextval,'OR8a','OR8a',3,'S','Y',user,sysdate);
Insert into OAM_SITE_LOCATIONS  values (oam_SEQ_NUM_site_location.nextval,'OR8b','OR8b',3,'S','Y',user,sysdate);


--Abu Baker north South 2

Insert into OAM_SITE_LOCATIONS  values (oam_SEQ_NUM_site_location.nextval,'AB2a','AB2a',2,'S','Y',user,sysdate);
Insert into OAM_SITE_LOCATIONS  values (oam_SEQ_NUM_site_location.nextval,'AB2b','AB2b',2,'S','Y',user,sysdate);
Insert into OAM_SITE_LOCATIONS  values (oam_SEQ_NUM_site_location.nextval,'AB3a','AB3a',2,'S','Y',user,sysdate);
Insert into OAM_SITE_LOCATIONS  values (oam_SEQ_NUM_site_location.nextval,'AB3b','AB3b',2,'S','Y',user,sysdate);
Insert into OAM_SITE_LOCATIONS  values (oam_SEQ_NUM_site_location.nextval,'T3A','T3A',2,'T','Y',user,sysdate);
Insert into OAM_SITE_LOCATIONS  values (oam_SEQ_NUM_site_location.nextval,'T3B','T3B',2,'T','Y',user,sysdate);
Insert into OAM_SITE_LOCATIONS  values (oam_SEQ_NUM_site_location.nextval,'T3C','T3C',2,'T','Y',user,sysdate);
Insert into OAM_SITE_LOCATIONS  values (oam_SEQ_NUM_site_location.nextval,'AB4','AB4',2,'S','Y',user,sysdate);

Insert into OAM_SITE_LOCATIONS  values (oam_SEQ_NUM_site_location.nextval,'AB2a','AB2a',1,'S','Y',user,sysdate);
Insert into OAM_SITE_LOCATIONS  values (oam_SEQ_NUM_site_location.nextval,'AB2b','AB2b',1,'S','Y',user,sysdate);
Insert into OAM_SITE_LOCATIONS  values (oam_SEQ_NUM_site_location.nextval,'AB3a','AB3a',1,'S','Y',user,sysdate);
Insert into OAM_SITE_LOCATIONS  values (oam_SEQ_NUM_site_location.nextval,'AB3b','AB3b',1,'S','Y',user,sysdate);
Insert into OAM_SITE_LOCATIONS  values (oam_SEQ_NUM_site_location.nextval,'T3A','T3A',1,'T','Y',user,sysdate);
Insert into OAM_SITE_LOCATIONS  values (oam_SEQ_NUM_site_location.nextval,'T3B','T3B',1,'T','Y',user,sysdate);
Insert into OAM_SITE_LOCATIONS  values (oam_SEQ_NUM_site_location.nextval,'T3C','T3C',1,'T','Y',user,sysdate);
Insert into OAM_SITE_LOCATIONS  values (oam_SEQ_NUM_site_location.nextval,'AB4','AB4',1,'S','Y',user,sysdate);


grant references on OAM_SITE_LOCATIONS to adminWKF; 
grant select, insert, update, delete on OAM_SITE_LOCATIONS TO adminWKF  WITH GRANT OPTION;

commit;

  
  
*\