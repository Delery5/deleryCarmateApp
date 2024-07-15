package com.delerycarmate.controller;


import com.delerycarmate.model.Vehicle;
import com.delerycarmate.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @RequestMapping("/saveVehicle")
    public String saveVehicle() {
        Vehicle vehicle = new Vehicle();
        vehicle.setMake("Dodge");
        vehicle.setModel("Charger");
        vehicleService.saveVehicle(vehicle);
        return "success";
    }
}

