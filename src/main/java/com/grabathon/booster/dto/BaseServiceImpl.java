package com.grabathon.booster.dto;

import com.grabathon.booster.exception.ResourceNotFoundException;
import com.grabathon.booster.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.io.Serializable;

public abstract class BaseServiceImpl<E, D extends BaseDto<E, D>, I extends Serializable> implements BaseService<E, D, I> {

    @Autowired
    private JpaRepository<E, I> repository;

    public JpaRepository<E, I> getRepository() {
        return repository;
    }

    @Override
    public D get(I id) throws ResourceNotFoundException {
        E entity = repository.findOne(id);

        // if entity is not found, throw exception
        if (entity == null) {
            throw new ResourceNotFoundException();
        }

        try {
            D dto = getDTOClass().newInstance();
            dto.mergeEntity(entity);
            return dto;
        } catch (InstantiationException | IllegalAccessException ex) {
            throw new ResourceNotFoundException();
        }
    }

    @Override
    @Transactional
    public D create(D dto) {
        E entity = dto.getEntity();
        entity = repository.save(entity);
        dto.mergeEntity(entity);
        return dto;
    }

    @Override
    @Transactional
    public D update(D dto) {
        E entity = dto.getEntity();
        entity = repository.save(entity);
        dto.mergeEntity(entity);
        return dto;
    }

    @Override
    public void delete(I id) {
        repository.delete(id);
    }
}
