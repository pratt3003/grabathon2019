package com.grabathon.booster.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;

public interface BaseDto<E, D> extends Serializable {

    @JsonIgnore
    E getEntity();

    void mergeEntity(E entity);
}
