--drop table OAM_EQUIPMENTS;

  CREATE TABLE OAM_EQUIPMENTS 
   (	NUM_EQUIPMENT             NUMBER(3)   not null, 
      DES_EQUIPMENT             VARCHAR2(600) not null,
      QUT_REFERENCE             NUMBER(2)   not null, 
      val_EQUIPMENT             number(15,2) not null,
      --
      NUM_project               NUMBER(3) not null,
      IND_ACTIVE                VARCHAR2(1) not null, 
      NAM_USER_MODIFY           VARCHAR2(10) not null,
      DAT_LAST_MODIFY           DATE not null
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
  
  
  alter table OAM_EQUIPMENTS
  add constraint OAM_EQU_PK primary key (NUM_EQUIPMENT)
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

  alter table OAM_EQUIPMENTS add   check (IND_ACTIVE IN ('Y', 'N'));
  
alter table OAM_EQUIPMENTS
  add constraint OAM_EQU_proj_FK foreign key (NUM_project)
  references COM_projects (NUM_project);


create index OAM_EQU_proj_FK_I on OAM_EQUIPMENTS (NUM_project)
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
--drop public synonym OAM_EQUIPMENTS;
--create public synonym OAM_EQUIPMENTS for OAM_EQUIPMENTS;
--grant select, insert, update, delete on OAM_EQUIPMENTS TO ROLE_oem_FULL;
--grant select on OAM_EQUIPMENTS to ROLE_oem_CONS;  

\*
--
delete from OAM_EQUIPMENTS;
--
insert into OAM_EQUIPMENTS values (1,'Pesticides Spraying Unit 1,000 Liters',1,1085 ,1,'Y',user,sysdate);
insert into OAM_EQUIPMENTS values (2,'Portable Pesticides Spraying',	 3 	, 181 ,1,'Y',user,sysdate); 
insert into OAM_EQUIPMENTS values (3	,'Air Pressure Unit 200 Liters, 220V with spray gun and peripherals',	 1 ,	 232 ,1,'Y',user,sysdate); 
insert into OAM_EQUIPMENTS values (4	,'Cutting Machine with Oxygen and its attachments',	 1 ,	 213 ,1,'Y',user,sysdate); 
insert into OAM_EQUIPMENTS values (5	,'Water leakage detection unit (Fuji HGA 10)',	 1 ,	 1317 ,1,'Y',user,sysdate); 
insert into OAM_EQUIPMENTS values (6	,'Pressure Air Device, Petrol, capacity 26KW, Model STHL 420',	 2 ,	 388 ,1,'Y',user,sysdate); 
insert into OAM_EQUIPMENTS values (7	,'Forklift, 25 Ton, Toyota',	 1 ,	 4017 ,1,'Y',user,sysdate); 
insert into OAM_EQUIPMENTS values (8	,'Vibratory Roller (compactor)', 	 2 	, 1247 ,1,'Y',user,sysdate); 
insert into OAM_EQUIPMENTS values (9	,'70cm Roller',	 2 	, 2171 ,1,'Y',user,sysdate); 
insert into OAM_EQUIPMENTS values (10	,'Light transport vehicles (DYNA) Long Chassis',	 1 ,	 2822 ,1,'Y',user,sysdate); 
insert into OAM_EQUIPMENTS values (11	,'Light transport vehicles (DYNA) - dumper',	 2, 	 4373 ,1,'Y',user,sysdate); 
insert into OAM_EQUIPMENTS values (12	,'Light transport vehicles (DYNA) - double cabin',	 4 ,	 2502 ,1,'Y',user,sysdate); 
insert into OAM_EQUIPMENTS values (13	,'Light transport vehicle - Van',	 1 	, 2843,1,'Y',user,sysdate); 
insert into OAM_EQUIPMENTS values (14	,'Crane to change electrical posts',	 1 ,	 1870 ,1,'Y',user,sysdate);
insert into OAM_EQUIPMENTS values (15	,'Crane with cabin to change light bulbs, 13m high',	 1 ,	 5428 ,1,'Y',user,sysdate);
insert into OAM_EQUIPMENTS values (16	,'Small shovel (Bob Cat) MODEL 753,743',	 1 	, 3148 ,1,'Y',user,sysdate);
insert into OAM_EQUIPMENTS values (17	,'DYNA + Small water tank',	 2 	, 5273 ,1,'Y',user,sysdate);
insert into OAM_EQUIPMENTS values (18	,'Mobile air compressor with 2 nozzles ATLAS COPCO XA 85',	 1 ,	 1329,1,'Y',user,sysdate); 
insert into OAM_EQUIPMENTS values (19	,'Garbage disposal, 2x1x1m with cover', 	 5 ,	 215 ,1,'Y',user,sysdate);
insert into OAM_EQUIPMENTS values (20	,'Vehicle to transport material',	 7 	, 215 ,1,'Y',user,sysdate);
insert into OAM_EQUIPMENTS values (21	,'Forklift with chain, 2 Ton CHAINLINK',	 3 ,	 108 ,1,'Y',user,sysdate);
insert into OAM_EQUIPMENTS values (22	,'Pressurized water cleaning machine, hot and cold 200 bar',	 5 ,	 651 ,1,'Y',user,sysdate);
insert into OAM_EQUIPMENTS values (23	,'[Abrasive machine + manual one] Grinder',	 2 	, 107 ,1,'Y',user,sysdate);
insert into OAM_EQUIPMENTS values (24	,'Submersible machine for washing tanks and sinks',	 1, 	 1292 ,1,'Y',user,sysdate);
insert into OAM_EQUIPMENTS values (25	,'Rotary weed eater machine',	 1 ,	 354 ,1,'Y',user,sysdate);
insert into OAM_EQUIPMENTS values (26	,'Artificial Lawn comber and mower',	 2 ,	 1310 ,1,'Y',user,sysdate);
insert into OAM_EQUIPMENTS values (27	,'Electrical metal welding machine, 70Amps',	 1 ,	 86 ,1,'Y',user,sysdate);
insert into OAM_EQUIPMENTS values (28	,'Oxygen welding machine with set of welding tools',	 2 ,	 302 ,1,'Y',user,sysdate);
insert into OAM_EQUIPMENTS values (29	,'Metal welding machine,300Amps, diesel operated',	 1 ,	 1572 ,1,'Y',user,sysdate);
insert into OAM_EQUIPMENTS values (30	,'Electrical drill with set of brushes',	 2 ,	 191,1,'Y',user,sysdate); 
insert into OAM_EQUIPMENTS values (31	,'Electric hammer drill (HEALTY) with accessories',	 3 	, 299 ,1,'Y',user,sysdate);
insert into OAM_EQUIPMENTS values (32	,'Set of irrigation \  plumbing tools',	 6 	, 323 ,1,'Y',user,sysdate);
insert into OAM_EQUIPMENTS values (33	,'Set of carpentry tools including electric saw, etc',	 3 ,	 242 ,1,'Y',user,sysdate);
insert into OAM_EQUIPMENTS values (34	,'Set of 4 ladders various sizes 2,3,4,6 meters',	 7 ,	 129 ,1,'Y',user,sysdate);
insert into OAM_EQUIPMENTS values (35	,'Scaffolding 6m high',	 3 	, 646 ,1,'Y',user,sysdate);
insert into OAM_EQUIPMENTS values (36	,'Complete set of tools for metal works containing keys, hammers, wires, tensile keys of various sizes for tightening the nuts of pedestrian bridges and tightening level reader',	 2 	, 431 ,1,'Y',user,sysdate);
insert into OAM_EQUIPMENTS values (37	,'Complete set of tools for electric works containing not less than: digital device for measuring the Voltage, clamp meter, electric insulation measurement device, battery inspection device, manual charger, a set of spanners, a set of opening and closing keys (in mm and inches),set of switches, set of ordinary screwdrivers and high load square, electric knifes, set of saws, set of hammers, Allen Keys, rechargeable electric torch, silicon pistol and other items not mentioned and required for performance of works',	 6 	, 756 ,1,'Y',user,sysdate);
insert into OAM_EQUIPMENTS values (38	,'Complete set of mechanical and plumbing tools containing no less than: binding pipes with wheels and pipe cutters, set of spanners 12-16 inches, set of "pipe openers" 14-36 inches, set of opening and closing keys with mm and inches, set of normal screwdrivers and heavy duty square, set of saws, set of hammers, set of filing kit, Allen Key, water level scale, flexible metal wire for blocked drain pipes, rechargeable electric torch, silicon pistol and other items not mentioned and required for the performance of work',	 4 	, 431 ,1,'Y',user,sysdate);
insert into OAM_EQUIPMENTS values (39	,'Set of manual tools for civil and construction works (painter, carpenter, tiles mason, plastering mason)',	 6 	, 172 ,1,'Y',user,sysdate);
insert into OAM_EQUIPMENTS values (40	,'Set of cutters and various agricultural tools(shovels, graders, cultivators, various scissors, etc) Type GARDENIA or equivalent',	 6 	, 172 ,1,'Y',user,sysdate);
insert into OAM_EQUIPMENTS values (41	,'Backhoe and loader Model CAT 446',	 1 	, 3552 ,1,'Y',user,sysdate);
insert into OAM_EQUIPMENTS values (42	,'Submersible pumps (water and drainage), 1 and 5 horsepower',	 2 ,	 323 ,1,'Y',user,sysdate);
insert into OAM_EQUIPMENTS values (43	,'Hydraulic and manual lubricating pump',	 1 	 ,249 ,1,'Y',user,sysdate);
insert into OAM_EQUIPMENTS values (44	,'Vertical Chainsaw for hedges',	 2 	, 414 ,1,'Y',user,sysdate);
insert into OAM_EQUIPMENTS values (45 ,'Petrol and electric tree-saws, different sizes', 	 2 ,	381,1,'Y',user,sysdate);
insert into OAM_EQUIPMENTS values (46 ,'Saws for Palm trees', 	 4 ,	78,1,'Y',user,sysdate);
insert into OAM_EQUIPMENTS values (47 ,'Saw to cut tiles and rocks with electric table, 220V, 3HP, 30mm Italian or American', 	 1 	,323,1,'Y',user,sysdate);
insert into OAM_EQUIPMENTS values (48 ,'Asphalt cutting blade, 75HP', 	 1 ,	879,1,'Y',user,sysdate);
insert into OAM_EQUIPMENTS values (49 ,'Electric Air compressor, 600W', 	 4 ,	71,1,'Y',user,sysdate);
insert into OAM_EQUIPMENTS values (50 ,'Electric generator 2500W and 4000W', 	 2 ,	755,1,'Y',user,sysdate);
insert into OAM_EQUIPMENTS values (51	,'SUV furnished with safety features 4x4 (towing)',	 1 	, 3148 ,1,'Y',user,sysdate);
insert into OAM_EQUIPMENTS values (52	,'Suction Pump on trailer, 8 inches At least 25m long',	 1 ,	 3188 ,1,'Y',user,sysdate);
insert into OAM_EQUIPMENTS values (53	,'Salinity measuring device',	 2 	 ,302 ,1,'Y',user,sysdate);
insert into OAM_EQUIPMENTS values (54	,'PH measuring device',	 2 	, 302 ,1,'Y',user,sysdate);
insert into OAM_EQUIPMENTS values (55	,'Various Electronics',	 2 	, 142 ,1,'Y',user,sysdate);
insert into OAM_EQUIPMENTS values (56	,'Light intensity measuring device',	 2 	, 194 ,1,'Y',user,sysdate);
insert into OAM_EQUIPMENTS values (57	,'Earthing measuring device',	 2 ,	 614 ,1,'Y',user,sysdate);
insert into OAM_EQUIPMENTS values (58	,'Thermal camera to measure temperature of conductors',	 1, 	 603 ,1,'Y',user,sysdate);
insert into OAM_EQUIPMENTS values (59	,'Oscilloscope',	 1 ,	 431 ,1,'Y',user,sysdate);
insert into OAM_EQUIPMENTS values (60	,'Hydraulic basket on truck 25 m high',	 1 	, 4207 ,1,'Y',user,sysdate);
insert into OAM_EQUIPMENTS values (61	,'Sweeper for external passages and narrow areas (tenant walk behind sweeper, model 140)',	 1 ,	 4183 ,1,'Y',user,sysdate);
insert into OAM_EQUIPMENTS values (62	,'Sweeper for narrow passages, width 135-150cm, type tenant A60 or ECO101 or its equivalent, containing rear sweeper and side sweeper with arm',	 1, 	 3634 ,1,'Y',user,sysdate);
insert into OAM_EQUIPMENTS values (63	,'Janitorial trolley with complete bucket wringer, model SC-6, servo clean',	 5 ,	 86 ,1,'Y',user,sysdate);
insert into OAM_EQUIPMENTS values (64	,'Electric sweeper, AP SAC VACUUM CLEANER, TYPE CLARK - 02133 A',	 1 	, 603 ,1,'Y',user,sysdate);
insert into OAM_EQUIPMENTS values (65	,'Mop trolley with wringer ELMARK',	 6 	 ,142 ,1,'Y',user,sysdate);
insert into OAM_EQUIPMENTS values (66	,'Window Cleaning Kit, Unger, Solingen',	 2 	, 233 ,1,'Y',user,sysdate);
insert into OAM_EQUIPMENTS values (67	,'A" TYPE LADDER 8FT\10FT\12FT- RIGID',	 6 ,	 108 ,1,'Y',user,sysdate);
insert into OAM_EQUIPMENTS values (68	,'machine to unclog manholes',	 1 	, 931 ,1,'Y',user,sysdate);
insert into OAM_EQUIPMENTS values (69	,'Safety Tools for Emergency works',	 2 	, 646 ,1,'Y',user,sysdate);
insert into OAM_EQUIPMENTS values (70	,'Grinder 230V (7inch)',	 2 	, 164 ,1,'Y',user,sysdate);
insert into OAM_EQUIPMENTS values (71	,'Tools for Electronic Works',	 4 ,	 258 ,1,'Y',user,sysdate);
insert into OAM_EQUIPMENTS values (72	,'Vaccuum,Tennant-atlv4300 or equivalent',	 1 	 ,7049 ,1,'Y',user,sysdate);
insert into OAM_EQUIPMENTS values (73	,'Dust and waste sweeping machine, BP 6900 or equivalent',	 1 ,	 1828 ,1,'Y',user,sysdate);
insert into OAM_EQUIPMENTS values (74	,'Road Sweeper',	 1 	, 9806 ,1,'Y',user,sysdate);


commit;


  
  
*\