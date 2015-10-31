package com.almabani.dataaccess.dao.adminoamImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.almabani.common.entity.schema.admincor.Company;
import com.almabani.common.entity.schema.adminoam.AllocationType;
import com.almabani.common.entity.schema.adminoam.OamTypeDevice;
import com.almabani.common.entity.schema.adminoam.OamZoneDevice;
import com.almabani.dataaccess.dao.adminoam.AllocationTypeDAO;
import com.almabani.dataaccess.dao.adminoam.OamZoneDeviceDAO;
import com.almabani.dataaccess.daoimpl.AbstractDAO;

@Repository
public class OamZoneDeviceDAOImpl extends AbstractDAO implements
		OamZoneDeviceDAO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public List<OamZoneDevice> getCamDevicesWithAssociatedLocations() {
		Query query = super
				.getCurrentSession()
				.createQuery(
						"select x from OamZoneDevice x where x.projectDevice.deviceType in :deviceTypes");
		List<OamTypeDevice> deviceTypes = new ArrayList();
		deviceTypes.add(OamTypeDevice.CCTV_CABINETS);
		deviceTypes.add(OamTypeDevice.FIXED_CAMERAS);
		query.setParameterList("deviceTypes", deviceTypes);
		return query.list();

	}

	@Override
	public OamZoneDevice getOamZoneDevice(Long id) {
		return (OamZoneDevice) super.getEntity(OamZoneDevice.class, id);
	}

}
