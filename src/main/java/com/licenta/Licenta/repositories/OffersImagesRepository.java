package com.licenta.Licenta.repositories;

import com.licenta.Licenta.entities.OffersImages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OffersImagesRepository extends JpaRepository<OffersImages, Integer> {
    @Query("SELECT j FROM OffersImages j WHERE j.offer_id = :offer_id")
    Optional<OffersImages> findByOfferId(Integer offer_id);
}
