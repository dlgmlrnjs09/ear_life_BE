package com.earlife.apartment.main.domain.api.apartment.facade;

import com.earlife.apartment.main.domain.api.apartment.entity.ApartmentBasic;
import com.earlife.apartment.main.domain.api.apartment.entity.ApartmentDetail;
import com.earlife.apartment.main.domain.api.apartment.entity.ApartmentMaster;
import com.earlife.apartment.main.domain.api.apartment.service.ApartmentRegisterService;
import com.earlife.apartment.main.domain.api.apartment.service.ApartmentService;
import com.earlife.apartment.main.external.api.dataportal.dto.ApartmentBasicDto;
import com.earlife.apartment.main.external.api.dataportal.dto.ApartmentDetailDto;
import com.earlife.apartment.main.external.api.dataportal.dto.ApartmentMasterDto;
import jakarta.transaction.Transactional;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class ApartmentFacade {
    private final ApartmentService apartmentService;
    private final ApartmentRegisterService apartmentRegisterService;

    @Transactional
    public void insertTotalApartmentsInfo() {
        List<ApartmentMasterDto> dtoList = apartmentService.getAllApartmentMasters(1, 50);
        dtoList.forEach(apartmentMasterDto -> {
            ApartmentMaster entity = apartmentMasterDto.toEntity();
            ApartmentInfoResponse insertedApartmentRes = this.insertApartmentInfos(entity);
            this.insertTotalApartmentRegister(insertedApartmentRes.getBasic());
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }


    @Transactional
    public void deleteAll() {
        apartmentService.deleteAll();
        apartmentRegisterService.deleteAll();
    }

//    @Transactional
    public ApartmentInfoResponse insertApartmentInfos(ApartmentMaster paramEntity) {
        ApartmentMaster m = apartmentService.insertApartmentMaster(paramEntity);
        ApartmentBasic b = apartmentService.insertApartmentBasic(paramEntity);
        ApartmentDetail d = apartmentService.insertApartmentDetail(paramEntity);

        return ApartmentInfoResponse.builder()
                .master(m)
                .basic(b)
                .detail(d)
                .build();
    }

//    @Transactional
    public void insertTotalApartmentRegister(ApartmentBasic paramEntity) {
        apartmentRegisterService.insertApartmentRegisterBasic(paramEntity);
        apartmentRegisterService.insertApartmentRegisterHead(paramEntity);
        apartmentRegisterService.insertApartmentRegisterHeadGeneral(paramEntity);
        apartmentRegisterService.insertApartmentRegisterCommonArea(paramEntity);
        apartmentRegisterService.insertApartmentRegisterFloor(paramEntity);
    }

    @Builder
    @Setter
    @Getter
    public static class ApartmentInfoResponse {
        private ApartmentMaster master;
        private ApartmentBasic basic;
        private ApartmentDetail detail;
    }
}
