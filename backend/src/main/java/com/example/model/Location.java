package com.example.model;
import jakarta.persistence.*;
@Entity @Table(name="locations")
public class Location{
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY) public Long id;
    @ManyToOne(fetch=FetchType.EAGER,optional=false) @JoinColumn(name="warehouse_id") public Warehouse warehouse;
    @Column(name="zone_code",nullable=false) public String zoneCode;
    @Column(name="aisle_code",nullable=false) public String aisleCode;
    @Column(name="rack_code",nullable=false) public String rackCode;
    @Column(name="level_code",nullable=false)public String levelCode;
    @Column(name="position_code",nullable=false)public String positionCode;
    @Column(name="full_address",nullable=false,unique=true)public String fullAddress;
    public int capacity;
    public int occupied=0;
    public boolean active=true;
    public boolean blocked=false;
    @Column(name="qr_token",nullable=false,unique=false)public String qrToken;
    protected Location(){}
    public Location(Warehouse w,String zone,String aisle,String rack,String level,String position,int capacity,String token){
        this.warehouse=w;
        this.zoneCode=zone;
        this.aisleCode=aisle;
        this.rackCode=rack;
        this.levelCode=level;
        this.positionCode=position;
        this.fullAddress=w.code+"/"+zone+"/"+aisle+"/"+rack+"/"+level+"/"+position;
        this.capacity=capacity;
        this.qrToken=token;
    
    }
}