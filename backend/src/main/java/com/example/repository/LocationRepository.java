
package com.example.repository;

import com.example.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import java.util.Optional;

public interface LocationRepository
        extends JpaRepository<Location, Long>,
                JpaSpecificationExecutor<Location> {

    boolean existsByFullAddress(String address);

    Optional<Location> findByQrToken(String token);
}
