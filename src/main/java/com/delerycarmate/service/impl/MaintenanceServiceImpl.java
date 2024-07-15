package com.delerycarmate.service.impl;

import com.delerycarmate.dao.MaintenanceDao;
import com.delerycarmate.model.Maintenance;
import com.delerycarmate.service.MaintenanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("maintenanceService")
@Transactional
public class MaintenanceServiceImpl implements MaintenanceService {

    @Autowired
    private MaintenanceDao dao;

    public void saveMaintenance(Maintenance maintenance) {
        dao.saveMaintenance(maintenance);
    }

    public List<Maintenance> findAllMaintenances() {
        return dao.findAllMaintenances();
    }

    public void deleteMaintenanceById(int id) {
        dao.deleteMaintenanceById(id);
    }

    public Maintenance findById(int id) {
        return dao.findById(id);
    }

    public void updateMaintenance(Maintenance maintenance) {
        dao.updateMaintenance(maintenance);
    }
}

