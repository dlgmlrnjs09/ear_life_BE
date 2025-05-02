package com.earlife.apartment.main.domain.api.apartment.service;

import com.earlife.apartment.main.domain.api.apartment.entity.ApartmentDetail;
import com.earlife.apartment.main.domain.api.apartment.entity.ApartmentMaster;
import com.earlife.apartment.main.domain.api.apartment.repository.ApartmentDetailRepository;
import com.earlife.apartment.main.domain.api.apartment.repository.ApartmentMasterRepository;
import com.earlife.apartment.main.external.api.dataportal.dto.ApartmentDto;
import com.earlife.apartment.main.external.api.dataportal.service.DataPortalApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ApartmentService {
    private final DataPortalApiService dataPortalApiService;
    private final ApartmentMasterRepository apartmentMasterRepository;
    private final ApartmentDetailRepository apartmentDetailRepository;

    public void insertAllApartment() {
        List<ApartmentMaster> entityList = dataPortalApiService.getAllAptList(1, 300).stream()
                .map(ApartmentDto::toEntity)
                .toList();

        apartmentMasterRepository.saveAll(entityList);
    }

    public void insertApartmentDetail() {
        ApartmentMaster masterEntity = apartmentMasterRepository.findById("A14002501").orElseThrow(RuntimeException::new);
        ApartmentDetail entity = dataPortalApiService.getAptDetail("A14002501").toEntity(masterEntity);

        apartmentDetailRepository.save(entity);
    }
}
