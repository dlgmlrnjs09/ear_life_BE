package com.earlife.apartment.main.domain.api.apartment.repository;

import com.earlife.apartment.main.domain.api.apartment.entity.ApartmentMaster;
import com.earlife.apartment.main.domain.api.apartment.entity.ApartmentRegisterBasic;
import com.earlife.apartment.main.domain.api.apartment.entity.ApartmentRegisterPk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApartmentRegisterBasicRepository extends JpaRepository<ApartmentRegisterBasic, ApartmentRegisterPk> {
}
