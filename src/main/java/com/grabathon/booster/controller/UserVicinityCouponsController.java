package com.grabathon.booster.controller;

import com.grabathon.booster.model.*;
import com.grabathon.booster.repository.MerchantCouponBadgesMappingRepository;
import com.grabathon.booster.repository.MerchantRepository;
import com.grabathon.booster.repository.UserBadgeRepository;
import com.grabathon.booster.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserVicinityCouponsController {

    @Autowired
    private MerchantRepository merchantRepository;

    @Autowired
    private UserBadgeRepository userBadgeRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MerchantCouponBadgesMappingRepository merchantCouponBadgesMappingRepository;

    @RequestMapping(value = "/user/vicinity/offers", method = RequestMethod.GET)
    @GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
    public List<MerchantCouponBadgeMapping> getUserVicinityOffers(
            @RequestParam("user_id") Integer user_id,
            @RequestParam("latitude") Float latitude,
            @RequestParam("longitude") Float longitude
    ) {
        List<Merchant> vicinityMerchants = merchantRepository.findVicinityMerchants(latitude, longitude);
        User user = userRepository.findOne(user_id);
        List<UserBadge> userBadges = userBadgeRepository.findByUser(user);
        List<Badge> badges = new ArrayList<>();
        for (UserBadge userBadge :
                userBadges) {
            badges.add(userBadge.getBadge());
        }

        return merchantCouponBadgesMappingRepository.findByMerchantInAndBadgeIn(vicinityMerchants, badges);
    }
}
