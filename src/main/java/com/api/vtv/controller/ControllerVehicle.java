package com.api.vtv.controller;

import com.api.vtv.dto.VehicleDTO;
import com.api.vtv.entity.Vehicle;
import com.api.vtv.services.IServiceVehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vtv/vehicle")
public class ControllerVehicle {

    @Autowired
    private IServiceVehicle service;

    @GetMapping
    public ResponseEntity<List<VehicleDTO>> getAllVehicle(){
        return new ResponseEntity<>(service.getAllVehicle(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VehicleDTO> getVehicleById(@PathVariable Integer id){
        return service.getVechicleById(id)
                .map(vehicle -> (new ResponseEntity<>(vehicle, HttpStatus.OK)))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/creat")
    public ResponseEntity<String> createVehicle(@RequestBody Vehicle vehicle){
        return new ResponseEntity<>(service.createVehicle(vehicle), HttpStatus.OK);
    }

    @PostMapping("/creatfull")
    public ResponseEntity<String> createVehicles(@RequestBody List<Vehicle> vehicles){
        return new ResponseEntity<>(service.createVehicles(vehicles), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateVehicle(@PathVariable Integer id, @RequestBody Vehicle vehicle){
        ResponseEntity<String> response = null;
        try {
            response = new ResponseEntity<>(service.updateVehicle(id, vehicle), HttpStatus.OK);
        }catch (Exception e){
            response = ResponseEntity.badRequest().body(e.getMessage());
        }
        return response;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteVehicle(@PathVariable Integer id){
        ResponseEntity<String> response = null;
        try {
            response = new ResponseEntity<>(service.deleteVehicle(id), HttpStatus.OK);
        }catch (Exception e){
            response = ResponseEntity.badRequest().body(e.getMessage());
        }
        return response;
    }


}
