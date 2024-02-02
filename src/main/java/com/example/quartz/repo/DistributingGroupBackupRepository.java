package com.example.quartz.repo;

import com.example.quartz.entity.DistributingGroupBackup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DistributingGroupBackupRepository extends JpaRepository<DistributingGroupBackup, Long> {
}
