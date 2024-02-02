package com.example.quartz.service;

import com.example.quartz.dto.DistributingGroupBackupRequest;
import com.example.quartz.dtoMapper.DistributingGroupDtoMapper;
import com.example.quartz.entity.DistributingGroupBackup;
import com.example.quartz.repo.DistributingGroupBackupRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class DGService {
    private final DistributingGroupBackupRepository distributingGroupBackupRepository;

    public void createDistributingGroupBackup(DistributingGroupBackupRequest distributingGroupBackupRequest, String jobId){
        log.info("DGService::createDistributingGroupBackup():: started..");
        DistributingGroupBackup distributingGroupBackup = DistributingGroupDtoMapper.dtoToEntity(distributingGroupBackupRequest, jobId);
        distributingGroupBackupRepository.save(distributingGroupBackup);
        log.info("DGService::createDistributingGroupBackup():: ended..");
    }

    public void deleteAllDistributingGroupBackup(){
        log.info("DGService::deleteAllDistributingGroupBackup():: started..");
        distributingGroupBackupRepository.deleteAll();
        log.info("DGService::deleteAllDistributingGroupBackup():: ended..");
    }
}
