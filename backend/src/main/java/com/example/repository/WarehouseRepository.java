package com.example.repository;
import com.example.model.Warehouse;
import rg.springframework.data.jpa.repository.JpaRespository;
public interface WarehouseRepository extends JpaRepository<warehouse,Long>{boolean existsByCode(string code);}
