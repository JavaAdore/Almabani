package com.almabani.common.entity.schema.adminsec;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.almabani.common.constant.DataAccessConstants;
import com.almabani.common.dto.menu.Application;
import com.almabani.common.entity.schema.admincor.Employee;

/**
 * @author Mohamed_Ibrahim
 */

@Entity
@Table(schema = "ADMINSEC", name = "SEC_USERS")
public class SecUser implements java.io.Serializable {

	private static final long serialVersionUID = 4098605193547478911L;

	@Id
	@Column(name = "COD_USER_LOGIN", unique = true, nullable = false, length = 15)
	private String userLoginCode;

	@ManyToOne
	@JoinColumn(name = "COD_EMPLOYEE", referencedColumnName = "COD_EMPLOYEE", nullable = false)
	private Employee employee;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DAT_REGISTRATION", nullable = false, length = 7)
	private Date registrationDate;

	@Column(name = "IND_ACTIVE", length = 1)
	private String indActive;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DAT_BEGIN_INACTIVITY", length = 7)
	private Date beginInactivityDate;

	@Column(name = "DES_MOTIVE_INACTIVITY", length = 300)
	private String motiveInactivityDecription;

	/**
	 * modificationMakerName represent the user name who make the last
	 * modification
	 */
	@Column(name = "NAM_USER_MODIFY", nullable = false, length = 10)
	private String modificationMakerName;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DAT_LAST_MODIFY", nullable = false, length = 7)
	private Date lastModificationDate;

	@Column(name = "IND_ADMIN_SYSTEM", length = 1)
	private String indAdminSystem;

	@Column(name = "COD_password", nullable = false, length = 100)
	private String password;
	
	@Transient
	private List<Application> alllowedApps= new ArrayList<Application>();
	

	public SecUser() {
	}

	public SecUser(String userName) {
		this.userLoginCode = userName;
	}

	/**
	 * @return the userLoginCode
	 */
	public String getUserLoginCode() {
		return userLoginCode;
	}

	/**
	 * @param userLoginCode
	 *            the userLoginCode to set
	 */
	public void setUserLoginCode(String userLoginCode) {
		this.userLoginCode = userLoginCode;
	}

	// /**
	// * @return the employee
	// */
	// public Employee getEmployee() {
	// return employee;
	// }
	//
	// /**
	// * @param employee the employee to set
	// */
	// public void setEmployee(Employee employee) {
	// this.employee = employee;
	// }

	/**
	 * @return the registrationDate
	 */
	public Date getRegistrationDate() {
		return registrationDate;
	}

	/**
	 * @param registrationDate
	 *            the registrationDate to set
	 */
	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	/**
	 * @return the indActive
	 */
	public String getIndActive() {
		return indActive;
	}

	/**
	 * @param indActive
	 *            the indActive to set
	 */
	public void setIndActive(String indActive) {
		this.indActive = indActive;
	}

	/**
	 * @return the beginInactivityDate
	 */
	public Date getBeginInactivityDate() {
		return beginInactivityDate;
	}

	/**
	 * @param beginInactivityDate
	 *            the beginInactivityDate to set
	 */
	public void setBeginInactivityDate(Date beginInactivityDate) {
		this.beginInactivityDate = beginInactivityDate;
	}

	/**
	 * @return the motiveInactivityDate
	 */
	public String getMotiveInactivityDate() {
		return motiveInactivityDecription;
	}

	/**
	 * @param motiveInactivityDate
	 *            the motiveInactivityDate to set
	 */
	public void setMotiveInactivityDate(String motiveInactivityDecription) {
		this.motiveInactivityDecription = motiveInactivityDecription;
	}

	/**
	 * @return the modificationMakerName
	 */
	public String getModificationMakerName() {
		return modificationMakerName;
	}

	/**
	 * @param modificationMakerName
	 *            the modificationMakerName to set
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
	 * @param lastModificationDate
	 *            the lastModificationDate to set
	 */
	public void setLastModificationDate(Date lastModificationDate) {
		this.lastModificationDate = lastModificationDate;
	}

	/**
	 * @return the indAdminSystem
	 */
	public String getIndAdminSystem() {
		return indAdminSystem;
	}

	/**
	 * @param indAdminSystem
	 *            the indAdminSystem to set
	 */
	public void setIndAdminSystem(String indAdminSystem) {
		this.indAdminSystem = indAdminSystem;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isActive() {
		return indActive != null
				&& indActive.equalsIgnoreCase(DataAccessConstants.IND_ACTIVE) == true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((userLoginCode == null) ? 0 : userLoginCode.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SecUser other = (SecUser) obj;
		if (userLoginCode == null) {
			if (other.userLoginCode != null)
				return false;
		} else if (!userLoginCode.equals(other.userLoginCode))
			return false;
		return true;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public boolean isAdminUser() {

		return indAdminSystem != null && indAdminSystem.equalsIgnoreCase("Y");
	}

	public List<Application> getAlllowedApps() {
		return alllowedApps;
	}

	public void setAlllowedApps(List<Application> alllowedApps) {
		this.alllowedApps = alllowedApps;
	}

	


}
