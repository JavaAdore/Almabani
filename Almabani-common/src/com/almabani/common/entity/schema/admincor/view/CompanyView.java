package com.almabani.common.entity.schema.admincor.view;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Subselect;

import com.almabani.common.entity.schema.admincor.State;

@Entity
@Subselect("select * from admincor.company_view")
public class CompanyView implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "NUM_COMPANY", nullable = false)
	private Long id; 
	
	@ManyToOne
	@JoinColumns({
			@JoinColumn(name = "NUM_COUNTRY", referencedColumnName = "NUM_COUNTRY", nullable = false),
			@JoinColumn(name = "COD_STATE", referencedColumnName = "COD_STATE", nullable = false) })
	private State state;
	
	
	
	@Column(name = "NAM_COMPANY", nullable = false, length = 80)
	private String companyName;



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public State getState() {
		return state;
	}



	public void setState(State state) {
		this.state = state;
	}



	public String getCompanyName() {
		return companyName;
	}



	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
	
	
	
	
	
	

}
