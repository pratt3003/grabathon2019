package com.grabathon.booster.controller;

import com.grabathon.booster.model.Badge;
import com.grabathon.booster.model.BadgeType;
import com.grabathon.booster.model.User;
import com.grabathon.booster.model.UserBadge;
import com.grabathon.booster.repository.BadgeTypeRepository;
import com.grabathon.booster.repository.UserBadgeRepository;
import com.grabathon.booster.repository.UserRepository;
import javafx.print.PageRange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user/badges/")
public class UserBadgeController {

    @Autowired
    private UserBadgeRepository userBadgeRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BadgeTypeRepository badgeTypeRepository;

    @RequestMapping(value = "completed", method = RequestMethod.GET)
    @GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
    public List<Badge> getCompletedBadges(@RequestParam("user_id") Integer user_id)
    {
        User user = userRepository.findOne(user_id);
        List<UserBadge> userBadges = userBadgeRepository.findByUser(user);
        List<Badge> badgeList = new ArrayList<>();
        for (UserBadge userBadge:
             userBadges) {
            badgeList.add(userBadge.getBadge());
        }

        return badgeList;
    }

    public List<Badge> getUpcomingBadges(
            @RequestParam("user_id") Integer user_id,
            @RequestParam("page_number") Integer page_number
    ) {
        User user = userRepository.findOne(user_id);
        List<UserBadge> userBadges = userBadgeRepository.findByUser(user);

        Pageable pageable = new PageRequest(0, 10);
        Page<BadgeType> badgeTypePage = badgeTypeRepository.findAll(pageable);
        List<BadgeType> badgeTypes = badgeTypePage.getContent();

        for (BadgeType badgeType:
             badgeTypes) {

        }
    }
}
