package com.example.dto;
import jakarta.validation.constraints.*;
public class Requests{
    public record WarehouseCreate(@NotBlank String code,@NotBlank String name,String address){}
    public record LocationCreate(@NotNull Long warehouseId,
        @NotBlank String zoneCode,@NotBLank String aisleCode,@NotBlank String rackCode,
        @NotBlank String levelCode,@NotBlank String positionCode,@Min(1) int capacity){
            public record Occupanct(@Min(0) int occupied){}
            public record Status (boolean active,boolean blocked){}

        }
    
}