package com.almabani.business.serviceimp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.almabani.business.service.OamZoneDeviceService;
import com.almabani.common.entity.schema.adminoam.OamZoneDevice;
import com.almabani.dataaccess.dao.adminoam.OamZoneDeviceDAO;

@Service
public class OamZoneDeviceServiceImpl implements OamZoneDeviceService {

	@Autowired
	OamZoneDeviceDAO oamZoneDeviceDAO;

	@Override
	public List<OamZoneDevice> getCamDevicesWithAssociatedLocations() {
		return oamZoneDeviceDAO.getCamDevicesWithAssociatedLocations();
	}

	@Override
	public OamZoneDevice getOamZoneDevice(Long id) {
		return oamZoneDeviceDAO.getOamZoneDevice( id);
	}
	
	
	
}
