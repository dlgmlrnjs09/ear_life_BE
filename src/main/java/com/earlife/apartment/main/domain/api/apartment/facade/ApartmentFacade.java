package com.earlife.apartment.main.domain.api.apartment.facade;

import com.earlife.apartment.main.domain.api.apartment.service.ApartmentService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class ApartmentFacade {
    private final ApartmentService apartmentService;

    @Transactional
    public void insertTotalApartmentsInfo() {
        apartmentService.insertAllApartment();
        apartmentService.insertAllApartmentBasic();
        apartmentService.insertAllApartmentDetail();
    }
}
