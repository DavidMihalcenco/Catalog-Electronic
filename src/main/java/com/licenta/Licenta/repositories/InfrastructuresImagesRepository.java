package com.licenta.Licenta.repositories;

import com.licenta.Licenta.entities.InfrastructuresImages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InfrastructuresImagesRepository extends JpaRepository<InfrastructuresImages, Integer> {
    @Query("SELECT i FROM InfrastructuresImages i WHERE i.infrastructure_id = :infrastructure_id")
    Optional<InfrastructuresImages> findByInfrastructureId(Integer infrastructure_id);
}
