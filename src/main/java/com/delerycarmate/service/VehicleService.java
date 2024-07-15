package com.delerycarmate.service;


import com.delerycarmate.model.Vehicle;

import java.util.List;

public interface VehicleService {

    void saveVehicle(Vehicle vehicle);

    List<Vehicle> findAllVehicles();

    void deleteVehicleById(int id);

    Vehicle findById(int id);

    void updateVehicle(Vehicle vehicle);
}

