package com.api.vtv.controller;

import com.api.vtv.dto.OwnerDTO;
import com.api.vtv.entity.OwnerVehicle;
import com.api.vtv.services.implementation.ServiceOwner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vtv/owner")
public class ControllerOwner {

    @Autowired
    private ServiceOwner service;

    @GetMapping
    public ResponseEntity<List<OwnerDTO>> getAllOwner(){
        return new ResponseEntity<>(service.getAllOwner(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OwnerDTO> getOwnerById(@PathVariable Integer id){
        return service.getOwnerById(id)
                .map(owner ->(new ResponseEntity<>(owner, HttpStatus.OK)))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/creat")
    public ResponseEntity<String> createOwner(@RequestBody OwnerVehicle owner){
        return new ResponseEntity<>(service.createOwner(owner), HttpStatus.OK);
    }

    @PostMapping("/creatfull")
    public ResponseEntity<String> createOwners(@RequestBody List<OwnerVehicle> owner){
        return new ResponseEntity<>(service.createOwners(owner), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateOwner(@PathVariable Integer id, @RequestBody OwnerVehicle owner){
        ResponseEntity<String> response = null;
        try {
            response = new ResponseEntity<>(service.updateOwner(id, owner), HttpStatus.OK);
        }catch (Exception e){
            response = ResponseEntity.badRequest().body(e.getMessage());
        }
        return response;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteOwner(@PathVariable Integer id){
        ResponseEntity<String> response = null;
        try {
            response = new ResponseEntity<>(service.deleteOwner(id), HttpStatus.OK);
        }catch (Exception e){
            response = ResponseEntity.badRequest().body(e.getMessage());
        }
        return response;
    }

}
