package com.earlife.apartment.main.domain.api.apartment.repository;

import com.earlife.apartment.main.domain.api.apartment.entity.ApartmentMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApartmentMasterRepository extends JpaRepository<ApartmentMaster, String> {

}
