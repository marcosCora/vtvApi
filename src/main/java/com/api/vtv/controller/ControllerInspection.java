package com.api.vtv.controller;

import com.api.vtv.dto.InspectionDTO;
import com.api.vtv.dto.VehicleDTO;
import com.api.vtv.entity.Inspection;
import com.api.vtv.services.IServiceInspection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vtv/inspection")
public class ControllerInspection {

    @Autowired
    private IServiceInspection service;

    //modificar esta funcion como deberia estar
    @GetMapping
    public ResponseEntity<List<Inspection>> getAllInspection(){
        //return new ResponseEntity<>(service.getAllInspection(), HttpStatus.OK);
        return new ResponseEntity<>(service.getAllInspectionNotDto(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<InspectionDTO> getInspectionById(@PathVariable Integer id){
        return service.getInspectionById(id)
                .map(inspector -> (new ResponseEntity<>(inspector, HttpStatus.OK)))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/creat")
    public ResponseEntity<String> createInspection(@RequestBody Inspection inspection){
        System.out.println(inspection);
        return new ResponseEntity<>(service.createInspection(inspection), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateInspection(@PathVariable Integer id, @RequestBody Inspection inspection){
        ResponseEntity<String> response = null;
        try {
            response = new ResponseEntity<>(service.updateInspection(id, inspection), HttpStatus.OK);
        }catch (Exception e){
            response = ResponseEntity.badRequest().body(e.getMessage());
        }
        return response;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteInspection(@PathVariable Integer id){
        ResponseEntity<String> response = null;
        try {
            response = new ResponseEntity<>(service.deleteInspection(id), HttpStatus.OK);
        }catch (Exception e){
            response = ResponseEntity.badRequest().body(e.getMessage());
        }
        return response;
    }
}
