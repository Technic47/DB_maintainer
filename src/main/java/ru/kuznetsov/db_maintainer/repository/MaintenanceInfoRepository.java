package ru.kuznetsov.db_maintainer.repository;

import org.springframework.stereotype.Repository;
import ru.kuznetsov.db_maintainer.model.MaintenanceInfoEntity;

@Repository
public interface MaintenanceInfoRepository extends AbstractRepository<MaintenanceInfoEntity> {
}
