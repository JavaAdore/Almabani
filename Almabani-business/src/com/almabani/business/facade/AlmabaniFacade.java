package com.almabani.business.facade;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.almabani.common.dto.CommonDriverMap;
import com.almabani.common.dto.UserApplicationGrant;
import com.almabani.common.dto.menu.Module;
import com.almabani.common.entity.schema.admincor.Company;
import com.almabani.common.entity.schema.admincor.Contractor;
import com.almabani.common.entity.schema.admincor.Country;
import com.almabani.common.entity.schema.admincor.Department;
import com.almabani.common.entity.schema.admincor.DepartmentSection;
import com.almabani.common.entity.schema.admincor.Employee;
import com.almabani.common.entity.schema.admincor.Establishment;
import com.almabani.common.entity.schema.admincor.JobTitleType;
import com.almabani.common.entity.schema.admincor.Project;
import com.almabani.common.entity.schema.admincor.State;
import com.almabani.common.entity.schema.adminoam.AllocationType;
import com.almabani.common.entity.schema.adminoam.OamItem;
import com.almabani.common.entity.schema.adminoam.OamItemCategory;
import com.almabani.common.entity.schema.adminoam.OamItemQuotation;
import com.almabani.common.entity.schema.adminoam.OamItemsQuotSupplier;
import com.almabani.common.entity.schema.adminoam.OamManufacturer;
import com.almabani.common.entity.schema.adminoam.OamProjectItem;
import com.almabani.common.entity.schema.adminoam.OamQuotation;
import com.almabani.common.entity.schema.adminoam.OamSupplier;
import com.almabani.common.entity.schema.adminoam.OamTypeMaterial;
import com.almabani.common.entity.schema.adminoam.ProjectEmployee;
import com.almabani.common.entity.schema.adminoam.ProjectJobTitle;
import com.almabani.common.entity.schema.adminsec.ApplicationType;
import com.almabani.common.entity.schema.adminsec.SecApplication;
import com.almabani.common.entity.schema.adminsec.SecApplicationsCompany;
import com.almabani.common.entity.schema.adminsec.SecModule;
import com.almabani.common.entity.schema.adminsec.SecSubModule;
import com.almabani.common.entity.schema.adminsec.SecSystem;
import com.almabani.common.entity.schema.adminsec.SecTypesPerfil;
import com.almabani.common.entity.schema.adminsec.SecUser;
import com.almabani.common.entity.schema.adminwkf.WokDemand;
import com.almabani.common.exception.AlmabaniException;

@Service
public interface AlmabaniFacade {

	Company getCompany(Long id);

	Country getCountry(Long id);
	
	Department saveOrUpdate(Department department);

	Department getDepartment(Long id);
	
	List<Department> getDepartments();
	
	List<Department> getDepartments(Company company);	
	
	DepartmentSection saveOrUpdate(DepartmentSection departmentSection);

	DepartmentSection getDepartmentSection(Long id);
	
	List<DepartmentSection> getDepartmentSections(Department department);

	Employee saveOrUpdate(Employee employee);
	
	Employee getEmployee(Long id);

	JobTitleType getJobTitle(Long id);

	OamQuotation getQuotataion(Long key);

	State getState(Long key);

	Integer getCountOfCompany(Map<String, Object> filters);
	
	List<Company> getAllCompanies();
	
	List<Company> loadCompanies(Integer first, Integer pageSize, String sortField, boolean assending, Map<String, Object> filters);
	
	Company addCompany(Company company) throws AlmabaniException;

	List<Country> getAllCountries();

	List<State> getStates(Country country);

	SecUser getUser(String userEmail);

	List<Module> loadUserModule(String userName);

	State getState(Long countryId, String stateCode);

	List<Employee> getEmployees(DepartmentSection selectedDepartmentSection);

	Integer getNumberOfQoutations(Map<String, Object> filters);

	Establishment getEstablishment(Long key);
	
	List<Establishment> getEstablishments();
	
	List<JobTitleType> getJobTitleTypes();
	List<OamQuotation> loadQoutations(int first, int pageSize,
			String sortField, boolean b, Map<String, Object> filters);

	WokDemand getWokDemand(Long id);

	List<WokDemand> getWokDemands();

	OamQuotation addOrUpdateQuotation(OamQuotation selected,
			CommonDriverMap commonDriverMap);

	Integer getNumberOfOamItemQuotations(Map<String, Object> filters);

	List<OamItemQuotation> loadItemQuotataions(int first, int pageSize,
			String sortField, boolean b, Map<String, Object> filters);

	List<OamQuotation> getAllQuotations();

	List<OamProjectItem> getAllProjectItems();

	OamProjectItem getProjectItem(Long projectItemId);

	OamItemQuotation addOrUpdateQuotationItem(OamItemQuotation selected,
			CommonDriverMap appendCurrentUserCode);

	Integer getCountOfOamItemsQuotSupplier(Map<String, Object> filters);

	List<OamItemsQuotSupplier> loadOamItemsQuotSuppliers(int first,
			int pageSize, String sortField, boolean ascending,
			Map<String, Object> filters);

	OamItemsQuotSupplier addOrUpdateOamItemsQuotSupplier(
			OamItemsQuotSupplier selected, CommonDriverMap commonDriverMap);

	OamItemQuotation getItemQuotation(Long itemQuotationId);

	List<OamItemQuotation> getAllQuotationItems();

	OamSupplier getSupplier(Long supplierID);

	List<OamSupplier> getAllSuppliers();

	Integer getNumberOfOamSuppliers(Map<String, Object> filters);

	List<OamSupplier> loadSuppliers(int first, int pageSize, String sortField,
			boolean b, Map<String, Object> filters);

	OamSupplier addorUpdateSupplier(OamSupplier selected,
			CommonDriverMap appendCurrentUserCode) throws AlmabaniException;

	List<ProjectEmployee> getProjectEmployee(Employee employee);
	
	List<ProjectEmployee> getProjectEmployee(List<Employee> employees);

	List<OamItem> loadItems(int first, int pageSize, String sortField,
			boolean b, Map<String, Object> filters);

	OamItem addOrUpdateItem(OamItem selected,
			CommonDriverMap appendCurrentUserCode);

	Integer getnumberOfItems(Map<String, Object> filters);

	Object getManufacturer(Long Id);

	OamItemCategory getItemCategory(Long id);

	OamTypeMaterial getMaterialType(Long id);

	List<OamManufacturer> getAllManufacturers();

	List<OamItemCategory> getAllItemCategories();

	List<OamTypeMaterial> getAllMaterialTypes();

	OamProjectItem addOrUpdateProjectItem(OamProjectItem selected,
			CommonDriverMap appendCurrentUserCode);

	Integer getNumberOfProjectItems(Map<String, Object> filters);

	List<OamProjectItem> loadProjectItems(int first, int pageSize,
			String sortField, boolean b, Map<String, Object> filters);

	List<Project> getAllProjects();

	Project getProject(Long id);

	List<OamItem> getAllItems();

	OamItem getItem(Long id);

	Contractor getContractor(Long contractorID);
	
	List<Contractor> getAllContractors();
	SecModule addOrUpdateModule(SecModule selected,
			CommonDriverMap appendCurrentUserCode) throws AlmabaniException;

	Project saveOrUpdate(Project project);
	
	List<SecModule> loadModules(int first, int pageSize, String sortField,
			boolean b, Map<String, Object> filters);

	Integer getNumberOfModules(Map<String, Object> filters);

	List<SecSystem> getAllSystems();

	SecSystem getSystem(Long systemId);

	SecSubModule addOrUpdateSubModule(SecSubModule selected,
			CommonDriverMap appendCurrentUserCode) throws AlmabaniException;

	List<SecSubModule> loadSubModules(int first, int pageSize,
			String sortField, boolean b, Map<String, Object> filters);

	Integer getNumberOfSubModules(Map<String, Object> filters);

	List<SecModule> getAllModules();

	SecModule getModule(Long moduleId);

	Integer getNumberOfApplications(Map<String, Object> filters);

	List<SecApplication> loadApplications(int first, int pageSize,
			String sortField, boolean b, Map<String, Object> filters);

	SecApplication addOrUpdateApplication(SecApplication selected,
			CommonDriverMap appendCurrentUserCode) throws AlmabaniException;


	SecSubModule getSubModule(Long subModuleId);

	List<SecSubModule> getAllSubModules();

	List<SecSubModule> getSubModules(SecModule module);

	List<ApplicationType> getAllApplicationTypes();

	ApplicationType getApplicationType(Long id);


	List<UserApplicationGrant> getAllUserApplications();

	List<SecUser> getAllUsers();

	List<UserApplicationGrant> getGrantedApplication(SecUser secUser, Company company);

	SecUser getSecUser(String userLoginCode);

	List<SecTypesPerfil> getAllPrefilTypes();

	SecTypesPerfil getPrefilType(String profileCode);

	void grantAccess(List<UserApplicationGrant> allApplications,
			CommonDriverMap appendCurrentUserCode)throws AlmabaniException;

	List<SecApplicationsCompany> getGrantableApplications(Company company);

	void grantCompanyAccess(List<SecApplicationsCompany> grantableApplications,
			CommonDriverMap commonDriverMap);

	List<AllocationType> getAllAllocationTypes();
	
	AllocationType getAllocationType(Long id);
	
	ProjectJobTitle saveOrUpdate(ProjectJobTitle projectJobTitle);
	
	List<ProjectJobTitle> getAllProjectJobTitles();

	ProjectJobTitle getProjectJobTitle(Long id);

	ProjectEmployee saveOrUpdate(ProjectEmployee projectEmployee);
	
	List<SecUser> loadUsers(int first, int pageSize, String sortField,
			boolean ascending, Map<String, Object> filters);

	SecUser addorUpdateUser(SecUser selected,
			CommonDriverMap commonDriverMap) throws AlmabaniException;

	Integer getCountOfUsers(Map<String, Object> filters);

	List<Employee> getAllEmployees();

	Integer getCountOfProjectJobTitle(Map<String, Object> filters);

	List<ProjectJobTitle> loadProjectJobTitles(int first, int pageSize,
			String sortField, boolean b, Map<String, Object> filters);

	Integer getNumberOfProjectEmployees(Map<String, Object> filters);

	List<ProjectEmployee> loadProjectsAllocationEmployee(int first,
			int pageSize, String sortField, boolean b,
			Map<String, Object> filters);

	List<Project> loadProjects(int first, int pageSize, String sortField,
			boolean b, Map<String, Object> filters);
	
}
