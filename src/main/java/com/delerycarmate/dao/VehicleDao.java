package com.delerycarmate.dao;


import com.delerycarmate.model.Vehicle;

import java.util.List;

public interface VehicleDao {

    void saveVehicle(Vehicle vehicle);

    List<Vehicle> findAllVehicles();

    void deleteVehicleById(int id);

    Vehicle findById(int id);

    void updateVehicle(Vehicle vehicle);
}
