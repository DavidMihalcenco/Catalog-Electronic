package com.licenta.Licenta.repositories;

import com.licenta.Licenta.entities.Infrastructure;
import com.licenta.Licenta.entities.InfrastructuresImages;
import com.licenta.Licenta.entities.Offer;
import com.licenta.Licenta.entities.OffersImages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InfrastructureRepository extends JpaRepository<Infrastructure, Integer> {
    @Query("SELECT i FROM Infrastructure i WHERE i.user_id = :user_id AND i.private_status = true")
    List<Infrastructure> findByUser_idOwner(Integer user_id);

    @Query("SELECT i FROM Infrastructure i WHERE i.user_id = :user_id")
    List<Infrastructure> findByUser_id(Integer user_id);
    @Query("SELECT i FROM Infrastructure i WHERE i.infrastructure_name = :name")
    List<Infrastructure> findByName(String name);

    @Query("SELECT COUNT(i) FROM Infrastructure i WHERE i.private_status = true")
    long countByPrivate_status();

    @Query("SELECT i FROM Infrastructure i WHERE i.user_id = :user_id AND i.private_status = true")
    List<Infrastructure> findByUser_idDetails(Integer user_id);
}
