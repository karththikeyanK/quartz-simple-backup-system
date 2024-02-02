package com.example.quartz.facade;

import com.example.quartz.dto.DistributingGroupBackupRequest;
import com.example.quartz.service.DGService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@Slf4j
@RequiredArgsConstructor
public class createDGBackupFacade {

    private final DGService dgService;

    @Transactional
    public void createDGBackup(List<DistributingGroupBackupRequest> distributingGroupBackupRequestList, String jobId){
        log.info("createDGBackupFacade::createDGBackup():: started..");
        if (Objects.equals(jobId, "DGBackupJob")){
            log.info("createDGBackupFacade::createDGBackup():: creating DG Backup with job id {} ",jobId);
            dgService.deleteAllDistributingGroupBackup();
            log.info("createDGBackupFacade::createDGBackup():: Old DG Backup deleted with job id {} ",jobId);

            for (DistributingGroupBackupRequest distributingGroupBackupRequest : distributingGroupBackupRequestList){
                dgService.createDistributingGroupBackup(distributingGroupBackupRequest, jobId);
            }
            log.info("createDGBackupFacade::createDGBackup():: New DG Backup created with job id {} ",jobId);
        }
        log.info("createDGBackupFacade::createDGBackup():: ended..");
    }
}
