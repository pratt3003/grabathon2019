package com.grabathon.booster.service;

import com.grabathon.booster.dto.BaseDto;
import com.grabathon.booster.exception.ResourceNotFoundException;

import javax.transaction.Transactional;
import java.io.Serializable;

public interface BaseService<E, D extends BaseDto, I extends Serializable> {

    D get(I id) throws ResourceNotFoundException;

    @Transactional
    D create(D dto);

    @Transactional
    D update(D dto);

    @Transactional
    void delete(I id);

    Class<D> getDTOClass();
}
