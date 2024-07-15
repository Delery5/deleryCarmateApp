package com.delerycarmate.service.impl;

import com.delerycarmate.dao.VehicleDao;
import com.delerycarmate.model.Vehicle;
import com.delerycarmate.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("vehicleService")
@Transactional
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    private VehicleDao dao;

    public void saveVehicle(Vehicle vehicle) {
        dao.saveVehicle(vehicle);
    }

    public List<Vehicle> findAllVehicles() {
        return dao.findAllVehicles();
    }

    public void deleteVehicleById(int id) {
        dao.deleteVehicleById(id);
    }

    public Vehicle findById(int id) {
        return dao.findById(id);
    }

    public void updateVehicle(Vehicle vehicle) {
        dao.updateVehicle(vehicle);
    }
}
