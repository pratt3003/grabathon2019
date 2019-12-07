package com.grabathon.booster.dto;

import com.grabathon.booster.model.Badge;
import com.grabathon.booster.model.BadgeType;
import lombok.Data;

import java.io.Serializable;

@Data
public class UpcomingBadgeDto implements Serializable {
    private Integer id;

    private String name;

    private float milestone;

    private String imageUrl;

    private BadgeType badgeType;

    private Float progress;

    public UpcomingBadgeDto(Badge badge)
    {
        this.id = badge.getId();
        this.name = badge.getName();
        this.milestone = badge.getMilestone();
        this.imageUrl = badge.getImageUrl();
        this.badgeType = badge.getBadgeType();
    }
}
