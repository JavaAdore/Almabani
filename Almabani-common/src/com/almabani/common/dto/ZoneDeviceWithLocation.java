package com.almabani.common.dto;

import java.io.Serializable;

import com.almabani.common.entity.schema.adminoam.OamProjectDevice;
import com.almabani.common.entity.schema.adminoam.OamSite;
import com.almabani.common.entity.schema.adminoam.OamSiteDirection;
import com.almabani.common.entity.schema.adminoam.OamZone;
import com.almabani.common.entity.schema.adminoam.OamZoneDevice;

public class ZoneDeviceWithLocation implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private OamZoneDevice oamZoneDevice;
	private OamSiteDirection siteDirection;
	private OamSite site;

	public ZoneDeviceWithLocation() {
	}

	public ZoneDeviceWithLocation(OamZoneDevice oamZoneDevice,
			OamSiteDirection siteDirection, OamSite site) {
		super();
		this.oamZoneDevice = oamZoneDevice;
		this.siteDirection = siteDirection;
		this.site = site;
	}

	public OamZoneDevice getOamZoneDevice() {
		return oamZoneDevice;
	}

	public void setOamZoneDevice(OamZoneDevice oamZoneDevice) {
		this.oamZoneDevice = oamZoneDevice;
	}

	public OamSiteDirection getSiteDirection() {
		return siteDirection;
	}

	public void setSiteDirection(OamSiteDirection siteDirection) {
		this.siteDirection = siteDirection;
	}

	public OamSite getSite() {
		return site;
	}

	public void setSite(OamSite site) {
		this.site = site;
	}

}
