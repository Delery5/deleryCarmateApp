package com.delerycarmate.service;


import com.delerycarmate.model.Maintenance;
import com.delerycarmate.model.User;
import com.delerycarmate.model.Vehicle;

import java.util.List;

public interface CarMateService {

    // User operations
    void saveUser(User user);

    List<User> findAllUsers();

    void deleteUserById(Long userId);

    User findUserById(Long userId);

    void updateUser(User user);

    // Vehicle operations
    void saveVehicle(Vehicle vehicle);

    List<Vehicle> findAllVehicles();

    void deleteVehicleById(Long vehicleId);

    Vehicle findVehicleById(Long vehicleId);

    void updateVehicle(Vehicle vehicle);

    // Maintenance operations
    void saveMaintenance(Maintenance maintenance);

    List<Maintenance> findAllMaintenances();

    void deleteMaintenanceById(Long maintenanceId);

    Maintenance findMaintenanceById(Long maintenanceId);

    void updateMaintenance(Maintenance maintenance);
}

