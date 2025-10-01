package ru.kuznetsov.db_maintainer.service;

import org.springframework.stereotype.Service;
import ru.kuznetsov.db_maintainer.model.CommentEntity;
import ru.kuznetsov.db_maintainer.repository.CommentRepository;

import java.util.List;

@Service
public class CommentService extends AbstractService<CommentEntity, CommentRepository> {

    protected CommentService(CommentRepository repository) {
        super(repository);
    }

    public long count() {
        return repository.count();
    }

    public List<Long> findOverLimitIds(Integer limit) {
        return repository.findOverLimitIds(limit);
    }
}
