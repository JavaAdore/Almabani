package com.almabani.dataaccess.dao.adminoam;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.almabani.common.entity.schema.admincor.Company;
import com.almabani.common.entity.schema.adminoam.AllocationType;
import com.almabani.common.entity.schema.adminoam.OamZoneDevice;
import com.almabani.dataaccess.dao.AbstractDAOInt;

@Repository
public interface OamZoneDeviceDAO extends AbstractDAOInt{

	List<OamZoneDevice> getCamDevicesWithAssociatedLocations();

	OamZoneDevice getOamZoneDevice(Long id);


	
}
