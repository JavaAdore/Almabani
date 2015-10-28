/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.almabani.common.entity.schema.adminwkf.view;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Subselect;

import com.almabani.common.entity.AbstractEntity;

/**
 *
 * @author orcl
 */
@Entity
@Subselect("SELECT * FROM ADMINWKF.V_WOK_OCCURRENCES_DEMAND")
public class WokOccurrencesDemandView extends AbstractEntity implements Serializable {
    
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @Column(name = "NUM_OCCURRENCE")
    private Long ccurrenceNumber;
    
    @Column(name = "NUM_DEMAND")
    private Long demandNumber;
    
    @Column(name = "NUM_TYPE_ACTION")
    private Long actionTypeNumber;
    
    @Column(name = "DES_TYPE_ACTION")
    private String actionTypeDescription;
    
    @Column(name = "DES_WORKING_GROUP")
    private String workingGroupDescription;
    
    @Column(name = "NUM_USER_GROUP_ACTION")
    private Long userGroupActionNumber;
    
    @Column(name = "COD_USER_LOGIN_ACTION")
    private String loginUserCodeAction;
    
    @Column(name = "NAM_EMPLOYEE_ACTION")
    private String employeeActionName;
    
    @Column(name = "NUM_USER_GROUP")
    private Long userGroupNumber;
    
    @Column(name = "COD_USER_LOGIN")
    private String loginUserCode;
    
    @Column(name = "NAM_EMPLOYEE")
    private String employeeName;
    
    @Column(name = "DAT_OCCURRENCE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date occurrenceDate;
    
    @Column(name = "DAT_NEXT_ACTION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date nextActionDate;
    
    @Column(name = "DAT_UPDATE_ACTION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateActionDate;
    
    @Column(name = "NAM_USER_MODIFY")
    private String nameOfModifiedUser;
    
    @Column(name = "DAT_LAST_MODIFY")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModificationsDate;
    
    @Column(name = "DES_USER_OBSERVATION")
    private String userObservationDescription;
    
    @Column(name = "DAT_ESTIMATED_BEGIN")
    @Temporal(TemporalType.TIMESTAMP)
    private Date BeginEstimatedDate;
    
    @Column(name = "DAT_ESTIMATED_END")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endEstimatedDate;

	@Override
	public Long getId() {
		return ccurrenceNumber;
	}

	@Override
	public void setId(Long i) {
		ccurrenceNumber = i;		
	}

   
}
