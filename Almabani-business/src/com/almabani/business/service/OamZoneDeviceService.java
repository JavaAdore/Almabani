 package com.almabani.business.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.almabani.common.entity.schema.adminoam.OamZoneDevice;

@Service
public interface OamZoneDeviceService {


	List<OamZoneDevice> getCamDevicesWithAssociatedLocations();

	OamZoneDevice getOamZoneDevice(Long id);
	
}
