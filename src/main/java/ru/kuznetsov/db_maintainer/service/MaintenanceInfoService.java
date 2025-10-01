package ru.kuznetsov.db_maintainer.service;

import org.springframework.stereotype.Service;
import ru.kuznetsov.db_maintainer.model.MaintenanceInfoEntity;
import ru.kuznetsov.db_maintainer.repository.MaintenanceInfoRepository;

@Service
public class MaintenanceInfoService extends AbstractService<MaintenanceInfoEntity, MaintenanceInfoRepository> {
    protected MaintenanceInfoService(MaintenanceInfoRepository repository) {
        super(repository);
    }
}
