package com.almabani.portal.managedbean;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import com.almabani.common.entity.schema.admincor.view.VComDepartmentSection;
import com.almabani.portal.managedbean.applicationhelper.AbstractBeanHelper;
import com.almabani.portal.webutils.WebUtils;

@ManagedBean
@ViewScoped
public class EmployeeManagementBean extends AbstractBeanHelper implements
		Serializable {

	private static final long serialVersionUID = 1L;

	public VComDepartmentSection selectedDepartmentSection;

	private LazyDataModel<VComDepartmentSection> departmentSections;
 
	@PostConstruct 
	public void init() {
		initializeLazyModels();
	}

	private void initializeLazyModels() {

		initializeDepartmentSectionsLazyModel();
	}

	private void initializeDepartmentSectionsLazyModel() {

		departmentSections = new DepartmentSectionLazyModel();
	}

	private class DepartmentSectionLazyModel extends
			LazyDataModel<VComDepartmentSection> implements Serializable {

		private static final long serialVersionUID = 1L;
		List<VComDepartmentSection> result;

		private Integer rowCount;

		@Override
		public VComDepartmentSection getRowData(String rowKey) {

			for (VComDepartmentSection vComDepartmentSection : result) {
				if (vComDepartmentSection.getDepartmentSectionNumber()
						.toString().equals(rowKey)) {
					selectedDepartmentSection = vComDepartmentSection;
					return vComDepartmentSection;
				}
			}

			return null;
		}

		@Override
		public List<VComDepartmentSection> load(int first, int pageSize,
				String sortField, SortOrder sortOrder,
				Map<String, Object> filters) {

			attachCompanyInCaseOfNoneAdminUser(filters);

			rowCount = almabaniFacade
					.getNumberOfDepartmentSectionsView(filters);
			result = (List<VComDepartmentSection>) almabaniFacade
					.loadDepartmentSectionsView(first, pageSize, sortField,
							sortOrder == SortOrder.ASCENDING, filters);
			setRowCount(this.rowCount);

			return result;

		}

		private void attachCompanyInCaseOfNoneAdminUser(
				Map<String, Object> filters) {

			if (WebUtils.isAdminUser() == false) {
				filters.put("company", WebUtils.getCurrentLoggedUserCompany());
			}
		}

	}

	public VComDepartmentSection getSelectedDepartmentSection() {
		return selectedDepartmentSection;
	}

	public void setSelectedDepartmentSection(
			VComDepartmentSection selectedDepartmentSection) {
		this.selectedDepartmentSection = selectedDepartmentSection;
	}

	public LazyDataModel<VComDepartmentSection> getDepartmentSections() {
		return departmentSections;
	}

	public void setDepartmentSections(
			LazyDataModel<VComDepartmentSection> departmentSections) {
		this.departmentSections = departmentSections;
	}

}
