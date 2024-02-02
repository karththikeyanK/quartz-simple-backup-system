package com.example.quartz.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DistributingGroupResponse {
    private Long id;
    private String name;
    private String notes;
    private Long supervisorId;
    private Long subRegionId;
    private Long distributorRefID;
    private Long baseSubRegionId;
}
