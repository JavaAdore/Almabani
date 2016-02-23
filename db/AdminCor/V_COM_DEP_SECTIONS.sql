DROP VIEW V_COM_DEP_SECTIONS;
--
CREATE VIEW V_COM_DEP_SECTIONS AS SELECT 
       T1.NUM_DEP_SECTION     
      ,T1.NUM_DEPARTMENT   
      ,T2.COD_DEPARTMENT
      ,t2.NAM_DEPARTMENT 
      ,t2.num_company
      ,t3.nam_company
      ,T1.COD_SECTION         
      ,T1.NAM_SECTION        
      ,decode(T1.IND_ACTIVE,'Y','Sim','N','Não') IND_ACTIVE  
      ,T1.COD_USER_RESPONSIBLE 
      ,t4.nam_employee  nam_employee_RESPONSIBLE
      ,T1.DAT_LAST_MODIFY     
      ,T1.NAM_USER_MODIFY    
FROM
     COM_DEP_SECTIONS T1
     ,COM_DEPARTMENTS  t2
    ,com_companies   t3
    ,COM_EMPLOYEES T4
where 
        t1.NUM_DEPARTMENT = t2.NUM_DEPARTMENT
        AND t2.NUM_COMPANY = t3.NUM_COMPANY  
        and t1.COD_USER_RESPONSIBLE   = t4.COD_employee(+);
    
-- Grant/Revoke object privileges 
DROP public synonym V_COM_DEP_SECTIONS;
create public synonym V_COM_DEP_SECTIONS for V_COM_DEP_SECTIONS;
grant select on V_COM_DEP_SECTIONS TO ROLE_beyond_FULL;

    
 