package com.example.repository;
import com.example.model.Location;
import org.springframework.data.jpa.repository.JpaRpository;
import org.springframework.data.jpa.JpaSpecificationExecutor;
import java.util.Optional;
public interface LocationRepository extends JpaRpository<Location,Long>,JpaSpecificationExecutor<Location>{
    boolean existsByFullAddress(String address);
    Optional<Location> findByQrToken(String token);
}