package com.almabani.business.serviceimp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.almabani.business.service.OamZoneDeviceService;
import com.almabani.common.dto.ZoneDeviceWithLocation;
import com.almabani.common.entity.schema.adminoam.OamZoneDevice;
import com.almabani.common.util.Utils;
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

	@Override
	public ZoneDeviceWithLocation getZoneLocation(OamZoneDevice oamZoneDevice) {
	
	List<ZoneDeviceWithLocation> result = 	oamZoneDeviceDAO.getCamDeviceWithAssociatedLocations(oamZoneDevice);
	return (ZoneDeviceWithLocation) Utils.getFirstResult(result);
	}
	
	
	
}
