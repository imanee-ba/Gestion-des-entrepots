package com.example.controller;
import com.example.dto.Requests;
import com.example.model.Warehouse;
import com.example.repository.WarehouseRepository;
import com.example.service.LocationService;
import jakarta.validation.valid;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController 
@RestMaping("/apo/v1/warehouse") public class WarehouseController{
    private final WarehouseRepository repository;
    private final LocationService service;
    public WarehouseController(WarehouseRepository r,LocationService s){
        repository=r;
        service=s;
    }
    @GetMapping public<Warehouse> all(){
        return repository.findAll();
    }
    @PostMapping public Warehouse create(@Valid @RequestBody Requests.WarehouseCreate in){
        return service.createWarehouse(in);
    }
    
}