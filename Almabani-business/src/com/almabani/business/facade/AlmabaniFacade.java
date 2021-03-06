package com.almabani.business.facade;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.almabani.common.dto.CommonDriverMap;
import com.almabani.common.dto.UserApplicationGrant;
import com.almabani.common.dto.ZoneDeviceWithLocation;
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
import com.almabani.common.entity.schema.admincor.view.VComDepartmentSection;
import com.almabani.common.entity.schema.adminoam.AllocationType;
import com.almabani.common.entity.schema.adminoam.OamDocumentType;
import com.almabani.common.entity.schema.adminoam.OamItem;
import com.almabani.common.entity.schema.adminoam.OamItemCategory;
import com.almabani.common.entity.schema.adminoam.OamItemQuotation;
import com.almabani.common.entity.schema.adminoam.OamItemsQuotSupplier;
import com.almabani.common.entity.schema.adminoam.OamManufacturer;
import com.almabani.common.entity.schema.adminoam.OamProjectItem;
import com.almabani.common.entity.schema.adminoam.OamQuotation;
import com.almabani.common.entity.schema.adminoam.OamQuotationActionType;
import com.almabani.common.entity.schema.adminoam.OamQuotationDocument;
import com.almabani.common.entity.schema.adminoam.OamStockItem;
import com.almabani.common.entity.schema.adminoam.OamSupplier;
import com.almabani.common.entity.schema.adminoam.OamTypeMaterial;
import com.almabani.common.entity.schema.adminoam.OamZoneDevice;
import com.almabani.common.entity.schema.adminoam.ProjectEmployee;
import com.almabani.common.entity.schema.adminoam.ProjectJobTitle;
import com.almabani.common.entity.schema.adminoam.view.OamStockItemDetailsView;
import com.almabani.common.entity.schema.adminoam.view.OamStockItemView;
import com.almabani.common.entity.schema.adminsec.ApplicationType;
import com.almabani.common.entity.schema.adminsec.SecApplication;
import com.almabani.common.entity.schema.adminsec.SecApplicationsCompany;
import com.almabani.common.entity.schema.adminsec.SecModule;
import com.almabani.common.entity.schema.adminsec.SecSubModule;
import com.almabani.common.entity.schema.adminsec.SecSystem;
import com.almabani.common.entity.schema.adminsec.SecTypesPerfil;
import com.almabani.common.entity.schema.adminsec.SecUser;
import com.almabani.common.entity.schema.adminwkf.WokDailyOcurrence;
import com.almabani.common.entity.schema.adminwkf.WokDemand;
import com.almabani.common.entity.schema.adminwkf.WokOccurrenceType;
import com.almabani.common.entity.schema.adminwkf.WokUserGroup;
import com.almabani.common.entity.schema.adminwkf.WokWorkingGroup;
import com.almabani.common.entity.schema.adminwkf.view.WokDailyOcurrencesView;
import com.almabani.common.entity.schema.adminwkf.view.WokWorkingGroupsListView;
import com.almabani.common.exception.AlmabaniException;

@Service
public interface AlmabaniFacade {

	Company getCompany(Long id);

	Country getCountry(Long id);

	Department getDepartment(Long id);

	List<Department> getDepartments();

	List<Department> getDepartments(Company company);

	DepartmentSection saveOrUpdate(DepartmentSection departmentSection);

	DepartmentSection getDepartmentSection(Long id);

	List<DepartmentSection> getDepartmentSections(Department department);

	Employee saveOrUpdate(Employee employee);

	Employee getEmployee(Long id);

	boolean isFederalIdentityCodeExist(String federalIdentityCode);

	Integer getNumberOfEmployees(Map<String, Object> filters);

	JobTitleType getJobTitle(Long id);

	List<JobTitleType> getJobTitleTypes(Company company);

	OamQuotation getQuotataion(Long key);

	State getState(Long key);

	Integer getCountOfCompany(Map<String, Object> filters);

	List<Company> getAllCompanies();

	List<Company> loadCompanies(Integer first, Integer pageSize,
			String sortField, boolean assending, Map<String, Object> filters);

	Company addCompany(Company company, CommonDriverMap commonDriverMap)
			throws AlmabaniException;

	List<Country> getAllCountries();

	List<State> getStates(Country country);

	SecUser getUser(String userEmail);

	List<Module> loadUserModule(String userName);

	State getState(Long countryId, String stateCode);

	List<Employee> getEmployees(DepartmentSection selectedDepartmentSection);

	Integer getNumberOfQoutations(Map<String, Object> filters);

	Establishment getEstablishment(Long key);

	List<Establishment> getEstablishments(Company company);

	List<Establishment> getEstablishments();

	List<JobTitleType> getAllJobTitleTypes();

	List<OamQuotation> loadQoutations(int first, int pageSize,
			String sortField, boolean b, Map<String, Object> filters);

	WokDemand getWokDemand(Long id);

	List<WokDemand> getWokDemands();

	OamQuotation addOrUpdateQuotation(OamQuotation selected,
			CommonDriverMap commonDriverMap) throws AlmabaniException;

	Integer getNumberOfOamItemQuotations(Map<String, Object> filters);

	List<OamItemQuotation> loadItemQuotataions(int first, int pageSize,
			String sortField, boolean b, Map<String, Object> filters);

	List<OamQuotation> getAllQuotations();

	List<OamProjectItem> getAllProjectItems();

	OamProjectItem getProjectItem(Long projectItemId);

	OamItemQuotation addOrUpdateQuotationItem(OamItemQuotation selected,
			CommonDriverMap appendCurrentUserCode) throws AlmabaniException;

	Integer getCountOfOamItemsQuotSupplier(Map<String, Object> filters);

	List<OamItemsQuotSupplier> loadOamItemsQuotSuppliers(int first,
			int pageSize, String sortField, boolean ascending,
			Map<String, Object> filters);

	OamItemsQuotSupplier addOrUpdateOamItemsQuotSupplier(
			OamItemsQuotSupplier selected, CommonDriverMap commonDriverMap)
			throws AlmabaniException;

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

	Project getProject(Long id);

	List<Project> getProjects(Company company);

	List<Project> getAllProjects();

	List<OamItem> getAllItems();

	OamItem getItem(Long id);

	Contractor getContractor(Long contractorID);

	List<Contractor> getAllContractors();

	SecModule addOrUpdateModule(SecModule selected,
			CommonDriverMap appendCurrentUserCode) throws AlmabaniException;

	Project saveOrUpdate(Project project) throws AlmabaniException;

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

	List<UserApplicationGrant> getGrantedApplication(SecUser secUser,
			Company company);

	SecUser getSecUser(String userLoginCode);

	List<SecTypesPerfil> getAllPrefilTypes();

	SecTypesPerfil getPrefilType(String profileCode);

	void grantAccess(List<UserApplicationGrant> allApplications,
			CommonDriverMap appendCurrentUserCode) throws AlmabaniException;

	List<SecApplicationsCompany> getGrantableApplications(Company company);

	void grantCompanyAccess(List<SecApplicationsCompany> grantableApplications,
			CommonDriverMap commonDriverMap);

	List<AllocationType> getAllocationTypes(Company company);

	List<AllocationType> getAllAllocationTypes();

	AllocationType getAllocationType(Long id);

	ProjectJobTitle saveOrUpdate(ProjectJobTitle projectJobTitle);

	List<ProjectJobTitle> getProjectJobTitles(Company company);

	List<ProjectJobTitle> getAllProjectJobTitles();

	ProjectJobTitle getProjectJobTitle(Long id);

	ProjectEmployee saveOrUpdate(ProjectEmployee projectEmployee) throws AlmabaniException;

	List<SecUser> loadUsers(int first, int pageSize, String sortField,
			boolean ascending, Map<String, Object> filters);

	SecUser addorUpdateUser(SecUser selected, CommonDriverMap commonDriverMap)
			throws AlmabaniException;

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

	List<Employee> loadEmployees(int first, int pageSize, String sortField,
			boolean b, Map<String, Object> filters);

	List<OamQuotationActionType> getAvailableQuotationActionTypes(
			OamQuotation selected);

	OamQuotationActionType getOamQuotationActionType(Long id);

	List<UserApplicationGrant> getGrantedApplication(
			CommonDriverMap commonDriverMap);

	String getApplicationDescription(String applicationKey);

	List<SecUser> getCompanyUsers(Company company);

	List<Employee> getCompanyEmployees(Company company);

	List<OamManufacturer> getAllManufacturers(Company company);

	List<OamTypeMaterial> getAllMaterialTypes(Company company);

	OamManufacturer addOrUpdateManufacturer(OamManufacturer manufacturer,
			CommonDriverMap commonDriverMap) throws AlmabaniException;

	List<OamItemCategory> getAllItemCategories(Department department);

	List<OamItem> getAllItems(Company company);

	List<Project> getAllProjects(Company company);

	List<OamQuotation> getAllQuotations(Company company);

	List<OamProjectItem> getAllProjectItems(Company company);

	List<WokDemand> getWokDemands(Company company);

	List<OamItemQuotation> getAllQuotationItems(Company company);

	List<OamSupplier> getAllSuppliers(Company company);

	List<OamProjectItem> getAllCompanyProjectItems(
			String projectItemNameOrDescription, Company company);

	List<SecSystem> getAllSystems(Company company);

	List<SecModule> getAllModules(Company company);

	List<OamItem> getAllItems(String itemNameOrDescription, Company company);

	Integer getNumberOfOamStockItems(Map<String, Object> filters);

	List<OamStockItem> loadOamStockItems(int first, int pageSize,
			String sortField, boolean b, Map<String, Object> filters);

	OamStockItem addorUpdateOamStockItem(OamStockItem selected,
			CommonDriverMap appendCurrentUserCode) throws AlmabaniException;

	List<OamProjectItem> getAllProjectItems(
			String projectItemNameOrDescription, Department department);

	void checkQuotationItemSupplierSelectionAvailability(
			OamItemQuotation oamItemQuotation) throws AlmabaniException;

	void unselectOldSupplierOfQuotationItem(OamItemQuotation itemQuotation);

	List<OamStockItemView> loadOamStockItemsView(int first, int pageSize,
			String sortField, boolean b, Map<String, Object> filters);

	Integer getNumberOfOamStockItemsView(Map<String, Object> filters);

	List<OamStockItem> getAllStockItems();

	Integer getNumberOfStockItems(Map<String, Object> filters);

	List<Establishment> getAllEstablishments();

	List<Establishment> getAllEstablishments(Company currentLoggedUserCompany);

	List<OamItemQuotation> getItemQuotataion(OamProjectItem oamProjectItem);

	List<Department> getLightDepartments(Company company);

	List<Department> getLightDepartments();

	OamItemCategory addOrUpdateItemCategory(OamItemCategory oamItemCategory,
			CommonDriverMap commonDriverMap) throws AlmabaniException;

	Integer getNumberOfOamStockItemsDetailsView(Map<String, Object> filters);

	List<OamStockItemDetailsView> loadOamStockItemsDetailsView(int first,
			int pageSize, String sortField, boolean b,
			Map<String, Object> filters);

	Long getNumberofRemainingItems(OamProjectItem projectItem,
			Establishment establishment);

	List<WokWorkingGroupsListView> getWokDailyIccurrencesViewRecords(
			String currentUserCode);

	List<WokDailyOcurrencesView> loadWokDailyOcurrencesView(int first,
			int pageSize, String sortField, boolean assending,
			Map<String, Object> filters);

	Integer getCountOfWokDailyOcurrencesView(Map<String, Object> filters);

	List<WokOccurrenceType> getWokOccurrenceTypeList(
			Company currentLoggedUserCompany);

	List<WokUserGroup> getOperators(Company company,
			WokWorkingGroup workingGroup,SecUser secUser);

	List<WokUserGroup> getSafetyAgents(Company company,
			WokWorkingGroup workingGroup,SecUser secUser);

	List<WokUserGroup> getTechnicians(Company company,
			WokWorkingGroup workingGroup,SecUser secUser);

	List<WokUserGroup> getCommuincators(Company company,
			WokWorkingGroup workingGroup,SecUser secUser);

	WokOccurrenceType getOccurenceType(Long id);

	WokUserGroup getWokUserGroup(Long id);

	List<OamZoneDevice> getCamDevicesWithAssociatedLocations();

	OamZoneDevice getOamZoneDevice(Long id);

	WokDailyOcurrence addOrUpdateWokDailyOccurency(
			WokDailyOcurrence selectedWokDailyOcurrence,
			CommonDriverMap commonDriverMap) throws AlmabaniException;

	WokDailyOcurrence getWokDailyOccurence(Long id);

	List<Department> loadDepartments(int first, int pageSize, String sortField,
			boolean assending, Map<String, Object> filters);

	Integer getNumberOfDepartments(Map<String, Object> filters);

	Department addOrUpdate(Department selected,
			CommonDriverMap appendCurrentUserCode);
	
	List<VComDepartmentSection> loadDepartmentSectionsView(Integer first, Integer pageSize,
			String sortField, boolean assending, Map<String, Object> filters);

	Integer getNumberOfDepartmentSectionsView(Map<String, Object> filters);

	Integer getNumberOfEmployeesView(Map<String, Object> filters);

	Date getMinAllowedEmployeeDate();

	List<AllocationType> getAllocationTypes(Project selectedproject);

	List<ProjectJobTitle> getProjectJobTitles(Project selectedProject);

	List<OamDocumentType> getDocuemtTypeList(Company currentLoggedUserCompany);

	OamDocumentType getDocumentType(Long id);
	
	List<OamQuotationDocument> getQuotationDocuments(OamQuotation quotation);

	ZoneDeviceWithLocation getZoneLocation(OamZoneDevice oamZoneDevice);


}
