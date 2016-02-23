--  DROP TABLE COM_DEP_SECTIONS;
  
  CREATE TABLE COM_DEP_SECTIONS 
   (	NUM_DEP_SECTION             NUMBER(4) not null, 
      NUM_DEPARTMENT          NUMBER(4) not null, 
      COD_SECTION             VARCHAR2(15) not null, 
      NAM_SECTION             VARCHAR2(40) not null,   
      IND_ACTIVE              VARCHAR2(1), 
      cod_USER_RESPONSIBLE    VARCHAR2(15), 
      DAT_LAST_MODIFY         DATE not null, 
      NAM_USER_MODIFY         VARCHAR2(10) not null
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
  
  
  alter table COM_DEP_SECTIONS
  add constraint COM_DEPSEC_PK  primary key (NUM_DEP_SECTION)
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

ALTER TABLE COM_DEP_SECTIONS ADD CONSTRAINT COM_DEPSEC_DEPART_FK FOREIGN KEY (NUM_DEPARTMENT)
	  REFERENCES COM_DEPARTMENTS (NUM_DEPARTMENT);

  alter table COM_DEP_SECTIONS add   check (IND_ACTIVE IN ('Y', 'N'));

  
create index COM_DEPSEC_DEPART_FK_I on COM_DEP_SECTIONS (NUM_DEPARTMENT)
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
--drop public synonym COM_DEP_SECTIONS; 
--create public synonym COM_DEP_SECTIONS for COM_DEP_SECTIONS;
--grant select, insert, update, delete on COM_DEP_SECTIONS TO ROLE_admincor_FULL;
     
      
      
--grant references on COM_DEP_SECTIONS to adminwkf; 
--grant select, insert, update, delete on COM_DEP_SECTIONS TO adminwkf  WITH GRANT OPTION;

--grant references on COM_DEP_SECTIONS to adminSEC; 
--grant select, insert, update, delete on COM_DEP_SECTIONS TO adminSEC  WITH GRANT OPTION;

--grant references on COM_DEP_SECTIONS to adminOAM; 
--grant select, insert, update, delete on COM_DEP_SECTIONS TO adminOAM  WITH GRANT OPTION;
