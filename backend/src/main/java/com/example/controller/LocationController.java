package com.example.controller;
import com.example.dto.*;
import com.example.service.*;
import jakarta.validation.Valid;
import org.springframework.data.domain.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
@RestController @RequestMapping("/api/v1/locations") public class LocationController {
 private final LocationService service;private final QrService qr;
 public LocationController(LocationService s,QrService q){service=s;qr=q;}
 @GetMapping public Page<LocationView> list(@RequestParam(required=false) Long warehouseId,@RequestParam(required=false) String search,
 @RequestParam(required=false) Boolean availableOnly,@RequestParam(defaultValue="0") int page,@RequestParam(defaultValue="20") int size){
  return service.search(warehouseId,search,availableOnly,PageRequest.of(Math.max(0,page),Math.min(100,Math.max(1,size)),Sort.by("fullAddress")));
 }
 @PostMapping public ResponseEntity<LocationView> create(@Valid @RequestBody Requests.LocationCreate in){return ResponseEntity.status(HttpStatus.CREATED).body(service.create(in));}
 @GetMapping("/{id}") public LocationView get(@PathVariable Long id){return service.get(id);}
 @GetMapping("/scan/{token}") public LocationView scan(@PathVariable String token){return service.byToken(token);}
 @GetMapping(value="/{id}/qr",produces=MediaType.IMAGE_PNG_VALUE) public byte[] qr(@PathVariable Long id){return qr.png(service.require(id).qrToken);}
 @PatchMapping("/{id}/occupancy") public LocationView occupancy(@PathVariable Long id,@Valid @RequestBody Requests.Occupancy in){return service.updateOccupancy(id,in.occupied());}
 @PatchMapping("/{id}/status") public LocationView status(@PathVariable Long id,@RequestBody Requests.Status in){return service.changeStatus(id,in);}
}
