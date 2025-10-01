package ru.kuznetsov.db_maintainer.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.kuznetsov.db_maintainer.model.CommentEntity;

import java.util.List;

@Repository
public interface CommentRepository extends AbstractRepository<CommentEntity> {

    @Query(nativeQuery = true, value = "select id from comment order by publish_date desc offset :limit")
    List<Long> findOverLimitIds(@Param("limit") Integer limit);
}
