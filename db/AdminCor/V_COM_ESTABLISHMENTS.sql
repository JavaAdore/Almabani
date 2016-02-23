DROP VIEW v_COM_ESTABLISHMENTS;
--
CREATE VIEW v_COM_ESTABLISHMENTS AS SELECT 
t1.NUM_ESTABLISHMENT      
,t1.NUM_DOCUMENT           
,t1.NUM_DIGIT_ESTABLISHMENT         
,t1.NUM_COMPANY             
,t2.nam_company
,decode(T1.IND_TYPE_ESTABLISHMENT,'C','Comercial','I','Ecommerce','M','Outros') des_TYPE_ESTABLISHMENT  
,t1.NAM_ESTABLISHMENT
,decode(T1.IND_ACTIVE,'Y','Sim','N','Não') des_IND_ACTIVE   
,t1.DAT_LAST_MODIFY         
,t1.NAM_USER_MODIFY        
,t1.NUM_ZIP_CODE           
,t1.NUM_SEQ_ZIP_CODE     
,t3.DES_ZIP_CODE
,t3.COD_STATE 
FROM
     COM_ESTABLISHMENTS  t1
    ,com_companies   t2
    ,com_zip_code t3
where 
        t1.NUM_COMPANY = t2.NUM_COMPANY
    and t1.NUM_ZIP_CODE      =  t3.NUM_ZIP_CODE   
    and t1.NUM_SEQ_ZIP_CODE   =  t3.NUM_SEQ_ZIP_CODE;

-- Grant/Revoke object privileges 
DROP public synonym v_COM_ESTABLISHMENTS;
create public synonym v_COM_ESTABLISHMENTS for v_COM_ESTABLISHMENTS;
grant select on v_COM_ESTABLISHMENTS TO ROLE_beyond_FULL;

    
 