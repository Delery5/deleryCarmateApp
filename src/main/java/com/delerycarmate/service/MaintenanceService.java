package com.delerycarmate.service;


import com.delerycarmate.model.Maintenance;

import java.util.List;

public interface MaintenanceService {

    void saveMaintenance(Maintenance maintenance);

    List<Maintenance> findAllMaintenances();

    void deleteMaintenanceById(int id);

    Maintenance findById(int id);

    void updateMaintenance(Maintenance maintenance);
}

