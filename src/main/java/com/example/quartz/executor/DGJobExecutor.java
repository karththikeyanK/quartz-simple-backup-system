package com.example.quartz.executor;


import com.example.quartz.dto.DistributingGroupBackupRequest;
import com.example.quartz.dto.DistributingGroupBackupResponse;
import com.example.quartz.dtoMapper.DistributingGroupDtoMapper;
import com.example.quartz.entity.DistributingGroupBackup;
import com.example.quartz.facade.CreateDGBackupFacade;
import com.example.quartz.repo.DistributingGroupBackupRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
@Slf4j
@RequiredArgsConstructor
public class DGJobExecutor implements Job {

   private final CreateDGBackupFacade createDGBackupFacade;
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        log.info("DGJobExecutor::execute():: started..");
        JobDataMap jobDataMap = jobExecutionContext.getMergedJobDataMap();
        jobDataMap.remove("backupList");
        log.info("DGJobExecutor::execute():: backupList removed..");
        String jobId = (String) jobDataMap.get("jobID");
        log.info("Job Started-" + jobId + " at:" + new Date());
        List<DistributingGroupBackupRequest> distributingGroupBackupRequestList = DistributingGroupDtoMapper.getAllDistributingGroups();
      log.info("DGJobExecutor::execute():: DistributingGroupBackupRequestList:: {}",distributingGroupBackupRequestList.toString());
        if (Objects.nonNull(distributingGroupBackupRequestList) && !distributingGroupBackupRequestList.isEmpty()) {
          createDGBackupFacade.createDGBackup(distributingGroupBackupRequestList, jobId);
        }
        jobDataMap.put("backupList", distributingGroupBackupRequestList);
        log.info("DGJobExecutor::execute():: backupList added at Time {}..", new Date());
        log.info("DGJobExecutor::execute():: ended..");
    }


}
