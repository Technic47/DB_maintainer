package ru.kuznetsov.db_maintainer.scheduler;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import ru.kuznetsov.db_maintainer.model.MaintenanceInfoEntity;
import ru.kuznetsov.db_maintainer.service.CommentService;
import ru.kuznetsov.db_maintainer.service.MaintenanceInfoService;

import java.util.Date;
import java.util.List;

@Component
@RequiredArgsConstructor
public class MaintainerScheduler {

    @Value("${comment.count.max:100}")
    private Integer MAX_COUNT_VALUE;
    private final CommentService commentService;
    private final MaintenanceInfoService maintenanceInfoService;

    Logger logger = LoggerFactory.getLogger(MaintainerScheduler.class);

    @Scheduled(cron = "${maintainer.rate.cron:0 0 0 * * *}")
    public void run() {
        logger.info("CleanUp procedure started");

        if (commentService.count() > MAX_COUNT_VALUE) {
            List<Long> overLimitIds = commentService.findOverLimitIds(MAX_COUNT_VALUE);
            logger.info("Found {} ids over db limit", overLimitIds.size());
            commentService.deleteAllByIds(overLimitIds);
            maintenanceInfoService.save(new MaintenanceInfoEntity(MAX_COUNT_VALUE, overLimitIds.size(), new Date()));
        }

        logger.info("CleanUp procedure finished");
    }
}
