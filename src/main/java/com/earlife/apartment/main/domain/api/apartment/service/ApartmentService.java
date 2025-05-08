package com.earlife.apartment.main.domain.api.apartment.service;

import com.earlife.apartment.main.domain.api.apartment.entity.ApartmentBasic;
import com.earlife.apartment.main.domain.api.apartment.entity.ApartmentDetail;
import com.earlife.apartment.main.domain.api.apartment.entity.ApartmentMaster;
import com.earlife.apartment.main.domain.api.apartment.repository.ApartmentBasicRepository;
import com.earlife.apartment.main.domain.api.apartment.repository.ApartmentDetailRepository;
import com.earlife.apartment.main.domain.api.apartment.repository.ApartmentMasterRepository;
import com.earlife.apartment.main.external.api.dataportal.dto.ApartmentMasterDto;
import com.earlife.apartment.main.external.api.dataportal.service.ApartmentInfoApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ApartmentService {
    private final ApartmentInfoApiService apartmentInfoApiService;
    private final ApartmentMasterRepository apartmentMasterRepository;
    private final ApartmentDetailRepository apartmentDetailRepository;
    private final ApartmentBasicRepository apartmentBasicRepository;

    public List<ApartmentMasterDto> getAllApartmentMasters(int pageNo, int pageSize) {
        return apartmentInfoApiService.getAllAptList(pageNo, pageSize).stream().toList();
    }

    public ApartmentMaster insertApartmentMaster(ApartmentMaster apartmentMaster) {
        apartmentMasterRepository.save(apartmentMaster);
        return apartmentMaster;
    }

    public ApartmentBasic insertApartmentBasic(ApartmentMaster apartmentMaster) {
        ApartmentBasic returnEntity;

        boolean isExist = apartmentBasicRepository.existsById(apartmentMaster.getKaptCode());
        if (isExist) {
            ApartmentBasic oldEntity = apartmentBasicRepository.findById(apartmentMaster.getKaptCode()).orElseThrow();
            ApartmentBasic newEntity = apartmentInfoApiService.getAptBasic(apartmentMaster.getKaptCode()).toEntity();
            BeanUtils.copyProperties(newEntity, oldEntity);
            returnEntity = oldEntity;
            apartmentBasicRepository.save(oldEntity);
        } else {
            ApartmentBasic newEntity = apartmentInfoApiService.getAptBasic(apartmentMaster.getKaptCode()).toEntity();
            returnEntity = newEntity;
            apartmentBasicRepository.save(newEntity);
        }

        return returnEntity;
    }

    public ApartmentDetail insertApartmentDetail(ApartmentMaster apartmentMaster) {
        ApartmentDetail returnEntity;

        boolean isExist = apartmentDetailRepository.existsById(apartmentMaster.getKaptCode());
        if (isExist) {
            ApartmentDetail oldEntity = apartmentDetailRepository.findById(apartmentMaster.getKaptCode()).orElseThrow();
            ApartmentDetail newEntity = apartmentInfoApiService.getAptDetail(apartmentMaster.getKaptCode()).toEntity();
            BeanUtils.copyProperties(newEntity, oldEntity);
            returnEntity = oldEntity;
            apartmentDetailRepository.save(oldEntity);
        } else {
            ApartmentDetail newEntity = apartmentInfoApiService.getAptDetail(apartmentMaster.getKaptCode()).toEntity();
            returnEntity = newEntity;
            apartmentDetailRepository.save(newEntity);
        }

        return returnEntity;
    }

    public void deleteAll() {
        apartmentBasicRepository.deleteAll();
        apartmentDetailRepository.deleteAll();
        apartmentMasterRepository.deleteAll();
    }
}
