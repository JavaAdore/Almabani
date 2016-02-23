DROP VIEW V_COM_EMPLOYEES;

CREATE VIEW V_COM_EMPLOYEES AS SELECT 
    T5.NUM_company
    ,T6.NAM_company
    ,T4.NUM_department
    ,T5.NAM_department
    --
    ,T1.NUM_DEP_SECTION          
    ,T4.NAM_SECTION
    ,T1.NUM_ESTABLISHMENT         
    ,t3.NAM_ESTABLISHMENT
    ,T1.COD_EMPLOYEE            
	  ,T1.COD_IDENTITY_FEDERAL      
    ,T1.NAM_EMPLOYEE              
    ,decode(T1.IND_ACTIVE,'Y','Sim','N','Não') des_IND_ACTIVE   
    ,T1.NUM_TYPE_job_title        
    ,t2.DES_TYPE_JOB_TITLE
  	,T1.DES_OBSERVATION          
    ,T1.DAT_REGISTRATION         
    ,T1.COD_IDENTITY_STATE      
    ,T1.DAT_BIRTH                
    ,decode(T1.IND_GENDER,'M','Masculino','F','Feminino') des_GENDER   
    ,decode(T1.IND_MARITAL_STATUS,'M','Casado','S','Separado','D','Divorciado','W','Viuvo','I','Solteiro','O','Outros') des_MARITAL_STATUS
    ,T1.DAT_ADMISSION           
    ,T1.DAT_BEGIN_INACTIVITY     
    ,decode(T1.ind_type_employee,'C','CLT','P','PJ','T','Trainee','E','Estagiário',NULL,'Outros') des_ind_type_employee           
    ,T1.des_Email_1               
    ,T1.des_Email_2                 
    ,T1.num_ddI_telefone            
    ,T1.num_ddd_telefone           
    ,T1.num_telefone             
    ,T1.num_ddI_mobile            
    ,T1.num_ddd_mobile             
    ,T1.num_mobile                
    ,T1.nam_USER_MODIFY          
    ,T1.DAT_LAST_MODIFY            
FROM
     COM_EMPLOYEES   T1
    ,COM_TYPES_JOB_TITLE T2
    ,COM_ESTABLISHMENTS  t3
    ,COM_DEP_SECTIONS   t4
    ,COM_DEPartments   t5
    ,COM_companies   t6
where 
        t1.NUM_TYPE_job_title     = t2.NUM_TYPE_job_title(+)
    and t1.NUM_ESTABLISHMENT      =  t3.NUM_ESTABLISHMENT
    and t1.NUM_DEP_SECTION        =  t4.NUM_DEP_SECTION 
    and t4.NUM_DEPartment        =  t5.NUM_DEPartment 
    and t5.NUM_company        =  t6.NUM_company;

-- Grant/Revoke object privileges 
DROP public synonym V_COM_EMPLOYEES;
create public synonym V_COM_EMPLOYEES for V_COM_EMPLOYEES;
grant select on V_COM_EMPLOYEES TO ROLE_beyond_FULL;
 