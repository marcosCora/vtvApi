package com.api.vtv.controller;

import com.api.vtv.dto.InspectorDTO;
import com.api.vtv.dto.OwnerDTO;
import com.api.vtv.entity.Inspector;
import com.api.vtv.entity.OwnerVehicle;
import com.api.vtv.services.implementation.ServiceInspector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vtv/inspector")
public class ControllerInspector {
    @Autowired
    private ServiceInspector service;

    @GetMapping
    public ResponseEntity<List<InspectorDTO>> getAllInspector(){
        return new ResponseEntity<>(service.getAllInspectors(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<InspectorDTO> getInspectorById(@PathVariable Integer id){
        return service.getInspectorById(id)
                .map(inspector ->(new ResponseEntity<>(inspector, HttpStatus.OK)))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/creat")
    public ResponseEntity<String> createInspector(@RequestBody Inspector inspector){
        return new ResponseEntity<>(service.createInspector(inspector), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateInspector(@PathVariable Integer id, @RequestBody Inspector inspector){
        ResponseEntity<String> response = null;
        try {
            response = new ResponseEntity<>(service.updateInspector(id, inspector), HttpStatus.OK);
        }catch (Exception e){
            response = ResponseEntity.badRequest().body(e.getMessage());
        }
        return response;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteInspector(@PathVariable Integer id){
        ResponseEntity<String> response = null;
        try {
            response = new ResponseEntity<>(service.deleteInspector(id), HttpStatus.OK);
        }catch (Exception e){
            response = ResponseEntity.badRequest().body(e.getMessage());
        }
        return response;
    }
}
