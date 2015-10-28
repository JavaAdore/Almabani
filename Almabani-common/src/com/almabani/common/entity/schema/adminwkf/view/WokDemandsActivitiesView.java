package com.almabani.common.entity.schema.adminwkf.view;
///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//
//package com.almabani.common.entity.schema.adminwkf.view;
//
//import java.io.Serializable;
//import java.math.BigDecimal;
//import java.util.Date;
//
//import javax.persistence.Basic;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.NamedQueries;
//import javax.persistence.NamedQuery;
//import javax.persistence.Table;
//import javax.persistence.Temporal;
//import javax.persistence.TemporalType;
//
//import org.hibernate.annotations.Subselect;
//
///**
// *
// * @author orcl
// */
//@Entity
//@Subselect("SELECT v FROM ADMINWKF.VWokDemandsActivities v")
//public class VWokDemandsActivities implements Serializable {
//    private static final Long serialVersionUID = 1L;
//    
//    @Column(name = "NUM_DEMAND")
//    private Long numDemand;
//    
//    @Column(name = "NUM_ACTIVITY")
//    private Long numActivity;
//    
//    @Column(name = "NUM_USER_GROUP_ACTIVITY")
//    private Long numUserGroupActivity;
//    
//    @Column(name = "COD_USER_LOGIN_ACTIVITY")
//    private String codUserLoginActivity;
//    
//    @Column(name = "NAM_EMPLOYEE_ACTIVITY")
//    private String namEmployeeActivity;
//    
//    @Column(name = "DAT_INSERT_ACTIVITY")
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date datInsertActivity;
//    @Column(name = "DAT_UPDATE_ACTIVITY")
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date datUpdateActivity;
//    
//    @Column(name = "NAM_USER_MODIFY")
//    private String namUserModify;
//    
//    @Column(name = "DAT_LAST_MODIFY")
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date datLastModify;
//    
//    @Column(name = "DES_ACTIVITY")
//    private String desActivity;
//    @Column(name = "DAT_ESTIMATED_BEGIN")
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date datEstimatedBegin;
//    @Column(name = "DAT_ESTIMATED_END")
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date datEstimatedEnd;
//    @Column(name = "DAT_REAL_BEGIN")
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date datRealBegin;
//    @Column(name = "DAT_REAL_END")
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date datRealEnd;
//    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
//    @Column(name = "PER_REALIZED")
//    private BigDecimal perRealized;
//    @Column(name = "DES_ATT_POINTS")
//    private String desAttPoints;
//
//    public VWokDemandsActivities() {
//    }
//
//    public Long getNumDemand() {
//        return numDemand;
//    }
//
//    public void setNumDemand(Long numDemand) {
//        this.numDemand = numDemand;
//    }
//
//    public Long getNumActivity() {
//        return numActivity;
//    }
//
//    public void setNumActivity(Long numActivity) {
//        this.numActivity = numActivity;
//    }
//
//    public Long getNumUserGroupActivity() {
//        return numUserGroupActivity;
//    }
//
//    public void setNumUserGroupActivity(Long numUserGroupActivity) {
//        this.numUserGroupActivity = numUserGroupActivity;
//    }
//
//    public String getCodUserLoginActivity() {
//        return codUserLoginActivity;
//    }
//
//    public void setCodUserLoginActivity(String codUserLoginActivity) {
//        this.codUserLoginActivity = codUserLoginActivity;
//    }
//
//    public String getNamEmployeeActivity() {
//        return namEmployeeActivity;
//    }
//
//    public void setNamEmployeeActivity(String namEmployeeActivity) {
//        this.namEmployeeActivity = namEmployeeActivity;
//    }
//
//    public Date getDatInsertActivity() {
//        return datInsertActivity;
//    }
//
//    public void setDatInsertActivity(Date datInsertActivity) {
//        this.datInsertActivity = datInsertActivity;
//    }
//
//    public Date getDatUpdateActivity() {
//        return datUpdateActivity;
//    }
//
//    public void setDatUpdateActivity(Date datUpdateActivity) {
//        this.datUpdateActivity = datUpdateActivity;
//    }
//
//    public String getNamUserModify() {
//        return namUserModify;
//    }
//
//    public void setNamUserModify(String namUserModify) {
//        this.namUserModify = namUserModify;
//    }
//
//    public Date getDatLastModify() {
//        return datLastModify;
//    }
//
//    public void setDatLastModify(Date datLastModify) {
//        this.datLastModify = datLastModify;
//    }
//
//    public String getDesActivity() {
//        return desActivity;
//    }
//
//    public void setDesActivity(String desActivity) {
//        this.desActivity = desActivity;
//    }
//
//    public Date getDatEstimatedBegin() {
//        return datEstimatedBegin;
//    }
//
//    public void setDatEstimatedBegin(Date datEstimatedBegin) {
//        this.datEstimatedBegin = datEstimatedBegin;
//    }
//
//    public Date getDatEstimatedEnd() {
//        return datEstimatedEnd;
//    }
//
//    public void setDatEstimatedEnd(Date datEstimatedEnd) {
//        this.datEstimatedEnd = datEstimatedEnd;
//    }
//
//    public Date getDatRealBegin() {
//        return datRealBegin;
//    }
//
//    public void setDatRealBegin(Date datRealBegin) {
//        this.datRealBegin = datRealBegin;
//    }
//
//    public Date getDatRealEnd() {
//        return datRealEnd;
//    }
//
//    public void setDatRealEnd(Date datRealEnd) {
//        this.datRealEnd = datRealEnd;
//    }
//
//    public BigDecimal getPerRealized() {
//        return perRealized;
//    }
//
//    public void setPerRealized(BigDecimal perRealized) {
//        this.perRealized = perRealized;
//    }
//
//    public String getDesAttPoints() {
//        return desAttPoints;
//    }
//
//    public void setDesAttPoints(String desAttPoints) {
//        this.desAttPoints = desAttPoints;
//    }
//    
//}
