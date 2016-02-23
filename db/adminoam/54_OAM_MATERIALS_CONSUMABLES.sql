--drop table OAM_Materials_Consumables;

  CREATE TABLE OAM_Materials_Consumables 
   (	NUM_Material_Consumable        NUMBER(3)   not null, 
      DES_Material_Consumable        VARCHAR2(100) not null,
      NUM_project                   NUMBER(3)  not null,
      IND_ACTIVE                    VARCHAR2(1) not null, 
      val_Material_Consumable        number(15,2) not null,
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
  
  
  alter table OAM_Materials_Consumables
  add constraint OAM_matcon_PK primary key (NUM_Material_Consumable)
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

  alter table OAM_Materials_Consumables add   check (IND_ACTIVE IN ('Y', 'N'));
  
alter table OAM_Materials_Consumables
  add constraint OAM_matcon_proj_FK foreign key (NUM_project)
  references COM_projects (NUM_project);


create index OAM_matcon_proj_FK_I on OAM_Materials_Consumables (NUM_project)
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
  

\*
-- Grant\Revoke object privileges 
drop public synonym OAM_Materials_Consumables;
create public synonym OAM_Materials_Consumables for OAM_Materials_Consumables;
grant select, insert, update, delete on OAM_Materials_Consumables TO ROLE_oem_FULL;
grant select on OAM_Materials_Consumables to ROLE_oem_CONS;  


insert into OAM_Materials_Consumables values (1,'Welding materials , with gases and accessories',1,'Y',710,user,sysdate);
insert into OAM_Materials_Consumables values (2,'Mortar Materials',1,'Y',11.589,user,sysdate); 
insert into OAM_Materials_Consumables values (3,'Paints and Solutions',1,'Y',2.949,user,sysdate); 
insert into OAM_Materials_Consumables values (4,'Sealants, fillers, expansion joints and silicon',1,'Y',1.164,user,sysdate); 
insert into OAM_Materials_Consumables values (5,'Oils and lubricants',1,'Y',5.474,user,sysdate); 
insert into OAM_Materials_Consumables values (6,'RO Chemicals - Caustic Soda',1,'Y',1.294,user,sysdate); 
insert into OAM_Materials_Consumables values (7,'RO chemicals-  Sulphuric Acids 98%',1,'Y',1.941,user,sysdate); 
insert into OAM_Materials_Consumables values (8,'RO chemicals - Sodium bisulfite A-50 to remove chlorine',1,'Y',1.941,user,sysdate); 
insert into OAM_Materials_Consumables values (9,'RO chemicals-  Sodium hypochlorite',1,'Y',1.100,user,sysdate); 
insert into OAM_Materials_Consumables values (10,'Micron Cartridge Filter 5x40", 2.5" diameter',1,'Y',1.989,user,sysdate); 
insert into OAM_Materials_Consumables values (11,'Wood supports (for trees, concrete pouring, etc.)',1,'Y',485,user,sysdate);
insert into OAM_Materials_Consumables values (12,'Pesticides and materials for insect and rodent control',1,'Y',5.822,user,sysdate); 
insert into OAM_Materials_Consumables values (13,'Cleaning sponge',1,'Y',485,user,sysdate); 
insert into OAM_Materials_Consumables values (14,'Wipes for various uses',1,'Y',1.211,user,sysdate); 
insert into OAM_Materials_Consumables values (15,'Gloves for various uses (leather, rubber, cotton)',1,'Y',534 ,user,sysdate);
insert into OAM_Materials_Consumables values (16,'Dust protection masks',1,'Y',243,user,sysdate); 
insert into OAM_Materials_Consumables values (17,'Toilet Cleaning Brush',1,'Y',233,user,sysdate); 
insert into OAM_Materials_Consumables values (18,'Water mops',1,'Y',349,user,sysdate); 
insert into OAM_Materials_Consumables values (19,'Plastic bags of various sizes and uses',1,'Y',1.009,user,sysdate); 
insert into OAM_Materials_Consumables values (20,'Wood and fiberglass polish and cleaner',1,'Y',2.523,user,sysdate); 
insert into OAM_Materials_Consumables values (21,'Glass cleaner and polish',1,'Y',2.102,user,sysdate); 
insert into OAM_Materials_Consumables values (22,'Stainless steel cleaner and polish',1,'Y',3.153,user,sysdate); 
insert into OAM_Materials_Consumables values (23,'Marble, granite and rock cleaner and polish and stain remover',1,'Y',2.911,user,sysdate); 
insert into OAM_Materials_Consumables values (24,'Ceramic cleaner, polish, disinfectants and fresheners and its uses (eg. toilets and kitchens)',1,'Y',2.913,user,sysdate); 
insert into OAM_Materials_Consumables values (25,'Paper towels and hand dryer for toilet and offices',1,'Y',2.910,user,sysdate); 
insert into OAM_Materials_Consumables values (26,'Different sizes of garbage bags',1,'Y',2.966,user,sysdate); 

commit;


  *\
  
