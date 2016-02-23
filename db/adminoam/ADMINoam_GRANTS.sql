
-- 04sep2015
-- added new sequence
grant select on   OAM_SEQ_NUM_STOCK_ITEM to USERONLINE;

-- added new TABLE
grant select, INSERT, update, delete on  OAM_QUOTATION_ACTIONS to USERONLINE;



--select 'grant select, INSERT, update, delete on  '||table_name||' to USERONLINE;' from user_tables;



grant select, INSERT, update, delete on  OAM_PROJECT_JOB_TITLES to USERONLINE;
grant select, INSERT, update, delete on  OAM_TYPES_QUOT_ACTIONS to USERONLINE;
grant select, INSERT, update, delete on  OAM_NEXT_QUOT_ACTIONS to USERONLINE;
grant select, INSERT, update, delete on  OAM_TYPES_ALLOCATIONS to USERONLINE;
grant select, INSERT, update, delete on  OAM_PROJECT_EMPLOYEES to USERONLINE;
grant select, INSERT, update, delete on  OAM_QUOTATIONS to USERONLINE;
grant select, INSERT, update, delete on  OAM_EMP_MONTHLY_ALLOCATION to USERONLINE;
grant select, INSERT, update, delete on  OAM_EMP_DAILY_ALLOCATION to USERONLINE;
grant select, INSERT, update, delete on  OAM_TYPES_MATERIAL to USERONLINE;
grant select, INSERT, update, delete on  OAM_ITEMS_CATEGORY to USERONLINE;
grant select, INSERT, update, delete on  OAM_MANUFACTURERS to USERONLINE;
grant select, INSERT, update, delete on  OAM_ITEMS to USERONLINE;
grant select, INSERT, update, delete on  OAM_PROJECT_ITEMS to USERONLINE;
grant select, INSERT, update, delete on  OAM_STOCK_ITEMS to USERONLINE;
grant select, INSERT, update, delete on  OAM_SUPPLIERS to USERONLINE;
grant select, INSERT, update, delete on  OAM_ITEM_QUOTATIONS to USERONLINE;
grant select, INSERT, update, delete on  OAM_ITEMS_QUOT_SUPPLIERS to USERONLINE;
grant select, INSERT, update, delete on  OAM_SITES to USERONLINE;
grant select, INSERT, update, delete on  OAM_SITE_DIRECTIONS to USERONLINE;
grant select, INSERT, update, delete on  OAM_ZONES to USERONLINE;
grant select, INSERT, update, delete on  OAM_SITE_LOCATIONS to USERONLINE;
grant select, INSERT, update, delete on  OAM_TYPES_DEVICE to USERONLINE;
grant select, INSERT, update, delete on  OAM_PROJECT_DEVICES to USERONLINE;
grant select, INSERT, update, delete on  OAM_REPORTING_ZONES to USERONLINE;
grant select, INSERT, update, delete on  OAM_ZONE_DEVICES to USERONLINE;
grant select, INSERT, update, delete on  OAM_DEVICE_LOCATION to USERONLINE;
grant select, INSERT, update, delete on  OAM_PROJECT_INVOICES to USERONLINE;
grant select, INSERT, update, delete on  OAM_PROJ_EMPLOYEES_INVOICES to USERONLINE;
grant select, INSERT, update, delete on  OAM_EQUIPMENTS to USERONLINE;
grant select, INSERT, update, delete on  OAM_MATERIALS_CONSUMABLES to USERONLINE;
grant select, INSERT, update, delete on  OAM_PROJ_MAT_CONS_INVOICES to USERONLINE;
grant select, INSERT, update, delete on  OAM_PROJ_SPARE_PARTS_INVOICES to USERONLINE;
grant select, INSERT, update, delete on  OAM_PROJ_EQUIPMENTS_INVOICES to USERONLINE;


--select 'grant select on   '||sequence_name||' to USERONLINE;' from user_sequences;

--grant select on   OAM_PROJECT_EMP_ID_SEQ_GEN to USERONLINE;
grant select on   OAM_SEQ_NUM_EMP_DAY_ALLOCATION to USERONLINE;
grant select on   OAM_SEQ_NUM_EMP_MON_ALLOCATION to USERONLINE;
grant select on   OAM_SEQ_NUM_EQUIPMENT to USERONLINE;
grant select on   OAM_SEQ_NUM_ITEM to USERONLINE;
grant select on   OAM_SEQ_NUM_ITEM_CATEGORY to USERONLINE;
grant select on   OAM_SEQ_NUM_ITEM_QUOTATION to USERONLINE;
grant select on   OAM_SEQ_NUM_ITEM_QUOT_SUPPLIER to USERONLINE;
grant select on   OAM_SEQ_NUM_MANUFACTURER to USERONLINE;
grant select on   OAM_SEQ_NUM_MAT_CONSUMABLE to USERONLINE;
grant select on   OAM_SEQ_NUM_PROJECT_EMPLOYEE to USERONLINE;
grant select on   OAM_SEQ_NUM_PROJECT_INVOICE to USERONLINE;
grant select on   OAM_SEQ_NUM_PROJECT_ITEM to USERONLINE;
grant select on   OAM_SEQ_NUM_PROJECT_JOB_TITLE to USERONLINE;
grant select on   OAM_SEQ_NUM_PROJ_EMP_INVOICE to USERONLINE;
grant select on   OAM_SEQ_NUM_PROJ_EQUIP_INVOICE to USERONLINE;
grant select on   OAM_SEQ_NUM_PROJ_MAT_CONS_INV to USERONLINE;
grant select on   OAM_SEQ_NUM_PROJ_SPA_PAR_INV to USERONLINE;
grant select on   OAM_SEQ_NUM_QUOTATION to USERONLINE;
grant select on   OAM_SEQ_NUM_QUOTATION_ACTION to USERONLINE;
grant select on   OAM_SEQ_NUM_REPORT_ZONE to USERONLINE;
grant select on   OAM_SEQ_NUM_SITE to USERONLINE;
grant select on   OAM_SEQ_NUM_SITE_DIRECTION to USERONLINE;
grant select on   OAM_SEQ_NUM_SITE_LOCATION to USERONLINE;
grant select on   OAM_SEQ_NUM_SUPPLIER to USERONLINE;
grant select on   OAM_SEQ_NUM_TYPE_ALLOCATION to USERONLINE;
grant select on   OAM_SEQ_NUM_TYPE_DEVICE to USERONLINE;
grant select on   OAM_SEQ_NUM_TYPE_MATERIAL to USERONLINE;
grant select on   OAM_SEQ_NUM_TYPE_QUOT_ACTION to USERONLINE;
grant select on   OAM_SEQ_NUM_ZONE to USERONLINE;
grant select on   OAM_SEQ_NUM_ZONE_DEVICE to USERONLINE;


grant references on OAM_SITES to adminWKF; 
grant select, insert, update, delete on OAM_SITES TO adminWKF  WITH GRANT OPTION;

grant references on OAM_SITE_directions to adminWKF; 
grant select, insert, update, delete on OAM_SITE_directions TO adminWKF  WITH GRANT OPTION;

grant references on OAM_ZONES to adminWKF; 
grant select, insert, update, delete on OAM_ZONES TO adminWKF  WITH GRANT OPTION;

grant references on OAM_PROJECT_DEVICES to adminWKF; 
grant select, insert, update, delete on OAM_PROJECT_DEVICES TO adminWKF  WITH GRANT OPTION;

grant references on OAM_ZONE_DEVICES to adminWKF; 
grant select, insert, update, delete on OAM_ZONE_DEVICES TO adminWKF  WITH GRANT OPTION;

grant references on OAM_DEVICE_LOCATION to adminWKF; 
grant select, insert, update, delete on OAM_DEVICE_LOCATION TO adminWKF  WITH GRANT OPTION;

