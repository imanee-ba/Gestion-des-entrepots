package com.example.dto;
import com.example.model.Location;
public record LocationView(Long id,Long warehouseId,String warehouseCode,String zoneCode,String aisleCode, String rackCode,String levelCode,String positionCode, String fullAddress, int capacity,int occupied, int available,double occupationPercent,boolean active,boolean blocked){
    public static LocationView from(Location l){
        return new LocationView(l.id,l.warehouse.id,l.warehouse.code, l.zoneCode,l.aisleCode,l.rackCode,l.levelCode,l.positionCode,l.fullAddress,l.capacity,l.occupied,l.capacity,l.occupied,100.0*l.occupied/l.capacity,l.active,l.blocked);
    }
}