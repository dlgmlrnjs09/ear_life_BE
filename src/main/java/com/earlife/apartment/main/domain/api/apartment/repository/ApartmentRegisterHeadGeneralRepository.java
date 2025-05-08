package com.earlife.apartment.main.domain.api.apartment.repository;

import com.earlife.apartment.main.domain.api.apartment.entity.ApartmentRegisterHead;
import com.earlife.apartment.main.domain.api.apartment.entity.ApartmentRegisterHeadGeneral;
import com.earlife.apartment.main.domain.api.apartment.entity.ApartmentRegisterPk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApartmentRegisterHeadGeneralRepository extends JpaRepository<ApartmentRegisterHeadGeneral, ApartmentRegisterPk> {
}
