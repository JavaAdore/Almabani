drop table OAM_TYPES_DOCUMENTS;

  CREATE TABLE OAM_TYPES_DOCUMENTS 
   (  NUM_TYPE_DOCUMENT    NUMBER(3)   not null, 
      DES_TYPE_DOCUMENT    VARCHAR2(80) not null,
	    num_company        NUMBER(4)    not null,
      IND_ACTIVE          VARCHAR2(1) not null,
	    COD_LOGIN_MODIFY    VARCHAR2(10) not null,
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
  
  
  alter table OAM_TYPES_DOCUMENTS
  add constraint OAM_TYPDOC_PK primary key (NUM_TYPE_DOCUMENT)
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
  
  alter table OAM_TYPES_DOCUMENTS add   check (IND_ACTIVE IN ('Y', 'N'));
  

  
alter table OAM_TYPES_DOCUMENTS
  add constraint OAM_typDOC_comp_FK foreign key (num_company)
  references COM_COMPANIES (num_company);

create index OAM_typDOC_comp_FK_I on OAM_TYPES_DOCUMENTS (num_company)
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
   


-- Grant/Revoke object privileges 
drop public synonym OAM_TYPES_DOCUMENTS;
create public synonym OAM_TYPES_DOCUMENTS for OAM_TYPES_DOCUMENTS;
grant select, insert, update, delete on OAM_TYPES_DOCUMENTS TO ROLE_BEYOND_FULL;



Insert into OAM_TYPES_DOCUMENTS  values (1,'Requisition Form',5,'Y',user,sysdate);
Insert into OAM_TYPES_DOCUMENTS  values (2,'Quotation Supplier',5,'Y',user,sysdate);
Insert into OAM_TYPES_DOCUMENTS  values (3,'Quotation Client',5,'Y',user,sysdate);
Insert into OAM_TYPES_DOCUMENTS  values (4,'Purchase Order',5,'Y',user,sysdate);

commit;

  
  
