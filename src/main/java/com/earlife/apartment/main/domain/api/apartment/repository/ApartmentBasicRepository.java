package com.earlife.apartment.main.domain.api.apartment.repository;

import com.earlife.apartment.main.domain.api.apartment.entity.ApartmentBasic;
import com.earlife.apartment.main.domain.api.apartment.entity.ApartmentDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApartmentBasicRepository extends JpaRepository<ApartmentBasic, String> {

}
