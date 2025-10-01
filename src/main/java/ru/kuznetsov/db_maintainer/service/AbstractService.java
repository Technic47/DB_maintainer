package ru.kuznetsov.db_maintainer.service;

import ru.kuznetsov.db_maintainer.model.AbstractEntity;
import ru.kuznetsov.db_maintainer.repository.AbstractRepository;

import java.util.List;

public abstract class AbstractService<E extends AbstractEntity, R extends AbstractRepository<E>> {

    protected final R repository;

    protected AbstractService(R repository) {
        this.repository = repository;
    }

    public E save(E entity) {
        return repository.save(entity);
    }

    public E findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Iterable<E> findAll() {
        return repository.findAll();
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public void deleteAllByIds(List<Long> ids) {
        repository.deleteAllById(ids);
    }
}
