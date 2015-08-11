package com.almabani.portal.managedbean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.SelectEvent;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import com.almabani.common.constant.MessagesKeyStore;
import com.almabani.common.entity.schema.admincor.Company;
import com.almabani.common.entity.schema.admincor.Contractor;
import com.almabani.common.entity.schema.admincor.Employee;
import com.almabani.common.entity.schema.admincor.Project;
import com.almabani.common.util.Utils;
import com.almabani.portal.managedbean.applicationhelper.AbstractBeanHelper;
import com.almabani.portal.webutils.WebUtils;

@ManagedBean
@ViewScoped
public class ProjectBean extends AbstractBeanHelper implements Serializable {

	private static final long serialVersionUID = 3932502364772794948L;

	private Project selectedProject;

	private LazyDataModel<Project> projectsList;

	private List<Company> companies;

	private List<Contractor> contractors;

	@PostConstruct
	public void init() {
		projectsList = new ProjectLazyDataModel();
		companies = almabaniFacade.getAllCompanies();
		contractors = almabaniFacade.getAllContractors();
	}

	public void prepareCreateProject() {
		selectedProject = new Project();
		selectedProject.setModificationMakerName("Create!");
	}

	public void saveOrUpdate() {

		boolean isAlreadyExisitEntity = Utils.hasID(selectedProject);
		selectedProject.setLastModificationDate(new Date());
		almabaniFacade.saveOrUpdate(selectedProject);
		
		WebUtils.invokeJavaScriptFunction("PF('createProjectDialog').hide()");
		WebUtils.fireInfoMessage(
				(isAlreadyExisitEntity) ? MessagesKeyStore.ALMABANI_GENERAL_UPDATED_SUCCESSFULLY
						: MessagesKeyStore.ALMABANI_GENERAL_ADDED_SUCCESSFULLY, 
				WebUtils.prepareParamSet(MessagesKeyStore.ALMABANI_PROJECT));

	}

	public String extractFromBundle(String key) {
		return WebUtils.extractFromBundle(key);
	}

	/**
	 * @return the selectedProject
	 */
	public Project getSelectedProject() {
		return selectedProject;
	}

	/**
	 * @param selectedProject
	 *            the selectedProject to set
	 */
	public void setSelectedProject(Project selectedProject) {
		this.selectedProject = selectedProject;
	}

	/**
	 * @return the projectsList
	 */
	public LazyDataModel<Project> getProjectsList() {
		return projectsList;
	}

	/**
	 * @param projectsList
	 *            the projectsList to set
	 */
	public void setProjectsList(LazyDataModel<Project> projectsList) {
		this.projectsList = projectsList;
	}

	/**
	 * @return the companies
	 */
	public List<Company> getCompanies() {
		return companies;
	}

	/**
	 * @param companies
	 *            the companies to set
	 */
	public void setCompanies(List<Company> companies) {
		this.companies = companies;
	}

	/**
	 * @return the contractors
	 */
	public List<Contractor> getContractors() {
		return contractors;
	}

	/**
	 * @param contractors
	 *            the contractors to set
	 */
	public void setContractors(List<Contractor> contractors) {
		this.contractors = contractors;
	}

	private class ProjectLazyDataModel extends LazyDataModel<Project> implements
			Serializable {
		
		private static final long serialVersionUID = -8581403240573581907L;

		private Integer rowCount;

		List<Project> result;

		@Override
		public List<Project> load(int first, int pageSize, String sortField,
				SortOrder sortOrder, Map<String, Object> filters) {
			rowCount = almabaniFacade.getCountOfProjectJobTitle(filters);

			result = (List<Project>) almabaniFacade.loadProjects(first,
					pageSize, sortField, sortOrder == SortOrder.ASCENDING,
					filters);

			setRowCount(this.rowCount);

			return result;
		}

		@Override
		public Project getRowData(String rowKey) {

			for (Project project : result) {
				if (project.getId().toString().equals(rowKey)) {
					selectedProject = project;
					return project;
				}
			}

			return null;
		}

	}
	
	
	public void onRowSelect(SelectEvent event) {
		selectedProject =  (Project) event.getObject();
	 } 

}
