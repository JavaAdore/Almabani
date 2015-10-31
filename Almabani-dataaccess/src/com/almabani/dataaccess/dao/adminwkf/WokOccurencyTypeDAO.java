package com.almabani.dataaccess.dao.adminwkf;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.almabani.common.entity.schema.admincor.Company;
import com.almabani.common.entity.schema.adminwkf.WokOccurrenceType;
import com.almabani.dataaccess.dao.AbstractDAOInt;

@Repository
public interface WokOccurencyTypeDAO  extends AbstractDAOInt{

	List<WokOccurrenceType> getWokOccurrenceTypeList(Company company);

	WokOccurrenceType getOccurenceType(Long id);


}
