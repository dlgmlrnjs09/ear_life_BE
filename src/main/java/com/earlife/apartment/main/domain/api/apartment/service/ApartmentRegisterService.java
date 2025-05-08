package com.earlife.apartment.main.domain.api.apartment.service;

import com.earlife.apartment.main.domain.api.apartment.entity.*;
import com.earlife.apartment.main.domain.api.apartment.repository.*;
import com.earlife.apartment.main.domain.common.utils.AddrUtil;
import com.earlife.apartment.main.external.api.dataportal.dto.*;
import com.earlife.apartment.main.external.api.dataportal.service.ApartmentRegisterApiService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Function;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class ApartmentRegisterService {
    private final ApartmentRegisterApiService apartmentRegisterApiService;
    private final ApartmentRegisterBasicRepository apartmentRegisterBasicRepository;
    private final ApartmentRegisterHeadRepository apartmentRegisterHeadRepository;
    private final ApartmentRegisterHeadGeneralRepository apartmentRegisterHeadGeneralRepository;
    private final ApartmentRegisterCommonAreaRepository apartmentRegisterCommonAreaRepository;
    private final ApartmentRegisterFloorRepository apartmentRegisterFloorRepository;

    public void deleteAll() {
        apartmentRegisterHeadGeneralRepository.deleteAll();
        apartmentRegisterCommonAreaRepository.deleteAll();
        apartmentRegisterFloorRepository.deleteAll();
        apartmentRegisterBasicRepository.deleteAll();
        apartmentRegisterHeadRepository.deleteAll();
    }

    public void insertApartmentRegisterBasic(ApartmentBasic reqEntity) {
        this.processApartmentDataWithUpsert(
                reqEntity,
                apartmentRegisterApiService::getAptRegisterBasicInfoList,
                ApartmentRegisterBasicDto::setKaptCode,
                ApartmentRegisterBasicDto::toEntity,
                this::upsertApartmentRegisterBasic
        );
    }

    public void insertApartmentRegisterHead(ApartmentBasic reqEntity) {
        this.processApartmentDataWithUpsert(
                reqEntity,
                apartmentRegisterApiService::getAptRegisterHeadInfoList,
                ApartmentRegisterHeadDto::setKaptCode,
                ApartmentRegisterHeadDto::toEntity,
                this::upsertApartmentRegisterHead
        );
    }

    public void insertApartmentRegisterCommonArea(ApartmentBasic reqEntity) {
        this.processApartmentDataWithUpsert(
                reqEntity,
                apartmentRegisterApiService::getAptRegisterCommonAreaInfoList,
                ApartmentRegisterCommonAreaDto::setKaptCode,
                ApartmentRegisterCommonAreaDto::toEntity,
                this::upsertApartmentRegisterCommonArea
        );
    }

    public void insertApartmentRegisterHeadGeneral(ApartmentBasic reqEntity) {
        this.processApartmentDataWithUpsert(
                reqEntity,
                apartmentRegisterApiService::getAptRegisterHeadGeneralList,
                ApartmentRegisterHeadGeneralDto::setKaptCode,
                ApartmentRegisterHeadGeneralDto::toEntity,
                this::upsertApartmentRegisterHeadGeneral
        );
    }

    public void insertApartmentRegisterFloor(ApartmentBasic reqEntity) {
        this.processApartmentDataWithUpsert(
                reqEntity,
                apartmentRegisterApiService::getAptRegisterFloorInfoList,
                ApartmentRegisterFloorDto::setKaptCode,
                ApartmentRegisterFloorDto::toEntity,
                this::upsertApartmentRegisterFloor
        );
    }

    private <T, E> void processApartmentDataWithUpsert(
            ApartmentBasic reqEntity,
            Function<ApartmentRegisterReqDto, List<T>> apiCallFunction,
            BiConsumer<T, String> kaptCodeSetter,
            Function<T, E> toEntityConverter,
            BiConsumer<E, Boolean> upsertFunction
    ) {
        String[] jibunParts = AddrUtil.extractJibunParts(reqEntity.getKaptAddr());
        ApartmentRegisterReqDto reqDto = this.createRegisterReqDto(jibunParts[1], jibunParts[0], reqEntity.getBjdCode());

        log.debug("시군구 + 법정동 = {}", reqEntity.getBjdCode());
        log.debug("시군구코드 = {}", reqDto.getSigunguCd());
        log.debug("법정동코드 = {}", reqDto.getBjdongCd());
        log.debug("주소 = {}", reqEntity.getKaptAddr());
        log.debug("주소 = {}", reqEntity.getDoroJuso());
        log.debug("변환된 지 / 번 = {} / {}", jibunParts[1], jibunParts[0]);

        List<T> resultList = apiCallFunction.apply(reqDto);

        resultList.forEach(dto -> {
            kaptCodeSetter.accept(dto, reqEntity.getKaptCode());
            E entity = toEntityConverter.apply(dto);

            // Check if entity exists and perform upsert
            upsertFunction.accept(entity, true);
        });
    }

    // Upsert methods for each entity type
    private void upsertApartmentRegisterBasic(ApartmentRegisterBasic entity, boolean checkExists) {
        Optional<ApartmentRegisterBasic> existingEntity = apartmentRegisterBasicRepository.findById(entity.getPk());

        if (existingEntity.isPresent()) {
            ApartmentRegisterBasic oldEntity = existingEntity.get();
            // Skip the pk to avoid overwriting it
            ApartmentRegisterPk originalPk = oldEntity.getPk();
            BeanUtils.copyProperties(entity, oldEntity);
            oldEntity.setPk(originalPk);
            apartmentRegisterBasicRepository.save(oldEntity);
            log.error("Updated ApartmentRegisterBasic with pk: {}", originalPk);
        } else {
            apartmentRegisterBasicRepository.save(entity);
            log.error("Inserted new ApartmentRegisterBasic with pk: {}", entity.getPk());
        }
    }

    private void upsertApartmentRegisterHead(ApartmentRegisterHead entity, boolean checkExists) {
        Optional<ApartmentRegisterHead> existingEntity = apartmentRegisterHeadRepository.findById(entity.getPk());

        if (existingEntity.isPresent()) {
            ApartmentRegisterHead oldEntity = existingEntity.get();
            // Skip the pk to avoid overwriting it
            ApartmentRegisterPk originalPk = oldEntity.getPk();
            BeanUtils.copyProperties(entity, oldEntity);
            oldEntity.setPk(originalPk);
            apartmentRegisterHeadRepository.save(oldEntity);
            log.debug("Updated ApartmentRegisterHead with pk: {}", originalPk);
        } else {
            apartmentRegisterHeadRepository.save(entity);
            log.debug("Inserted new ApartmentRegisterHead with pk: {}", entity.getPk());
        }
    }

    private void upsertApartmentRegisterCommonArea(ApartmentRegisterCommonArea entity, boolean checkExists) {
        Optional<ApartmentRegisterCommonArea> existingEntity = apartmentRegisterCommonAreaRepository.findById(entity.getPk());

        if (existingEntity.isPresent()) {
            ApartmentRegisterCommonArea oldEntity = existingEntity.get();
            // Skip the pk to avoid overwriting it
            ApartmentRegisterPk originalPk = oldEntity.getPk();
            BeanUtils.copyProperties(entity, oldEntity);
            oldEntity.setPk(originalPk);
            apartmentRegisterCommonAreaRepository.save(oldEntity);
            log.debug("Updated ApartmentRegisterCommonArea with pk: {}", originalPk);
        } else {
            apartmentRegisterCommonAreaRepository.save(entity);
            log.debug("Inserted new ApartmentRegisterCommonArea with pk: {}", entity.getPk());
        }
    }

    private void upsertApartmentRegisterHeadGeneral(ApartmentRegisterHeadGeneral entity, boolean checkExists) {
        Optional<ApartmentRegisterHeadGeneral> existingEntity = apartmentRegisterHeadGeneralRepository.findById(entity.getPk());

        if (existingEntity.isPresent()) {
            ApartmentRegisterHeadGeneral oldEntity = existingEntity.get();
            // Skip the pk to avoid overwriting it
            ApartmentRegisterPk originalPk = oldEntity.getPk();
            BeanUtils.copyProperties(entity, oldEntity);
            oldEntity.setPk(originalPk);
            apartmentRegisterHeadGeneralRepository.save(oldEntity);
            log.debug("Updated ApartmentRegisterHeadGeneral with pk: {}", originalPk);
        } else {
            apartmentRegisterHeadGeneralRepository.save(entity);
            log.debug("Inserted new ApartmentRegisterHeadGeneral with pk: {}", entity.getPk());
        }
    }

    private void upsertApartmentRegisterFloor(ApartmentRegisterFloor entity, boolean checkExists) {
        Optional<ApartmentRegisterFloor> existingEntity = apartmentRegisterFloorRepository.findById(entity.getPk());

        if (existingEntity.isPresent()) {
            ApartmentRegisterFloor oldEntity = existingEntity.get();
            // Skip the pk to avoid overwriting it
            ApartmentRegisterPk originalPk = oldEntity.getPk();
            BeanUtils.copyProperties(entity, oldEntity);
            oldEntity.setPk(originalPk);
            apartmentRegisterFloorRepository.save(oldEntity);
            log.debug("Updated ApartmentRegisterFloor with pk: {}", originalPk);
        } else {
            apartmentRegisterFloorRepository.save(entity);
            log.debug("Inserted new ApartmentRegisterFloor with pk: {}", entity.getPk());
        }
    }

    public ApartmentRegisterReqDto createRegisterReqDto(String ji, String bun, String bjdCode) {
        return ApartmentRegisterReqDto.builder()
                .ji(ji)
                .bun(bun)
                .sigunguCd(bjdCode.substring(0, 5))
                .bjdongCd(bjdCode.substring(5, 10))
                .pageNo("1")
                .numOfRows("100")
                .build();
    }
}