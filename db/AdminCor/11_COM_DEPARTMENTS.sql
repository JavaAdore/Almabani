 -- DROP TABLE COM_DEPARTMENTS;
  
  CREATE TABLE COM_DEPARTMENTS 
   (	NUM_DEPARTMENT          NUMBER(4) not null, 
      NUM_COMPANY             NUMBER(4) not null, 
      COD_DEPARTMENT          VARCHAR2(15) not null, 
      NAM_DEPARTMENT          VARCHAR2(40) not null,   
      IND_ACTIVE              VARCHAR2(1), 
      COD_USER_RESPONSIBLE    VARCHAR2(15), 
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
  
  
  alter table COM_DEPARTMENTS
  add constraint COM_DEPART_PK  primary key (NUM_DEPARTMENT)
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

ALTER TABLE COM_DEPARTMENTS ADD CONSTRAINT COM_DEPART_COMP_FK FOREIGN KEY (NUM_COMPANY)
	  REFERENCES COM_COMPANIES (NUM_COMPANY);

  alter table COM_DEPARTMENTS add   check (IND_ACTIVE IN ('Y', 'N'));

  
create index COM_DEPART_COMP_FK_I on COM_DEPARTMENTS (NUM_COMPANY)
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
--drop public synonym COM_DEPARTMENTS;
--create public synonym COM_DEPARTMENTS for COM_DEPARTMENTS;
--grant select, insert, update, delete on COM_DEPARTMENTS TO ROLE_admincor_FULL;


--grant references on COM_DEPARTMENTS to adminwkf; 
--grant select, insert, update, delete on COM_DEPARTMENTS TO adminwkf  WITH GRANT OPTION;


--grant references on COM_DEPARTMENTS to adminSEC; 
--grant select, insert, update, delete on COM_DEPARTMENTS TO adminSEC  WITH GRANT OPTION;

--grant references on COM_DEPARTMENTS to adminoam; 
--grant select, insert, update, delete on COM_DEPARTMENTS TO adminoam  WITH GRANT OPTION;
