package com.earlife.apartment.main.domain.api.apartment.service;

import com.earlife.apartment.main.domain.api.apartment.entity.ApartmentBasic;
import com.earlife.apartment.main.domain.api.apartment.entity.ApartmentDetail;
import com.earlife.apartment.main.domain.api.apartment.entity.ApartmentMaster;
import com.earlife.apartment.main.domain.api.apartment.repository.ApartmentBasicRepository;
import com.earlife.apartment.main.domain.api.apartment.repository.ApartmentDetailRepository;
import com.earlife.apartment.main.domain.api.apartment.repository.ApartmentMasterRepository;
import com.earlife.apartment.main.external.api.dataportal.dto.ApartmentMasterDto;
import com.earlife.apartment.main.external.api.dataportal.service.DataPortalApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ApartmentService {
    private final DataPortalApiService dataPortalApiService;
    private final ApartmentMasterRepository apartmentMasterRepository;
    private final ApartmentDetailRepository apartmentDetailRepository;
    private final ApartmentBasicRepository apartmentBasicRepository;

    public void insertAllApartment() {
        List<ApartmentMaster> entityList = dataPortalApiService.getAllAptList(1, 300).stream()
                .map(ApartmentMasterDto::toEntity)
                .toList();

        apartmentMasterRepository.saveAll(entityList);
    }

    public void insertApartmentBasic() {
//        ApartmentMaster masterEntity = apartmentMasterRepository.findById("A14002501").orElseThrow(RuntimeException::new);
//        ApartmentBasic entity = dataPortalApiService.getAptBasic("A14002501").toEntity(masterEntity);
//
//        apartmentBasicRepository.save(entity);
    }

    public void insertAllApartmentBasic() {
        List<ApartmentMaster> apartmentMasterList = apartmentMasterRepository.findAll();
        apartmentMasterList.forEach(a -> {
            boolean isExist = apartmentBasicRepository.existsById(a.getKaptCode());
            if (isExist) {
                ApartmentBasic oldEntity = apartmentBasicRepository.findById(a.getKaptCode()).orElseThrow();
                ApartmentBasic newEntity = dataPortalApiService.getAptBasic(a.getKaptCode()).toEntity(a);
                BeanUtils.copyProperties(newEntity, oldEntity);
                apartmentBasicRepository.save(oldEntity);
            } else {
                ApartmentBasic newEntity = dataPortalApiService.getAptBasic(a.getKaptCode()).toEntity(a);
                apartmentBasicRepository.save(newEntity);
            }
        });
    }

    public void insertApartmentDetail() {
//        ApartmentMaster masterEntity = apartmentMasterRepository.findById("A14002501").orElseThrow(RuntimeException::new);
//        ApartmentDetail entity = dataPortalApiService.getAptDetail("A14002501").toEntity(masterEntity);
//
//        apartmentDetailRepository.save(entity);
    }

    public void insertAllApartmentDetail() {
        List<ApartmentMaster> apartmentMasterList = apartmentMasterRepository.findAll();
        apartmentMasterList.forEach(a -> {
            boolean isExist = apartmentDetailRepository.existsById(a.getKaptCode());
            if (isExist) {
                ApartmentDetail oldEntity = apartmentDetailRepository.findById(a.getKaptCode()).orElseThrow();
                ApartmentDetail newEntity = dataPortalApiService.getAptDetail(a.getKaptCode()).toEntity(a);
                BeanUtils.copyProperties(newEntity, oldEntity);
                apartmentDetailRepository.save(oldEntity);
            } else {
                ApartmentDetail newEntity = dataPortalApiService.getAptDetail(a.getKaptCode()).toEntity(a);
                apartmentDetailRepository.save(newEntity);
            }
        });
    }
}
