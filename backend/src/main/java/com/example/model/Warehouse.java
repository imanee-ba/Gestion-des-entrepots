package com.example.model;
import jakarta.persistence.*;
@Entity @Table(name="warehouse")
public class Warehouse{
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)public Long id;
    @Column(nullable=false,unique=true)public String code;
    @Column(nullable=false) public String name;
    public String address;
    public boolean active=true;
    protected Warehouse(){}
        public Warehouse(String code,String name,String address){
            this.code=code;
            this.name=name;
            his.address=address;

        }
    
}