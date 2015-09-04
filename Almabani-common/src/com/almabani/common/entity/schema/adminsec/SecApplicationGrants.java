package com.almabani.common.entity.schema.adminsec;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import com.almabani.common.dto.UserApplicationGrant;
import com.almabani.common.entity.AbstractEntity;

/**
 * @author Mohamed_Ibrahim
 */

@Entity
@Table(schema="ADMINSEC", name = "SEC_APPLICATIONS_GRANTS", uniqueConstraints = @UniqueConstraint(columnNames = {
		"COD_USER_LOGIN", "NUM_APPLICATION_COMPANY" }))
@SequenceGenerator(name = "SecApplicationsGrants_Id_Seq_Gen", sequenceName = "ADMINSEC.SEC_SEQ_NUM_APPLICATION_GRANT", allocationSize = 1, initialValue = 1)
public class SecApplicationGrants extends AbstractEntity implements Serializable {  
	
	private static final long serialVersionUID = -7746566707610384731L;

	@Id
	@Column(name = "NUM_APPLICATION_GRANT", unique = true, nullable = false, precision = 10, scale = 0)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SecApplicationsGrants_Id_Seq_Gen")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "COD_PERFIL", referencedColumnName="COD_PERFIL", nullable = false)
	private SecTypesPerfil typesPerfil;
	
	@ManyToOne
	@JoinColumn(name = "NUM_APPLICATION_COMPANY", referencedColumnName="NUM_APPLICATION_COMPANY", nullable = false)
	private SecApplicationsCompany applicationsCompany;
	
	@Column(name = "COD_USER_LOGIN", nullable = false, length = 15)
	private String userLoginCode;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "DAT_BEGIN_VALIDITY", nullable = false, length = 7)
	private Date validityBeginDate;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "DAT_END_VALIDITY", length = 7)
	private Date validityEndDate;
	
	@Column(name = "DES_OBSERVATION", nullable = false, length = 100)
	private String observationDescription;
	
	/**
	 * modificationMakerName represent the user name who make the last modification
	 */
	@Column(name = "NAM_USER_MODIFY", nullable = false, length = 10)
	private String modificationMakerName;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "DAT_LAST_MODIFY", nullable = false, length = 7)
	private Date lastModificationDate;

	public SecApplicationGrants() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the typesPerfil
	 */
	public SecTypesPerfil getTypesPerfil() {
		return typesPerfil;
	}

	/**
	 * @param typesPerfil the typesPerfil to set
	 */
	public void setTypesPerfil(SecTypesPerfil typesPerfil) {
		this.typesPerfil = typesPerfil;
	}

	/**
	 * @return the applicationsCompany
	 */
	public SecApplicationsCompany getApplicationsCompany() {
		return applicationsCompany;
	}

	/**
	 * @param applicationsCompany the applicationsCompany to set
	 */
	public void setApplicationsCompany(SecApplicationsCompany applicationsCompany) {
		this.applicationsCompany = applicationsCompany;
	}

	/**
	 * @return the userLoginCode
	 */
	public String getUserLoginCode() {
		return userLoginCode;
	}

	/**
	 * @param userLoginCode the userLoginCode to set
	 */
	public void setUserLoginCode(String userLoginCode) {
		this.userLoginCode = userLoginCode;
	}

	/**
	 * @return the validityBeginDate
	 */
	public Date getValidityBeginDate() {
		return validityBeginDate;
	}

	/**
	 * @param validityBeginDate the validityBeginDate to set
	 */
	public void setValidityBeginDate(Date validityBeginDate) {
		this.validityBeginDate = validityBeginDate;
	}

	/**
	 * @return the validityEndDate
	 */
	public Date getValidityEndDate() {
		return validityEndDate;
	}

	/**
	 * @param validityEndDate the validityEndDate to set
	 */
	public void setValidityEndDate(Date validityEndDate) {
		this.validityEndDate = validityEndDate;
	}

	/**
	 * @return the observationDescription
	 */
	public String getObservationDescription() {
		return observationDescription;
	}

	/**
	 * @param observationDescription the observationDescription to set
	 */
	public void setObservationDescription(String observationDescription) {
		this.observationDescription = observationDescription;
	}

	/**
	 * @return the modificationMakerName
	 */
	public String getModificationMakerName() {
		return modificationMakerName;
	}

	/**
	 * @param modificationMakerName the modificationMakerName to set
	 */
	public void setModificationMakerName(String modificationMakerName) {
		this.modificationMakerName = modificationMakerName;
	}

	/**
	 * @return the lastModificationDate
	 */
	public Date getLastModificationDate() {
		return lastModificationDate;
	}

	/**
	 * @param lastModificationDate the lastModificationDate to set
	 */
	public void setLastModificationDate(Date lastModificationDate) {
		this.lastModificationDate = lastModificationDate;
	}

	@Override
	public int hashCode() {
		return 1;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		if(obj instanceof SecApplicationGrants)
		{
			SecApplicationGrants other = (SecApplicationGrants) obj;
			if (id == null) {
				if (other.id != null)
					return false;
			} else if (!id.equals(other.id))
				return false;
			return true;
		} else if(obj instanceof UserApplicationGrant)
		{
			if(applicationsCompany!=null && applicationsCompany.getApplication() !=null)
			{
				return applicationsCompany.getApplication().equals( ((UserApplicationGrant)obj).getApplication() );
			}
		} 
			return false;
		
		
		
		
	}
	
}
