package com.almabani.business.facadeimp;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.almabani.business.constant.BusinessConstants;
import com.almabani.business.facade.AlmabaniFacade;
import com.almabani.business.service.AllocationTypeService;
import com.almabani.business.service.ApplicationService;
import com.almabani.business.service.CompanyService;
import com.almabani.business.service.ContractorService;
import com.almabani.business.service.CountryService;
import com.almabani.business.service.DepartmentSectionService;
import com.almabani.business.service.DepartmentService;
import com.almabani.business.service.EmployeeService;
import com.almabani.business.service.EstablishmentService;
import com.almabani.business.service.ItemCategoryService;
import com.almabani.business.service.ItemService;
import com.almabani.business.service.ItemsQuotSupplierService;
import com.almabani.business.service.JobTitleTypeService;
import com.almabani.business.service.ManufacturerService;
import com.almabani.business.service.MaterialTypeService;
import com.almabani.business.service.MenuService;
import com.almabani.business.service.ModuleService;
import com.almabani.business.service.OamDocumentTypeService;
import com.almabani.business.service.OamQuotationActionTypeService;
import com.almabani.business.service.OamQuotationDocumentService;
import com.almabani.business.service.OamZoneDeviceService;
import com.almabani.business.service.PrefilTypeService;
import com.almabani.business.service.ProjectEmployeeService;
import com.almabani.business.service.ProjectItemService;
import com.almabani.business.service.ProjectJobTitleService;
import com.almabani.business.service.ProjectService;
import com.almabani.business.service.QoutationService;
import com.almabani.business.service.QuotationItemService;
import com.almabani.business.service.SecUserService;
import com.almabani.business.service.StateService;
import com.almabani.business.service.StockItemService;
import com.almabani.business.service.SubModuleService;
import com.almabani.business.service.SupplierService;
import com.almabani.business.service.SystemService;
import com.almabani.business.service.WokDailyOccurenceService;
import com.almabani.business.service.WokDemandService;
import com.almabani.business.service.WokOccurencyTypeService;
import com.almabani.business.service.WokUserGroupService;
import com.almabani.common.constant.DataAccessConstants;
import com.almabani.common.constant.MessagesKeyStore;
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
import com.almabani.common.entity.schema.adminsec.SecApplicationGrants;
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
import com.almabani.common.util.Utils;

@Service
@EnableTransactionManagement
public class AlmabaniFacadeImp extends BusinessCache implements AlmabaniFacade {

	private static final long serialVersionUID = 2497936510976318040L;

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private DepartmentService departmentService;

	@Autowired
	private DepartmentSectionService departmentSectionService;

	@Autowired
	private CompanyService companyService;

	@Autowired
	private StateService stateService;

	@Autowired
	private CountryService countryService;

	@Autowired
	private MenuService menuService;

	@Autowired
	private SecUserService secUserService;

	@Autowired
	private QoutationService qoutationService;

	@Autowired
	private EstablishmentService establishmentService;

	@Autowired
	private JobTitleTypeService jobTitleTypeService;

	@Autowired
	private WokDemandService wokDemandService;

	@Autowired
	private QuotationItemService quotationItemService;

	@Autowired
	private ProjectItemService projectItemService;

	@Autowired
	private ItemsQuotSupplierService itemsQuotSupplierService;

	@Autowired
	private SupplierService supplierService;

	@Autowired
	private ItemService itemService;

	@Autowired
	private ProjectEmployeeService projectEmployeeService;

	@Autowired
	private ManufacturerService manufacturerService;

	@Autowired
	private ItemCategoryService itemCategoryService;

	@Autowired
	private MaterialTypeService materialTypeService;

	@Autowired
	private ProjectService projectService;

	@Autowired
	private ContractorService contractorService;

	@Autowired
	private ModuleService moduleService;

	@Autowired
	private SubModuleService subModuleService;

	@Autowired
	private ApplicationService applicationService;

	@Autowired
	private SystemService systemService;

	@Autowired
	private PrefilTypeService prefilTypeService;

	@Autowired
	private AllocationTypeService allocationTypeService;

	@Autowired
	private ProjectJobTitleService projectJobTitleService;

	@Autowired
	private OamQuotationActionTypeService oamQuotationActionTypeService;

	@Autowired
	private StockItemService stockItemService;

	@Autowired
	private WokDailyOccurenceService wokDailyOccurenceService;

	@Autowired
	private WokOccurencyTypeService wokOccurencyTypeService;

	@Autowired
	private WokUserGroupService wokUserGroupService;

	@Autowired
	private OamZoneDeviceService zoneDeviceService;

	@Autowired
	private OamDocumentTypeService oamDocumentTypeService;
	
	@Autowired
	private OamQuotationDocumentService oamQuotationDocumentService;

	@PostConstruct
	public void cacheApplications() {
		if (Utils.isEmptyMap(getApplicationsDescriptions())) {
			Map<String, String> applicationDescription = applicationService
					.getApplicationDescriptionMap();
			setApplicationsDescriptions(applicationDescription);
		}
	}

	@Override
	public Company getCompany(Long id) {

		return companyService.getCompany(id);
	}

	@Override
	public Country getCountry(Long id) {

		return countryService.getCountry(id);
	}

	@Override
	public Employee saveOrUpdate(Employee employee) {
		return employeeService.saveOrUpdate(employee);
	}

	@Override
	public Employee getEmployee(Long id) {
		return employeeService.getEmployee(id);
	}

	@Override
	public List<Employee> getEmployees(
			DepartmentSection selectedDepartmentSection) {
		return employeeService.getEmployees(selectedDepartmentSection);
	}

	@Override
	public boolean isFederalIdentityCodeExist(String federalIdentityCode) {
		return employeeService.isFederalIdentityCodeExist(federalIdentityCode);
	}

	@Override
	public Integer getNumberOfEmployees(Map<String, Object> filters) {
		return employeeService.getNumberOfEmployees(filters);
	}

	@Override
	public Department getDepartment(Long id) {
		return departmentService.getDepartment(id);
	}

	@Override
	public List<Department> getDepartments() {
		return departmentService.getDepartments();
	}

	@Override
	public List<Department> getDepartments(Company company) {
		return departmentService.getDepartments(company);
	}

	@Override
	public DepartmentSection saveOrUpdate(DepartmentSection departmentSection) {
		return departmentSectionService.saveOrUpdate(departmentSection);
	}

	@Override
	public DepartmentSection getDepartmentSection(Long id) {
		return departmentSectionService.getDepartmentSection(id);
	}

	@Override
	public List<DepartmentSection> getDepartmentSections(Department department) {
		return departmentSectionService.getDepartmentSections(department);
	}

	@Override
	public JobTitleType getJobTitle(Long id) {

		return jobTitleTypeService.getJobTitle(id);
	}

	@Override
	public List<JobTitleType> getJobTitleTypes(Company company) {
		return jobTitleTypeService.getJobTitleTypes(company);
	}

	@Override
	public List<JobTitleType> getAllJobTitleTypes() {
		return jobTitleTypeService.getAllJobTitleTypes();
	}

	@Override
	public OamQuotation getQuotataion(Long quotationID) {

		return qoutationService.getQuotataion(quotationID);
	}

	@Override
	public State getState(Long key) {

		return null;
	}

	@Override
	public Company addCompany(Company company, CommonDriverMap commonDriverMap)
			throws AlmabaniException {

		company.assignLastModificationDate();

		company.setModificationMakerName(commonDriverMap.getTargetUser()
				.getUserLoginCode());
		if (Utils.hasID(company)) {
			return companyService.updateCompany(company);

		} else {
			return companyService.addCompany(company);
		}
	}

	@Override
	public List<Country> getAllCountries() {
		return countryService.getAllCountries();
	}

	@Override
	public List<State> getStates(Country country) {

		return stateService.getStates(country);
	}

	@Override
	public List<Company> loadCompanies(Integer first, Integer pageSize,
			String sortField, boolean assending, Map<String, Object> filters) {
		return companyService.loadCompanies(first, pageSize, sortField,
				assending, filters);
	}

	@Override
	public Integer getCountOfCompany(Map<String, Object> filters) {
		return companyService.getCountOfCompany(filters);
	}

	@Override
	public SecUser getUser(String userLoginCode) {
		return secUserService.getUser(userLoginCode);
	}

	@Override
	public List<Module> loadUserModule(String userName) {
		return menuService.loadUserModules(userName);
	}

	@Override
	public State getState(Long countryId, String stateCode) {
		return stateService.getState(countryId, stateCode);
	}

	@Override
	public Integer getNumberOfQoutations(Map<String, Object> filters) {
		return qoutationService.getCountOfQoutations(filters);
	}

	@Override
	public List<OamQuotation> loadQoutations(int first, int pageSize,
			String sortField, boolean assending, Map<String, Object> filters) {
		return qoutationService.loadQoutations(first, pageSize, sortField,
				assending, filters);
	}

	@Override
	public Establishment getEstablishment(Long key) {
		return establishmentService.getEstablishment(key);
	}

	@Override
	public List<Establishment> getEstablishments(Company company) {
		return establishmentService.getEstablishments(company);
	}

	@Override
	public List<Establishment> getEstablishments() {
		return establishmentService.getEstablishments();
	}

	@Override
	public WokDemand getWokDemand(Long id) {
		return wokDemandService.getWokDemand(id);
	}

	@Override
	public List<WokDemand> getWokDemands() {
		return wokDemandService.getWokDemands();
	}

	@Override
	public OamQuotation addOrUpdateQuotation(OamQuotation oamQuotation,
			CommonDriverMap commonDriverMap) throws AlmabaniException {

		if (Utils.hasID(oamQuotation)) {
			return qoutationService.updateQuotation(oamQuotation,
					commonDriverMap);
		} else {
			return qoutationService.addQuotation(oamQuotation, commonDriverMap);
		}
	}

	@Override
	public Integer getNumberOfOamItemQuotations(Map<String, Object> filters) {
		return quotationItemService.getCountOfQoutationItems(filters);
	}

	@Override
	public List<OamItemQuotation> loadItemQuotataions(int first, int pageSize,
			String sortField, boolean b, Map<String, Object> filters) {
		return quotationItemService.loadItemQuotataions(first, pageSize,
				sortField, b, filters);
	}

	@Override
	public List<OamQuotation> getAllQuotations() {
		return qoutationService.getAllQuotations();
	}

	@Override
	public List<OamProjectItem> getAllProjectItems() {
		return projectItemService.getAllProjectItems();
	}

	@Override
	public OamProjectItem getProjectItem(Long projectItemId) {
		return projectItemService.getProjectItem(projectItemId);
	}

	@Override
	public OamItemQuotation addOrUpdateQuotationItem(
			OamItemQuotation oamItemQuotation, CommonDriverMap commonDriverMap) throws AlmabaniException {
		if (Utils.hasID(oamItemQuotation)) {
			return quotationItemService.updateQuotationItem(oamItemQuotation,
					commonDriverMap);
		} else {
			return quotationItemService.addQuotationItem(oamItemQuotation,
					commonDriverMap);
		}
	}

	@Override
	public Integer getCountOfOamItemsQuotSupplier(Map<String, Object> filters) {
		return itemsQuotSupplierService.getCountOfOamItemsQuotSupplier(filters);
	}

	@Override
	public List<OamItemsQuotSupplier> loadOamItemsQuotSuppliers(int first,
			int pageSize, String sortField, boolean ascending,
			Map<String, Object> filters) {
		return itemsQuotSupplierService.loadOamItemsQuotSuppliers(first,
				pageSize, sortField, ascending, filters);
	}

	@Override
	public OamItemQuotation getItemQuotation(Long itemQuotationId) {
		return quotationItemService.getItemQuotation(itemQuotationId);
	}

	@Override
	public List<OamItemQuotation> getAllQuotationItems() {
		return quotationItemService.getAllQuotationItems();
	}

	@Override
	public OamSupplier getSupplier(Long supplierID) {
		return supplierService.getSupplier(supplierID);
	}

	@Override
	public List<OamSupplier> getAllSuppliers() {
		return supplierService.getAllSuppliers();
	}

	@Override
	public OamItemsQuotSupplier addOrUpdateOamItemsQuotSupplier(
			OamItemsQuotSupplier oamItemsQuotSupplier,
			CommonDriverMap commonDriverMap) throws AlmabaniException {
		if (Utils.hasID(oamItemsQuotSupplier)) {
			itemsQuotSupplierService
					.checkQuotationItemSupplierSelectionAvailability(oamItemsQuotSupplier
							.getItemQuotation());
			return itemsQuotSupplierService.updateOamItemsQuotSupplier(
					oamItemsQuotSupplier, commonDriverMap);
		} else {
			return itemsQuotSupplierService.addOamItemsQuotSupplier(
					oamItemsQuotSupplier, commonDriverMap);
		}
	}

	@Override
	public Integer getNumberOfOamSuppliers(Map<String, Object> filters) {
		return supplierService.getCountOfSupplier(filters);
	}

	@Override
	public List<OamSupplier> loadSuppliers(int first, int pageSize,
			String sortField, boolean assending, Map<String, Object> filters) {
		return supplierService.loadSuppliers(first, pageSize, sortField,
				assending, filters);
	}

	@Override
	public OamSupplier addorUpdateSupplier(OamSupplier oamSupplier,
			CommonDriverMap commonDriverMap) throws AlmabaniException {

		if (Utils.hasID(oamSupplier)) {
			return supplierService.updateSupplier(oamSupplier, commonDriverMap);
		} else {
			return supplierService.addSupplier(oamSupplier, commonDriverMap);
		}
	}

	@Override
	public List<ProjectEmployee> getProjectEmployee(Employee employee) {
		return projectEmployeeService.getProjectEmployee(employee);
	}

	@Override
	public List<ProjectEmployee> getProjectEmployee(List<Employee> employees) {
		return projectEmployeeService.getProjectEmployee(employees);
	}

	public List<Company> getAllCompanies() {

		return companyService.getAllCompanies();
	}

	@Override
	public List<OamItem> loadItems(int first, int pageSize, String sortField,
			boolean ascending, Map<String, Object> filters) {
		return itemService.loadItems(first, pageSize, sortField, ascending,
				filters);
	}

	@Override
	public OamItem addOrUpdateItem(OamItem oamItem,
			CommonDriverMap commonDriverMap) {
		if (Utils.hasID(oamItem)) {
			return itemService.updateItem(oamItem, commonDriverMap);
		} else {
			return itemService.addItem(oamItem, commonDriverMap);
		}
	}

	@Override
	public Integer getnumberOfItems(Map<String, Object> filters) {
		return itemService.getCountOfItems(filters);
	}

	@Override
	public OamManufacturer getManufacturer(Long Id) {
		return manufacturerService.getManufacturer(Id);
	}

	@Override
	public OamItemCategory getItemCategory(Long id) {
		return itemCategoryService.getItemCategory(id);
	}

	@Override
	public OamTypeMaterial getMaterialType(Long id) {
		return materialTypeService.getMaterialType(id);
	}

	@Override
	public List<OamManufacturer> getAllManufacturers() {
		return manufacturerService.getAllManufacturers();
	}

	@Override
	public List<OamItemCategory> getAllItemCategories() {
		return itemCategoryService.getAllItemCategories();
	}

	@Override
	public List<OamTypeMaterial> getAllMaterialTypes() {
		return materialTypeService.getAllMaterialTypes();
	}

	@Override
	public OamProjectItem addOrUpdateProjectItem(OamProjectItem projectItem,
			CommonDriverMap commonDriverMap) {
		if (Utils.hasID(projectItem)) {
			return projectItemService.updateProjectItem(projectItem,
					commonDriverMap);
		} else {
			return projectItemService.addProjectItem(projectItem,
					commonDriverMap);
		}
	}

	@Override
	public Integer getNumberOfProjectItems(Map<String, Object> filters) {
		return projectItemService.getCountOfProjectItems(filters);
	}

	@Override
	public List<OamProjectItem> loadProjectItems(int first, int pageSize,
			String sortField, boolean b, Map<String, Object> filters) {
		return projectItemService.loadProjectItems(first, pageSize, sortField,
				b, filters);
	}

	@Override
	public Project saveOrUpdate(Project project) throws AlmabaniException {

		if (project.getId() == null) {

			if (projectService.isProjectCodeExist(project.getProjectCode())) {
				throw new AlmabaniException(
						MessagesKeyStore.DUPLICATE_PROJECT_CODE);
			}

			projectService.persist(project);
		} else {

			if (!projectService.getProject(project.getId()).getProjectCode()
					.equals(project.getProjectCode()))
				if (projectService.isProjectCodeExist(project.getProjectCode())) {
					throw new AlmabaniException(
							MessagesKeyStore.DUPLICATE_PROJECT_CODE);
				}

			projectService.update(project);
		}

		return project;
	}

	@Override
	public Project getProject(Long id) {
		return projectService.getProject(id);
	}

	@Override
	public List<Project> getProjects(Company company) {
		return projectService.getProjects(company);
	}

	@Override
	public List<Project> getAllProjects() {
		return projectService.getAllProjects();
	}

	@Override
	public List<OamItem> getAllItems() {
		return itemService.getAllItems();
	}

	@Override
	public OamItem getItem(Long itemID) {
		return itemService.getItem(itemID);
	}

	@Override
	public Contractor getContractor(Long contractorID) {
		return contractorService.getContractor(contractorID);
	}

	@Override
	public List<Contractor> getAllContractors() {
		return contractorService.getAllContractors();
	}

	@Override
	public SecModule addOrUpdateModule(SecModule module,
			CommonDriverMap commonDriverMap) throws AlmabaniException {
		if (Utils.hasID(module)) {
			return moduleService.updateModule(module, commonDriverMap);
		} else {
			return moduleService.addModule(module, commonDriverMap);
		}
	}

	@Override
	public List<SecModule> loadModules(int first, int pageSize,
			String sortField, boolean assending, Map<String, Object> filters) {
		return moduleService.loadModules(first, pageSize, sortField, assending,
				filters);
	}

	@Override
	public Integer getNumberOfModules(Map<String, Object> filters) {
		return moduleService.getCountOfSecModule(filters);
	}

	@Override
	public List<SecSystem> getAllSystems() {
		return systemService.getAllSystems();
	}

	@Override
	public SecSystem getSystem(Long systemId) {
		return systemService.getSystem(systemId);
	}

	@Override
	public SecSubModule addOrUpdateSubModule(SecSubModule subModule,
			CommonDriverMap commonDriverMap) throws AlmabaniException {
		if (Utils.hasID(subModule)) {
			return subModuleService.updateSubModule(subModule, commonDriverMap);
		} else {
			return subModuleService.addSubModule(subModule, commonDriverMap);
		}
	}

	@Override
	public List<SecSubModule> loadSubModules(int first, int pageSize,
			String sortField, boolean assending, Map<String, Object> filters) {
		return subModuleService.loadSubModules(first, pageSize, sortField,
				assending, filters);
	}

	@Override
	public Integer getNumberOfSubModules(Map<String, Object> filters) {
		return subModuleService.getCountOfSubModules(filters);
	}

	@Override
	public List<SecModule> getAllModules() {
		return moduleService.getAllModules();
	}

	@Override
	public SecModule getModule(Long moduleId) {
		return moduleService.getModule(moduleId);
	}

	@Override
	public Integer getNumberOfApplications(Map<String, Object> filters) {
		return applicationService.getCountOfApplications(filters);
	}

	@Override
	public List<SecApplication> loadApplications(int first, int pageSize,
			String sortField, boolean assending, Map<String, Object> filters) {
		return applicationService.loadApplications(first, pageSize, sortField,
				assending, filters);
	}

	@Override
	public SecApplication addOrUpdateApplication(SecApplication secApplication,
			CommonDriverMap appendCurrentUserCode) throws AlmabaniException {

		if (Utils.isNotNull(secApplication.getLastModificationDate())) {

			SecApplication application = applicationService
					.getApplication(secApplication.getCodApplication());

			if (Utils.isNotNull(application)
					&& application.getLastModificationDate().equals(
							secApplication.getLastModificationDate())) {
				return applicationService.updateApplication(secApplication,
						appendCurrentUserCode);
			} else {
				throw new AlmabaniException(
						MessagesKeyStore.ALMABANI_APPLICATION_APPLICATION_CODE_ALREADY_EXSIT);
			}
		} else {
			SecApplication application = applicationService
					.getApplication(secApplication.getCodApplication());
			if (Utils.isNull(application)) {
				return applicationService.updateApplication(secApplication,
						appendCurrentUserCode);
			}
			throw new AlmabaniException(
					MessagesKeyStore.ALMABANI_APPLICATION_APPLICATION_CODE_ALREADY_EXSIT);

		}
	}

	@Override
	public SecSubModule getSubModule(Long subModuleId) {
		return subModuleService.getSubModule(subModuleId);
	}

	@Override
	public List<SecSubModule> getAllSubModules() {
		return subModuleService.getAllSubModules();
	}

	@Override
	public List<SecSubModule> getSubModules(SecModule module) {

		return subModuleService.getSubModules(module);
	}

	@Override
	public List<ApplicationType> getAllApplicationTypes() {
		return applicationService.getAllApplicationTypes();
	}

	@Override
	public ApplicationType getApplicationType(Long id) {
		return applicationService.getApplicationType(id);
	}

	@Override
	public List<UserApplicationGrant> getAllUserApplications() {
		return applicationService.getAllUserApplications();
	}

	@Override
	public List<SecUser> getAllUsers() {
		return secUserService.getAllUsers();
	}

	@Override
	public SecUser getSecUser(String userLoginCode) {
		return secUserService.getUser(userLoginCode);
	}

	@Override
	public List<UserApplicationGrant> getGrantedApplication(SecUser secUser,
			Company company) {
		CommonDriverMap commonDriverMap = new CommonDriverMap();
		commonDriverMap.appendCompany(commonDriverMap, company);
		commonDriverMap.appendTargetUser(commonDriverMap, secUser);
		return getGrantedApplication(commonDriverMap);

	}

	@Override
	public List<SecTypesPerfil> getAllPrefilTypes() {
		return prefilTypeService.getAllPrefilTypes();
	}

	@Override
	public SecTypesPerfil getPrefilType(String profileCode) {

		return prefilTypeService.getTypePrefil(profileCode);
	}

	@Override
	public void grantAccess(List<UserApplicationGrant> allApplications,
			CommonDriverMap commonDriverMap) throws AlmabaniException {
		applicationService.grantAccess(allApplications, commonDriverMap);
	}

	@Override
	public List<SecApplicationsCompany> getGrantableApplications(Company company) {

		List<SecApplication> allApplications = applicationService
				.getAllApplications();

		List<SecApplicationsCompany> result = new ArrayList<SecApplicationsCompany>();
		CommonDriverMap commonDriverMap = new CommonDriverMap();
		commonDriverMap.appendCompany(commonDriverMap, company);
		Map<SecApplication, UserApplicationGrant> appsGrantedToCompany = applicationService
				.getCompanyGrantedApps(commonDriverMap);

		for (SecApplication secApplication : allApplications) {

			UserApplicationGrant tempGrantApp = appsGrantedToCompany
					.get(secApplication);
			if (tempGrantApp != null) {
				tempGrantApp.getSecApplicationCompany().setGranted(true);
				result.add(tempGrantApp.getSecApplicationCompany());
			} else {
				SecApplicationsCompany secApplicationsCompany = new SecApplicationsCompany();
				secApplicationsCompany
						.setIndActive(DataAccessConstants.IND_ACTIVE);
				secApplicationsCompany.setApplication(secApplication);
				secApplicationsCompany.setCompany(company);
				result.add(secApplicationsCompany);
			}

		}

		return result;
	}

	@Override
	public void grantCompanyAccess(
			List<SecApplicationsCompany> grantableApplications,
			CommonDriverMap commonDriverMap) {
		applicationService.grantCompanyAccess(grantableApplications,
				commonDriverMap);

	}

	@Override
	public List<SecUser> loadUsers(int first, int pageSize, String sortField,
			boolean ascending, Map<String, Object> filters) {
		return secUserService.loadUsers(first, pageSize, sortField, ascending,
				filters);

	}

	@Override
	public SecUser addorUpdateUser(SecUser user, CommonDriverMap commonDriverMap)
			throws AlmabaniException {

		SecUser tempUser = secUserService.getUser(user.getUserLoginCode());

		if (Utils.isNotNull(tempUser)) {
			if (Utils.isNotNull(user.getLastModificationDate())
					&& user.getLastModificationDate().equals(
							tempUser.getLastModificationDate())) {

				return secUserService.updateUser(user, commonDriverMap);
			} else {
				throw new AlmabaniException(
						MessagesKeyStore.ALMABANI_GENERAL_USER_ALREADY_EXIST);
			}
		} else {
			return secUserService.addUser(user, commonDriverMap);

		}

	}

	@Override
	public List<AllocationType> getAllocationTypes(Company company) {
		return allocationTypeService.getAllocationTypes(company);
	}

	@Override
	public List<AllocationType> getAllAllocationTypes() {
		return allocationTypeService.getAllAllocationTypes();
	}

	@Override
	public AllocationType getAllocationType(Long id) {
		return allocationTypeService.getAllocationType(id);
	}

	@Override
	public ProjectJobTitle saveOrUpdate(ProjectJobTitle projectJobTitle) {
		return projectJobTitleService.saveOrUpdate(projectJobTitle);
	}

	@Override
	public ProjectJobTitle getProjectJobTitle(Long id) {
		return projectJobTitleService.getProjectJobTitle(id);
	}

	@Override
	public List<ProjectJobTitle> getProjectJobTitles(Company company) {
		return projectJobTitleService.getProjectJobTitles(company);
	}

	@Override
	public List<ProjectJobTitle> getAllProjectJobTitles() {
		return projectJobTitleService.getAllProjectJobTitles();
	}

	@Override
	public Integer getCountOfUsers(Map<String, Object> filters) {
		return secUserService.getNumberOfUser(filters);
	}

	@Override
	public List<Employee> getAllEmployees() {
		return employeeService.getAllEmployees();
	}

	@Override
	public ProjectEmployee saveOrUpdate(ProjectEmployee projectEmployee)
			throws AlmabaniException {
		return projectEmployeeService.saveOrUpdate(projectEmployee);
	}

	@Override
	public Integer getCountOfProjectJobTitle(Map<String, Object> filters) {
		return projectJobTitleService.getCountOfProjectJobTitle(filters);
	}

	@Override
	public List<ProjectJobTitle> loadProjectJobTitles(int first, int pageSize,
			String sortField, boolean asc, Map<String, Object> filters) {
		return projectJobTitleService.loadProjectJobTitles(first, pageSize,
				sortField, asc, filters);
	}

	@Override
	public Integer getNumberOfProjectEmployees(Map<String, Object> filters) {
		return projectEmployeeService.getNumberOfProjectEmployees(filters);
	}

	@Override
	public List<ProjectEmployee> loadProjectsAllocationEmployee(int first,
			int pageSize, String sortField, boolean ascending,
			Map<String, Object> filters) {
		return projectEmployeeService.loadProjectsAllocationEmployee(first,
				pageSize, sortField, ascending, filters);
	}

	@Override
	public List<Project> loadProjects(int first, int pageSize,
			String sortField, boolean ascending, Map<String, Object> filters) {
		return projectService.loadProjects(first, pageSize, sortField,
				ascending, filters);
	}

	@Override
	public List<Employee> loadEmployees(int first, int pageSize,
			String sortField, boolean assending, Map<String, Object> filters) {
		return employeeService.loadEmployees(first, pageSize, sortField,
				assending, filters);
	}

	@Override
	public List<OamQuotationActionType> getAvailableQuotationActionTypes(
			OamQuotation selected) {

		return oamQuotationActionTypeService
				.getAvailableQuotationActionTypes(selected);

	}

	@Override
	public OamQuotationActionType getOamQuotationActionType(Long id) {
		return oamQuotationActionTypeService.getOamQuotationActionType(id);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<UserApplicationGrant> getGrantedApplication(
			CommonDriverMap commonDriverMap) {
		Map<SecApplication, UserApplicationGrant> appsGrantedToCompany = applicationService
				.getCompanyGrantedApps(commonDriverMap);

		Map<SecApplication, SecApplicationGrants> appsGrantedToUserInCompany = applicationService
				.getGrantedApplication(commonDriverMap);

		for (UserApplicationGrant userApplicationGrant : appsGrantedToCompany
				.values()) {
			if (appsGrantedToUserInCompany.get(userApplicationGrant
					.getApplication()) != null) {

				userApplicationGrant.setGranted(true);
				userApplicationGrant.setPrefilType(appsGrantedToUserInCompany
						.get(userApplicationGrant.getApplication())
						.getTypesPerfil());
			}

		}
		return new ArrayList(appsGrantedToCompany.values());
	}

	@Override
	public String getApplicationDescription(String applicationCode) {
		return super.getApplicationDescription(applicationCode);
	}

	@Override
	public List<SecUser> getCompanyUsers(Company company) {
		return secUserService.getUsers(company);
	}

	@Override
	public List<Employee> getCompanyEmployees(Company company) {
		return employeeService.getCompanyEmployees(company);
	}

	@Override
	public List<OamManufacturer> getAllManufacturers(Company company) {

		return manufacturerService.getAllManufacturers(company);
	}

	@Override
	public List<OamTypeMaterial> getAllMaterialTypes(Company company) {
		return materialTypeService.getAllMaterialTypes(company);
	}

	@Override
	public OamManufacturer addOrUpdateManufacturer(
			OamManufacturer manufacturer, CommonDriverMap commonDriverMap)
			throws AlmabaniException {

		if (Utils.hasID(manufacturer)) {
			return manufacturerService.updateManufacturer(manufacturer,
					commonDriverMap);
		} else {
			return manufacturerService.addManufacturer(manufacturer,
					commonDriverMap);

		}
	}

	@Override
	public List<OamItemCategory> getAllItemCategories(Department department) {

		return itemCategoryService.getAllItemCategories(department);
	}

	@Override
	public List<OamItem> getAllItems(Company company) {

		return itemService.getAllItems(company);
	}

	@Override
	public List<Project> getAllProjects(Company company) {
		return projectService.getProjects(company);
	}

	@Override
	public List<OamQuotation> getAllQuotations(Company company) {
		return qoutationService.getAllQuotations(company);
	}

	@Override
	public List<OamProjectItem> getAllProjectItems(Company company) {

		return projectItemService.getAllProjectItems(company);
	}

	@Override
	public List<WokDemand> getWokDemands(Company company) {
		return wokDemandService.getWokDemands(company);
	}

	@Override
	public List<OamItemQuotation> getAllQuotationItems(Company company) {
		return quotationItemService.getAllQuotationItems(company);
	}

	@Override
	public List<OamSupplier> getAllSuppliers(Company company) {
		return supplierService.getAllSuppliers(company);
	}

	@Override
	public List<OamProjectItem> getAllCompanyProjectItems(
			String projectItemNameOrDescription, Company company) {
		return supplierService.getAllProjectItems(projectItemNameOrDescription,
				company);
	}

	@Override
	public List<SecSystem> getAllSystems(Company company) {
		return systemService.getAllSystems(company);
	}

	@Override
	public List<SecModule> getAllModules(Company company) {
		return moduleService.getAllModules(company);
	}

	@Override
	public List<OamItem> getAllItems(String itemNameOrDescription,
			Company company) {
		return itemService.getAllItems(itemNameOrDescription, company);
	}

	@Override
	public Integer getNumberOfOamStockItems(Map<String, Object> filters) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OamStockItem> loadOamStockItems(int first, int pageSize,
			String sortField, boolean assending, Map<String, Object> filters) {
		return stockItemService.loadStockItems(first, pageSize, sortField,
				assending, filters);
	}

	@Override
	public OamStockItem addorUpdateOamStockItem(OamStockItem oamStockItem,
			CommonDriverMap commonDriverMap) throws AlmabaniException {

		if (Utils.hasID(oamStockItem)) {

			return stockItemService.updateStockItem(oamStockItem,
					commonDriverMap);
		} else {
			Long numberOfRemainingItems = stockItemService
					.getNumberofRemainingItems(oamStockItem.getProjectItem(),
							oamStockItem.getEstablishment());
			if (numberOfRemainingItems < oamStockItem.getEntryValue()) {
				throw new AlmabaniException(
						MessagesKeyStore.ALMABANI_GENERAL_REQUESTED_AMOUNT_IS_GRATER_THAN_EXIST_AMOUNT);
			}
			return stockItemService.addStockItem(oamStockItem, commonDriverMap);
		}
	}

	@Override
	public List<OamProjectItem> getAllProjectItems(
			String projectItemNameOrDescription, Department department) {
		return projectItemService.getAllProjectItems(
				projectItemNameOrDescription, department);
	}

	@Override
	public void checkQuotationItemSupplierSelectionAvailability(
			OamItemQuotation oamItemQuotation) throws AlmabaniException {

		itemsQuotSupplierService
				.checkQuotationItemSupplierSelectionAvailability(oamItemQuotation);

	}

	@Override
	public void unselectOldSupplierOfQuotationItem(
			OamItemQuotation itemQuotation) {
		itemsQuotSupplierService
				.unselectOldSupplierOfQuotationItem(itemQuotation);
	}

	@Override
	public List<OamStockItemView> loadOamStockItemsView(int first,
			int pageSize, String sortField, boolean ascending,
			Map<String, Object> filters) {

		return stockItemService.loadOamStockItemsView(first, pageSize,
				sortField, ascending, filters);
	}

	@Override
	public Integer getNumberOfOamStockItemsView(Map<String, Object> filters) {
		return stockItemService.getNumberOfOamStockItemsView(filters);
	}

	@Override
	public List<OamStockItem> getAllStockItems() {
		return stockItemService.getAllStockItems();
	}

	@Override
	public Integer getNumberOfStockItems(Map<String, Object> filters) {
		return stockItemService.getNumberOfOamStockItemsView(filters);
	}

	@Override
	public List<Establishment> getAllEstablishments() {
		return establishmentService.getEstablishments();
	}

	@Override
	public List<Establishment> getAllEstablishments(Company company) {
		return establishmentService.getEstablishments(company);
	}

	@Override
	public List<OamItemQuotation> getItemQuotataion(
			OamProjectItem oamProjectItem) {
		return quotationItemService.getItemQuotataion(oamProjectItem);
	}

	@Override
	public List<Department> getLightDepartments(Company company) {
		return departmentService.getLightDepartments(company);
	}

	@Override
	public List<Department> getLightDepartments() {
		return departmentService.getLightDepartments();
	}

	@Override
	public OamItemCategory addOrUpdateItemCategory(
			OamItemCategory oamItemCategory, CommonDriverMap commonDriverMap)
			throws AlmabaniException {
		if (Utils.hasID(oamItemCategory)) {
			return itemCategoryService.updateItemCategory(oamItemCategory,
					commonDriverMap);
		} else {
			return itemCategoryService.addItemCategory(oamItemCategory,
					commonDriverMap);
		}
	}

	@Override
	public Integer getNumberOfOamStockItemsDetailsView(
			Map<String, Object> filters) {
		return stockItemService.getNumberOfOamStockItemsDetailsView(filters);
	}

	@Override
	public List<OamStockItemDetailsView> loadOamStockItemsDetailsView(
			int first, int pageSize, String sortField, boolean assending,
			Map<String, Object> filters) {
		return stockItemService.loadOamStockItemsDetailsView(first, pageSize,
				sortField, assending, filters);
	}

	@Override
	public Long getNumberofRemainingItems(OamProjectItem projectItem,
			Establishment establishment) {
		return stockItemService.getNumberofRemainingItems(projectItem,
				establishment);
	}

	@Override
	public List<WokWorkingGroupsListView> getWokDailyIccurrencesViewRecords(
			String currentUserCode) {
		return wokDailyOccurenceService
				.getWokDailyIccurrencesViewRecords(currentUserCode);
	}

	@Override
	public List<WokDailyOcurrencesView> loadWokDailyOcurrencesView(int first,
			int pageSize, String sortField, boolean assending,
			Map<String, Object> filters) {
		return wokDailyOccurenceService.loadWokDailyOcurrencesView(first,
				pageSize, sortField, assending, filters);
	}

	@Override
	public Integer getCountOfWokDailyOcurrencesView(Map<String, Object> filters) {
		return wokDailyOccurenceService
				.getCountOfWokDailyOcurrencesView(filters);
	}

	@Override
	public List<WokOccurrenceType> getWokOccurrenceTypeList(Company company) {
		return wokOccurencyTypeService.getWokOccurrenceTypeList(company);
	}

	@Override
	public List<WokUserGroup> getOperators(Company company,
			WokWorkingGroup wokWorkingGroup, SecUser secUser) {
		Object operatorsParamValue = wokOccurencyTypeService
				.getOperatorsParamValue(company);
		if (Utils.isNotNull(operatorsParamValue)) {
			return wokUserGroupService.getOperators(operatorsParamValue,
					wokWorkingGroup, secUser);
		}
		return new ArrayList<WokUserGroup>();
	}

	@Override
	public List<WokUserGroup> getCommuincators(Company company,
			WokWorkingGroup wokWorkingGroup, SecUser secUser) {
		Object communicatorsParamValue = wokOccurencyTypeService
				.getCommuincatorsParamValue(company);
		if (Utils.isNotNull(communicatorsParamValue)) {
			return wokUserGroupService.getCommuincators(
					communicatorsParamValue, wokWorkingGroup, secUser);
		}
		return new ArrayList<WokUserGroup>();
	}

	@Override
	public List<WokUserGroup> getSafetyAgents(Company company,
			WokWorkingGroup wokWorkingGroup, SecUser secUser) {
		Object safetyAgentsParamValue = wokOccurencyTypeService
				.getSafetyAgentsParamValue(company);
		if (Utils.isNotNull(safetyAgentsParamValue)) {
			return wokUserGroupService.getSafetyAgents(safetyAgentsParamValue,
					wokWorkingGroup, secUser);
		}
		return new ArrayList<WokUserGroup>();
	}

	@Override
	public List<WokUserGroup> getTechnicians(Company company,
			WokWorkingGroup wokWorkingGroup, SecUser secUser) {
		Object techincianParamValue = wokOccurencyTypeService
				.getTechniciansParamValue(company);
		if (Utils.isNotNull(techincianParamValue)) {
			return wokUserGroupService.getTechnicians(techincianParamValue,
					wokWorkingGroup, secUser);
		}
		return new ArrayList<WokUserGroup>();
	}

	@Override
	public WokOccurrenceType getOccurenceType(Long id) {
		return wokOccurencyTypeService.getOccurenceType(id);
	}

	@Override
	public WokUserGroup getWokUserGroup(Long id) {
		return wokUserGroupService.getWokUserGroup(id);
	}

	@Override
	public List<OamZoneDevice> getCamDevicesWithAssociatedLocations() {
		return zoneDeviceService.getCamDevicesWithAssociatedLocations();
	}

	@Override
	public OamZoneDevice getOamZoneDevice(Long id) {
		return zoneDeviceService.getOamZoneDevice(id);
	}

	@Override
	public WokDailyOcurrence addOrUpdateWokDailyOccurency(
			WokDailyOcurrence selectedWokDailyOcurrence,
			CommonDriverMap commonDriverMap) throws AlmabaniException {
		if (Utils.hasID(selectedWokDailyOcurrence)) {
			return wokDailyOccurenceService.updateWokDailyOccurency(
					selectedWokDailyOcurrence, commonDriverMap);
		} else {
			return wokDailyOccurenceService.addWokDailyOccurency(
					selectedWokDailyOcurrence, commonDriverMap);

		}
	}

	@Override
	public WokDailyOcurrence getWokDailyOccurence(Long id) {
		return wokDailyOccurenceService.getWokDailyOccurence(id);
	}

	@Override
	public List<Department> loadDepartments(int first, int pageSize,
			String sortField, boolean assending, Map<String, Object> filters) {
		return departmentService.loadDepartments(first, pageSize, sortField,
				assending, filters);
	}

	@Override
	public Integer getNumberOfDepartments(Map<String, Object> filters) {
		return departmentService.getNumberOfDepartments(filters);
	}

	@Override
	public Department addOrUpdate(Department department,
			CommonDriverMap commonDriverMap) {
		if (Utils.hasID(department)) {

			return departmentService.addDepartment(department, commonDriverMap);
		} else {
			return departmentService.updateDepartment(department,
					commonDriverMap);
		}
	}

	@Override
	public List<VComDepartmentSection> loadDepartmentSectionsView(
			Integer first, Integer pageSize, String sortField,
			boolean assending, Map<String, Object> filters) {
		return departmentSectionService.loadDepartmentSectionsView(first,
				pageSize, sortField, assending, filters);
	}

	@Override
	public Integer getNumberOfDepartmentSectionsView(Map<String, Object> filters) {
		return departmentSectionService
				.getNumberOfDepartmentSectionsView(filters);
	}

	@Override
	public Integer getNumberOfEmployeesView(Map<String, Object> filters) {
		return employeeService.getNumberOfEmployees(filters);
	}

	@Override
	public Date getMinAllowedEmployeeDate() {
		Calendar c = Calendar.getInstance();
		c.add(Calendar.YEAR, BusinessConstants.MIN_ACCEPTED_EMPLOYEE_OLD * -1);
		return c.getTime();
	}

	@Override
	public List<AllocationType> getAllocationTypes(Project selectedproject) {
		return allocationTypeService.getAllocationType(selectedproject);
	}

	@Override
	public List<ProjectJobTitle> getProjectJobTitles(Project selectedProject) {
		return projectJobTitleService.getProjectJobTitles(selectedProject);
	}

	@Override
	public List<OamDocumentType> getDocuemtTypeList(
			Company currentLoggedUserCompany) {
		return oamDocumentTypeService
				.getDocuemtTypeList(currentLoggedUserCompany);
	}

	@Override
	public OamDocumentType getDocumentType(Long id) {
		return oamDocumentTypeService.getDocumentType( id);
	}

	@Override
	public List<OamQuotationDocument> getQuotationDocuments(
			OamQuotation quotation) {
		return oamQuotationDocumentService.getQuotationDocuments(quotation);
				 
	}
	
	public ZoneDeviceWithLocation getZoneLocation(OamZoneDevice oamZoneDevice)
	{
		
		return zoneDeviceService.getZoneLocation( oamZoneDevice);
	}

}
