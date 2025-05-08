package com.earlife.apartment.main.external.api.dataportal.dto;

import com.earlife.apartment.main.domain.api.apartment.entity.ApartmentRegisterFloor;
import com.earlife.apartment.main.domain.api.apartment.entity.ApartmentRegisterPk;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class ApartmentRegisterFloorDto {
    private String kaptCode;
    private String rnum;
    private String platPlc;
    private String sigunguCd;
    private String bjdongCd;
    private String platGbCd;
    private String bun;
    private String ji;
    private String mgmBldrgstPk;
    private String newPlatPlc;
    private String bldNm;
    private String splotNm;
    private String block;
    private String lot;
    private String naRoadCd;
    private String naBjdongCd;
    private String naUgrndCd;
    private String naMainBun;
    private String naSubBun;
    private String dongNm;
    private String flrGbCd;
    private String flrGbCdNm;
    private String flrNo;
    private String flrNoNm;
    private String strctCd;
    private String strctCdNm;
    private String etcStrct;
    private String mainPurpsCd;
    private String mainPurpsCdNm;
    private String etcPurps;
    private String mainAtchGbCd;
    private String mainAtchGbCdNm;
    private String area;
    private String areaExctYn;
    private String crtnDay;

    public ApartmentRegisterFloor toEntity() {
        return ApartmentRegisterFloor.builder()
                .rnum(this.rnum)
                .platPlc(this.platPlc)
                .sigunguCd(this.sigunguCd)
                .bjdongCd(this.bjdongCd)
                .platGbCd(this.platGbCd)
                .bun(this.bun)
                .ji(this.ji)
                .newPlatPlc(this.newPlatPlc)
                .bldNm(this.bldNm)
                .splotNm(this.splotNm)
                .block(this.block)
                .lot(this.lot)
                .naRoadCd(this.naRoadCd)
                .naBjdongCd(this.naBjdongCd)
                .naUgrndCd(this.naUgrndCd)
                .naMainBun(this.naMainBun)
                .naSubBun(this.naSubBun)
                .dongNm(this.dongNm)
                .flrGbCd(this.flrGbCd)
                .flrGbCdNm(this.flrGbCdNm)
                .flrNo(this.flrNo)
                .flrNoNm(this.flrNoNm)
                .strctCd(this.strctCd)
                .strctCdNm(this.strctCdNm)
                .etcStrct(this.etcStrct)
                .mainPurpsCd(this.mainPurpsCd)
                .mainPurpsCdNm(this.mainPurpsCdNm)
                .etcPurps(this.etcPurps)
                .mainAtchGbCd(this.mainAtchGbCd)
                .mainAtchGbCdNm(this.mainAtchGbCdNm)
                .area(this.area)
                .areaExctYn(this.areaExctYn)
                .crtnDay(this.crtnDay)
                .pk(ApartmentRegisterPk.builder()
                        .mgmBldrgstPk(this.mgmBldrgstPk)
                        .kaptCode(this.kaptCode)
                        .build())
                .build();
    }
}