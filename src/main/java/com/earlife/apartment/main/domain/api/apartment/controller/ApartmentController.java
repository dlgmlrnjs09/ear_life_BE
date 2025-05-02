package com.earlife.apartment.main.domain.api.apartment.controller;

import com.earlife.apartment.main.domain.api.apartment.service.ApartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/apartment")
@RequiredArgsConstructor
public class ApartmentController {
    private final ApartmentService apartmentService;

    @GetMapping("/list")
    public void insertAllApartment() {
        apartmentService.insertAllApartment();
    }

    @GetMapping("/detail")
    public void insertApartmentDetail() {
        apartmentService.insertApartmentDetail();
    }
}
