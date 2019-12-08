package com.grabathon.booster.repository;

import com.grabathon.booster.model.Merchant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MerchantRepository extends JpaRepository<Merchant, Integer> {
    @Query("SELECT m FROM Merchant m WHERE 111.045 * DEGREES(ACOS(COS(RADIANS(?1))\n" +
            " * COS(RADIANS(m.latitude))\n" +
            " * COS(RADIANS(m.longitude) - RADIANS(?2))\n" +
            " + SIN(RADIANS(?1))\n" +
            " * SIN(RADIANS(m.latitude)))) <= 5")
    List<Merchant> findVicinityMerchants(Float latitude, Float longitude);
}
