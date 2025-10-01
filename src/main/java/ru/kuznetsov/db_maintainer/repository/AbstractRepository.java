package ru.kuznetsov.db_maintainer.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import ru.kuznetsov.db_maintainer.model.AbstractEntity;

@NoRepositoryBean
public interface AbstractRepository<E extends AbstractEntity> extends CrudRepository<E, Long> {
}
