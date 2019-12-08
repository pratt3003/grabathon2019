package com.grabathon.booster.repository;

import com.grabathon.booster.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MerchantCouponBadgesMappingRepository extends JpaRepository<MerchantCouponBadgeMapping, Integer> {

    //@Query("select mcb from MerchantCouponBadgesMapping mcb where mcb.merchant in (?1) and mcb.badge in (?2) limit 10")
    List<MerchantCouponBadgeMapping> findByMerchantInAndBadgeIn(List<Merchant> vicinityMerchants, List<Badge> badges);
}
