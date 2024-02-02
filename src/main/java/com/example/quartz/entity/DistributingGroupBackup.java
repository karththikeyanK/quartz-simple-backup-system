package com.example.quartz.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Builder
@Table(name = "distributing_groups_bacukup_table")
public class DistributingGroupBackup {
    @Id
    private Long id;

    @Column(name ="job_id")
    private String jobId;

    @Column(name = "name")
    private String name;

    @Column(name = "notes")
    private String notes;

    @Column(name = "supervisor_id")
    private Long supervisorId;

    @Column(name = "sub_region_id")
    private Long subRegionId;

    @Column(name = "distributor_ref_id")
    private Long distributorRefID;

    @Column(name = "base_sub_region_id")
    private Long baseSubRegionId;

    @Column(name = "backup_date")
    private LocalDateTime backupDate;

    @PrePersist
    public void prePersist() {
        backupDate = LocalDateTime.now();
    }
}

