package com.example.quartz.scheduler;

import com.example.quartz.executor.DGJobExecutor;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;


import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

@Slf4j
@Configuration
@EnableScheduling
public class MyScheduler {

    @Autowired
    private Scheduler scheduler;

    @Autowired
    private DGJobExecutor dgJobExecutor;

    @PostConstruct
    public void scheduleJobs() throws SchedulerException {
        log.info("MyScheduler::scheduleJobs():: started..");

        JobDetail job = newJob(DGJobExecutor.class)
                .withIdentity("DGBackup", "group1")
                .usingJobData("jobID", "DGBackupJob")
                .build();

        Trigger trigger = newTrigger()
                .withIdentity("myTrigger", "group1")
                .startNow()
                .withSchedule(simpleSchedule()
                        .withIntervalInMinutes(1)
                        .repeatForever())
                .build();

        scheduler.scheduleJob(job, trigger);
        scheduler.start();

        log.info("MyScheduler::scheduleJobs():: ended..");
    }
}

