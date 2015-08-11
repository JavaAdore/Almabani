package com.almabani.portal.managedbean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import com.almabani.common.constant.MessagesKeyStore;
import com.almabani.common.entity.schema.admincor.Project;
import com.almabani.common.entity.schema.adminoam.ProjectJobTitle;
import com.almabani.common.enums.Active;
import com.almabani.common.util.Utils;
import com.almabani.portal.managedbean.applicationhelper.AbstractBeanHelper;
import com.almabani.portal.webutils.WebUtils;

@ManagedBean
@ViewScoped
public class ProjectJobTitleBean extends AbstractBeanHelper implements
		Serializable {

	private static final long serialVersionUID = 3527483048485089357L;

	private List<Project> projects;

	private Active[] active;


	private LazyDataModel<ProjectJobTitle> projectJobTitles;

	private ProjectJobTitle selectedProjectJobTitle;

	@PostConstruct
	public void init() {
		projectJobTitles = new ProjectJobLazyDataModel();
		projects = almabaniFacade.getAllProjects();
		active = Active.values();
	}  

	public LazyDataModel<ProjectJobTitle> getProjectJobTitles() {
		return projectJobTitles;
	}

	public void setProjectJobTitles(LazyDataModel<ProjectJobTitle> projectJobTitles) {
		this.projectJobTitles = projectJobTitles;
	}

	public void saveOrUpdate(ProjectJobTitle projectJobTitle) {
		try {
			boolean isAlreadyExisitEntity = Utils.hasID(selectedProjectJobTitle);
			
			projectJobTitle.setLastModificationDate(new Date());
			projectJobTitle = almabaniFacade.saveOrUpdate(projectJobTitle);
			WebUtils.invokeJavaScriptFunction("PF('createPJTDialog').hide()");
			WebUtils.fireInfoMessage(
					(isAlreadyExisitEntity) ? MessagesKeyStore.ALMABANI_GENERAL_UPDATED_SUCCESSFULLY
							: MessagesKeyStore.ALMABANI_GENERAL_ADDED_SUCCESSFULLY, 
					WebUtils.prepareParamSet(MessagesKeyStore.ALMABANI_PROJECT_JOB_TITLE));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public String extractFromBundle(String key) {
		return WebUtils.extractFromBundle(key);
	}

	public void prepareCreateProjectJobTitle() {
		selectedProjectJobTitle = new ProjectJobTitle();
		selectedProjectJobTitle.setActive(Active.Y);
		selectedProjectJobTitle.setModificationMakerName("Add New!");
	}

	/**
	 * @return the projects
	 */
	public List<Project> getProjects() {
		return projects;
	}

	/**
	 * @param projects
	 *            the projects to set
	 */
	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	/**
	 * @return the active
	 */
	public Active[] getActive() {
		return active;
	}

	/**
	 * @param active
	 *            the active to set
	 */
	public void setActive(Active[] active) {
		this.active = active;
	}

	

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * @return the selectedProjectJobTitle
	 */
	public ProjectJobTitle getSelectedProjectJobTitle() {
		return selectedProjectJobTitle;
	}

	/**
	 * @param selectedProjectJobTitle
	 *            the selectedProjectJobTitle to set
	 */
	public void setSelectedProjectJobTitle(
			ProjectJobTitle selectedProjectJobTitle) {
		this.selectedProjectJobTitle = selectedProjectJobTitle;
	}

	private class ProjectJobLazyDataModel extends LazyDataModel<ProjectJobTitle> implements
			Serializable {
		/**
 * 
 */
		private static final long serialVersionUID = 1L;
		private Integer rowCount;

		List<ProjectJobTitle> result;

		@Override
		public List<ProjectJobTitle> load(int first, int pageSize, String sortField,
				SortOrder sortOrder, Map<String, Object> filters) {
			rowCount = almabaniFacade.getCountOfProjectJobTitle(filters);

			result = (List<ProjectJobTitle>) almabaniFacade.loadProjectJobTitles(first,
					pageSize, sortField, sortOrder == SortOrder.ASCENDING,
					filters);

			setRowCount(this.rowCount);
 
			return result;
		}

		@Override
		public ProjectJobTitle getRowData(String rowKey) {

			for (ProjectJobTitle ProjectJobTitle : result) {
				if (ProjectJobTitle.getId().toString().equals(rowKey)) {
					selectedProjectJobTitle = ProjectJobTitle;
					return ProjectJobTitle;
				}
			}

			return null;
		}

	}

}
