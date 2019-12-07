package com.grabathon.booster.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.grabathon.booster.factory.BadgeTypeFactory;
import com.grabathon.booster.model.Badge;
import com.grabathon.booster.model.BadgeType;
import com.grabathon.booster.model.User;
import com.grabathon.booster.model.UserBadge;
import com.grabathon.booster.repository.BadgeRepository;
import com.grabathon.booster.repository.BadgeTypeRepository;
import com.grabathon.booster.repository.UserBadgeRepository;
import com.grabathon.booster.repository.UserRepository;
import com.grabathon.booster.service.BadgeTypeStrategy;

@RestController
@RequestMapping("/user/badges/")
public class UserBadgeController {

  @Autowired
  private UserBadgeRepository userBadgeRepository;

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private BadgeTypeRepository badgeTypeRepository;

  @Autowired
  private BadgeTypeFactory badgeTypeFactory;

  @Autowired
  private BadgeRepository badgeRepository;

  @RequestMapping(value = "completed", method = RequestMethod.GET)
  @GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
  public List<Badge> getCompletedBadges(@RequestParam("user_id") Integer user_id) {
    User user = userRepository.findOne(user_id);
    List<UserBadge> userBadges = userBadgeRepository.findByUser(user);
    List<Badge> badgeList = new ArrayList<>();
    for (UserBadge userBadge : userBadges) {
      badgeList.add(userBadge.getBadge());
    }

    return badgeList;
  }

  public List<Badge> getUpcomingBadges(@RequestParam("user_id") Integer user_id,
      @RequestParam("page_number") Integer page_number) {
    User user = userRepository.findOne(user_id);
    List<UserBadge> userBadges = userBadgeRepository.findByUser(user);

    Pageable pageable = new PageRequest(0, 10);
    Page<BadgeType> badgeTypePage = badgeTypeRepository.findAll(pageable);
    List<BadgeType> badgeTypes = badgeTypePage.getContent();
    List<Badge> badgeList = new ArrayList<>();

    for (BadgeType badgeType : badgeTypes) {
      BadgeTypeStrategy badgeTypeStrategy = badgeTypeFactory
          .getBadgeTypeStrategy(badgeType.getName());
      Float limit = badgeTypeStrategy.getProgressForUser(user);
      badgeList.add(badgeRepository
          .findByBadgeTypeAndMilestoneGreaterThanOrderByMilestoneAsc(badgeType, limit));
    }

    return badgeList;
  }
}
