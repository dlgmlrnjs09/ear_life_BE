package com.earlife.apartment.main.external.api.dataportal.dto;

import com.earlife.apartment.main.domain.api.apartment.entity.ApartmentRegisterCommonArea;
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
public class ApartmentRegisterCommonAreaDto {
    private String kaptCode;
    private String rnum;
    private String platPlc;
    private String sigunguCd;
    private String bjdongCd;
    private String platGbCd;
    private String bun;
    private String ji;
    private String mgmBldrgstPk;
    private String regstrGbCd;
    private String regstrGbCdNm;
    private String regstrKindCd;
    private String regstrKindCdNm;
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
    private String hoNm;
    private String flrGbCd;
    private String flrGbCdNm;
    private String flrNo;
    private String flrNoNm;
    private String exposPubuseGbCd;
    private String exposPubuseGbCdNm;
    private String mainAtchGbCd;
    private String mainAtchGbCdNm;
    private String strctCd;
    private String strctCdNm;
    private String etcStrct;
    private String mainPurpsCd;
    private String mainPurpsCdNm;
    private String etcPurps;
    private String area;
    private String crtnDay;

    public ApartmentRegisterCommonArea toEntity() {
        return ApartmentRegisterCommonArea.builder()
                .rnum(this.rnum)
                .platPlc(this.platPlc)
                .sigunguCd(this.sigunguCd)
                .bjdongCd(this.bjdongCd)
                .platGbCd(this.platGbCd)
                .bun(this.bun)
                .ji(this.ji)
                .regstrGbCd(this.regstrGbCd)
                .regstrGbCdNm(this.regstrGbCdNm)
                .regstrKindCd(this.regstrKindCd)
                .regstrKindCdNm(this.regstrKindCdNm)
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
                .hoNm(this.hoNm)
                .flrGbCd(this.flrGbCd)
                .flrGbCdNm(this.flrGbCdNm)
                .flrNo(this.flrNo)
                .flrNoNm(this.flrNoNm)
                .exposPubuseGbCd(this.exposPubuseGbCd)
                .exposPubuseGbCdNm(this.exposPubuseGbCdNm)
                .mainAtchGbCd(this.mainAtchGbCd)
                .mainAtchGbCdNm(this.mainAtchGbCdNm)
                .strctCd(this.strctCd)
                .strctCdNm(this.strctCdNm)
                .etcStrct(this.etcStrct)
                .mainPurpsCd(this.mainPurpsCd)
                .mainPurpsCdNm(this.mainPurpsCdNm)
                .etcPurps(this.etcPurps)
                .area(this.area)
                .crtnDay(this.crtnDay)
                .pk(ApartmentRegisterPk.builder()
                        .mgmBldrgstPk(this.mgmBldrgstPk)
                        .kaptCode(this.kaptCode)
                        .build())
                .build();
    }
}