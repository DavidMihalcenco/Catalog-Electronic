package com.licenta.Licenta.repositories;

import com.licenta.Licenta.entities.Infrastructure;
import com.licenta.Licenta.entities.Offer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OfferRepository extends JpaRepository<Offer, Integer> {
    @Query("SELECT i FROM Offer i WHERE i.user_id = :user_id AND i.private_status = true")
    List<Offer> findByUser_idOwner(Integer user_id);

    @Query("SELECT i FROM Offer i WHERE i.user_id = :user_id")
    List<Offer> findByUser_id(Integer user_id);
    @Query("SELECT i FROM Offer i WHERE i.offer_name = :name")
    List<Offer> findByName(String name);

    @Query("SELECT COUNT(i) FROM Offer i WHERE i.private_status = true")
    long countByPrivate_status();

    @Query("SELECT i FROM Offer i WHERE i.user_id = :user_id AND i.private_status = true")
    List<Offer> findByUser_idDetails(Integer user_id);
}
