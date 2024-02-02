package com.example.quartz.dtoMapper;

import com.example.quartz.dto.DistributingGroupBackupRequest;
import com.example.quartz.dto.DistributingGroupBackupResponse;
import com.example.quartz.entity.DistributingGroupBackup;
import com.example.quartz.exception.HttpStatusCodeException;
import com.example.quartz.response.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Slf4j
public class DistributingGroupDtoMapper {
    public static DistributingGroupBackup dtoToEntity(DistributingGroupBackupRequest distributingGroupBackupRequest, String jobId) {
        return DistributingGroupBackup.builder()
                .id(distributingGroupBackupRequest.getId())
                .jobId(jobId)
                .name(distributingGroupBackupRequest.getName())
                .notes(distributingGroupBackupRequest.getNotes())
                .supervisorId(distributingGroupBackupRequest.getSupervisorId())
                .subRegionId(distributingGroupBackupRequest.getSubRegionId())
                .distributorRefID(distributingGroupBackupRequest.getDistributorRefID())
                .baseSubRegionId(distributingGroupBackupRequest.getBaseSubRegionId())
                .build();
    }

    public static DistributingGroupBackupResponse entityToDto(DistributingGroupBackup distributingGroupBackup) {
        return DistributingGroupBackupResponse.builder()
                .id(distributingGroupBackup.getId())
                .jobId(distributingGroupBackup.getJobId())
                .name(distributingGroupBackup.getName())
                .notes(distributingGroupBackup.getNotes())
                .supervisorId(distributingGroupBackup.getSupervisorId())
                .subRegionId(distributingGroupBackup.getSubRegionId())
                .distributorRefID(distributingGroupBackup.getDistributorRefID())
                .baseSubRegionId(distributingGroupBackup.getBaseSubRegionId())
                .build();
    }

    @Value("${routing.endpoints.getAllDG.url}")
    private static String GET_ALL_DG_URL;

    public static List<DistributingGroupBackupRequest> getAllDistributingGroups() throws RestClientException {
        log.info("JobDtoMapper::Calling API to get optimized route");
        RestTemplate restTemplate = new RestTemplate();
        String apiUrl = "http://localhost:8080/api/v1/distributorGroup/getAllDistributorGroups";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Void> requestEntity = new HttpEntity<>(null, headers);

        ResponseEntity<ApiResponse<List<DistributingGroupBackupRequest>>> responseEntity = restTemplate.exchange(
                apiUrl, HttpMethod.GET, requestEntity, new ParameterizedTypeReference<ApiResponse<List<DistributingGroupBackupRequest>>>() {
                });

        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            ApiResponse<List<DistributingGroupBackupRequest>> response = responseEntity.getBody();
            if (response != null && response.getMsg() != null && response.getData() != null) {
                log.info("DistributingGroupDtoMapper::API call returned a 2xx response");
                return response.getData();
            } else {

                log.error("DistributingGroupDtoMapper::API call returned an unexpected response structure");
                throw new RuntimeException("Unexpected response structure from the API");
            }
        } else {
            log.error("DistributingGroupDtoMapper::API call returned a non-2xx status code: {}", responseEntity.getStatusCodeValue());
            throw new HttpStatusCodeException("API call returned a non-2xx status code") {
            };
        }

    }

}
