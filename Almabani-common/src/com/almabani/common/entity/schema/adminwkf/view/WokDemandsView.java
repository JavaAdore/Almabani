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
//
//import java.util.Date;
//
//import javax.persistence.Basic;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.Id;
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
//@Subselect("SELECT * FROM ADMINWKF.V_WOK_DEMANDS")
//public class VWokDemands implements Serializable {
//    private static final Long serialVersionUID = 1L;
//    @Id
//    
//    @Column(name = "NUM_DEMAND")
//    private Long numDemand;
//    
//    @Column(name = "DAT_DEMAND")
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date datDemand;
//    
//    @Column(name = "NUM_COMPANY")
//    private Long numCompany;
//    
//    @Column(name = "NUM_PROJECT")
//    private Long numProject;
//    
//    @Column(name = "COD_PROJECT")
//    private String codProject;
//    
//    @Column(name = "NUM_WORKING_GROUP")
//    private Long numWorkingGroup;
//    
//    @Column(name = "DES_WORKING_GROUP")
//    private String desWorkingGroup;
//    
//    @Column(name = "NUM_TYPE_DEMAND")
//    private Long numTypeDemand;
//    
//    @Column(name = "DES_TYPE_DEMAND")
//    private String desTypeDemand;
//    
//    @Column(name = "IND_CATEGORY")
//    private String indCategory;
//    
//    @Column(name = "DES_SUMMARY_DEMAND")
//    private String desSummaryDemand;
//    
//    @Column(name = "DES_DETAIL_DEMAND")
//    private String desDetailDemand;
//    
//    @Column(name = "NUM_CONFIGURATION_ITEM")
//    private Long numConfigurationItem;
//    @Column(name = "DES_CONFIGURATION_ITEM")
//    private String desConfigurationItem;
//    @Column(name = "NUM_TYPE_SYMPTOM")
//    private Short numTypeSymptom;
//    @Column(name = "DES_TYPE_SYMPTOM")
//    private String desTypeSymptom;
//    
//    @Column(name = "NUM_PRIORITY")
//    private Long numPriority;
//    
//    @Column(name = "DES_PRIORITY")
//    private String desPriority;
//    @Column(name = "NUM_TYPE_IMPACT")
//    private Short numTypeImpact;
//    @Column(name = "DES_TYPE_IMPACT")
//    private String desTypeImpact;
//    
//    @Column(name = "NUM_SITE_LOCATION")
//    private Long numSiteLocation;
//    
//    @Column(name = "COD_SITE_LOCATION")
//    private String codSiteLocation;
//    
//    @Column(name = "DES_SITE_LOCATION")
//    private String desSiteLocation;
//    @Column(name = "NUM_ZONE_DEVICE")
//    private Long numZoneDevice;
//    @Column(name = "COD_DEVICE")
//    private String codDevice;
//    @Column(name = "NUM_TYPE_ACTION_LAST")
//    private Long numTypeActionLast;
//    
//    @Column(name = "DES_SITUATION_DEMAND")
//    private String desSituationDemand;
//    
//    @Column(name = "NUM_USER_GROUP")
//    private Long numUserGroup;
//    
//    @Column(name = "NAM_EMPLOYEE_DEMAND")
//    private String namEmployeeDemand;
//    @Column(name = "NUM_USER_GROUP_RESP")
//    private Long numUserGroupResp;
//    
//    @Column(name = "NAM_EMPLOYEE")
//    private String namEmployee;
//    @Column(name = "DAT_ESTIMATED_CONCLUSION")
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date datEstimatedConclusion;
//    @Column(name = "DAT_REAL_CONCLUSION")
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date datRealConclusion;
//    
//    @Column(name = "DAT_VIOLATION_SLA")
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date datViolationSla;
//    
//    @Column(name = "NAM_USER_MODIFY")
//    private String namUserModify;
//    
//    @Column(name = "DAT_LAST_MODIFY")
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date datLastModify;
//    @Column(name = "NUM_MAXIMO")
//    private Long numMaximo;
//
//    public VWokDemands() {
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
//    public Date getDatDemand() {
//        return datDemand;
//    }
//
//    public void setDatDemand(Date datDemand) {
//        this.datDemand = datDemand;
//    }
//
//    public Long getNumCompany() {
//        return numCompany;
//    }
//
//    public void setNumCompany(Long numCompany) {
//        this.numCompany = numCompany;
//    }
//
//    public Long getNumProject() {
//        return numProject;
//    }
//
//    public void setNumProject(Long numProject) {
//        this.numProject = numProject;
//    }
//
//    public String getCodProject() {
//        return codProject;
//    }
//
//    public void setCodProject(String codProject) {
//        this.codProject = codProject;
//    }
//
//    public Long getNumWorkingGroup() {
//        return numWorkingGroup;
//    }
//
//    public void setNumWorkingGroup(Long numWorkingGroup) {
//        this.numWorkingGroup = numWorkingGroup;
//    }
//
//    public String getDesWorkingGroup() {
//        return desWorkingGroup;
//    }
//
//    public void setDesWorkingGroup(String desWorkingGroup) {
//        this.desWorkingGroup = desWorkingGroup;
//    }
//
//    public Long getNumTypeDemand() {
//        return numTypeDemand;
//    }
//
//    public void setNumTypeDemand(Long numTypeDemand) {
//        this.numTypeDemand = numTypeDemand;
//    }
//
//    public String getDesTypeDemand() {
//        return desTypeDemand;
//    }
//
//    public void setDesTypeDemand(String desTypeDemand) {
//        this.desTypeDemand = desTypeDemand;
//    }
//
//    public String getIndCategory() {
//        return indCategory;
//    }
//
//    public void setIndCategory(String indCategory) {
//        this.indCategory = indCategory;
//    }
//
//    public String getDesSummaryDemand() {
//        return desSummaryDemand;
//    }
//
//    public void setDesSummaryDemand(String desSummaryDemand) {
//        this.desSummaryDemand = desSummaryDemand;
//    }
//
//    public String getDesDetailDemand() {
//        return desDetailDemand;
//    }
//
//    public void setDesDetailDemand(String desDetailDemand) {
//        this.desDetailDemand = desDetailDemand;
//    }
//
//    public Long getNumConfigurationItem() {
//        return numConfigurationItem;
//    }
//
//    public void setNumConfigurationItem(Long numConfigurationItem) {
//        this.numConfigurationItem = numConfigurationItem;
//    }
//
//    public String getDesConfigurationItem() {
//        return desConfigurationItem;
//    }
//
//    public void setDesConfigurationItem(String desConfigurationItem) {
//        this.desConfigurationItem = desConfigurationItem;
//    }
//
//    public Short getNumTypeSymptom() {
//        return numTypeSymptom;
//    }
//
//    public void setNumTypeSymptom(Short numTypeSymptom) {
//        this.numTypeSymptom = numTypeSymptom;
//    }
//
//    public String getDesTypeSymptom() {
//        return desTypeSymptom;
//    }
//
//    public void setDesTypeSymptom(String desTypeSymptom) {
//        this.desTypeSymptom = desTypeSymptom;
//    }
//
//    public Long getNumPriority() {
//        return numPriority;
//    }
//
//    public void setNumPriority(Long numPriority) {
//        this.numPriority = numPriority;
//    }
//
//    public String getDesPriority() {
//        return desPriority;
//    }
//
//    public void setDesPriority(String desPriority) {
//        this.desPriority = desPriority;
//    }
//
//    public Short getNumTypeImpact() {
//        return numTypeImpact;
//    }
//
//    public void setNumTypeImpact(Short numTypeImpact) {
//        this.numTypeImpact = numTypeImpact;
//    }
//
//    public String getDesTypeImpact() {
//        return desTypeImpact;
//    }
//
//    public void setDesTypeImpact(String desTypeImpact) {
//        this.desTypeImpact = desTypeImpact;
//    }
//
//    public Long getNumSiteLocation() {
//        return numSiteLocation;
//    }
//
//    public void setNumSiteLocation(Long numSiteLocation) {
//        this.numSiteLocation = numSiteLocation;
//    }
//
//    public String getCodSiteLocation() {
//        return codSiteLocation;
//    }
//
//    public void setCodSiteLocation(String codSiteLocation) {
//        this.codSiteLocation = codSiteLocation;
//    }
//
//    public String getDesSiteLocation() {
//        return desSiteLocation;
//    }
//
//    public void setDesSiteLocation(String desSiteLocation) {
//        this.desSiteLocation = desSiteLocation;
//    }
//
//    public Long getNumZoneDevice() {
//        return numZoneDevice;
//    }
//
//    public void setNumZoneDevice(Long numZoneDevice) {
//        this.numZoneDevice = numZoneDevice;
//    }
//
//    public String getCodDevice() {
//        return codDevice;
//    }
//
//    public void setCodDevice(String codDevice) {
//        this.codDevice = codDevice;
//    }
//
//    public Long getNumTypeActionLast() {
//        return numTypeActionLast;
//    }
//
//    public void setNumTypeActionLast(Long numTypeActionLast) {
//        this.numTypeActionLast = numTypeActionLast;
//    }
//
//    public String getDesSituationDemand() {
//        return desSituationDemand;
//    }
//
//    public void setDesSituationDemand(String desSituationDemand) {
//        this.desSituationDemand = desSituationDemand;
//    }
//
//    public Long getNumUserGroup() {
//        return numUserGroup;
//    }
//
//    public void setNumUserGroup(Long numUserGroup) {
//        this.numUserGroup = numUserGroup;
//    }
//
//    public String getNamEmployeeDemand() {
//        return namEmployeeDemand;
//    }
//
//    public void setNamEmployeeDemand(String namEmployeeDemand) {
//        this.namEmployeeDemand = namEmployeeDemand;
//    }
//
//    public Long getNumUserGroupResp() {
//        return numUserGroupResp;
//    }
//
//    public void setNumUserGroupResp(Long numUserGroupResp) {
//        this.numUserGroupResp = numUserGroupResp;
//    }
//
//    public String getNamEmployee() {
//        return namEmployee;
//    }
//
//    public void setNamEmployee(String namEmployee) {
//        this.namEmployee = namEmployee;
//    }
//
//    public Date getDatEstimatedConclusion() {
//        return datEstimatedConclusion;
//    }
//
//    public void setDatEstimatedConclusion(Date datEstimatedConclusion) {
//        this.datEstimatedConclusion = datEstimatedConclusion;
//    }
//
//    public Date getDatRealConclusion() {
//        return datRealConclusion;
//    }
//
//    public void setDatRealConclusion(Date datRealConclusion) {
//        this.datRealConclusion = datRealConclusion;
//    }
//
//    public Date getDatViolationSla() {
//        return datViolationSla;
//    }
//
//    public void setDatViolationSla(Date datViolationSla) {
//        this.datViolationSla = datViolationSla;
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
//    public Long getNumMaximo() {
//        return numMaximo;
//    }
//
//    public void setNumMaximo(Long numMaximo) {
//        this.numMaximo = numMaximo;
//    }
//    
//}
