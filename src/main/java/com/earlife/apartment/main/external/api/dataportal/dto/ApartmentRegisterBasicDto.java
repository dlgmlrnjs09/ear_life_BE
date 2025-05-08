package com.earlife.apartment.main.external.api.dataportal.dto;

import com.earlife.apartment.main.domain.api.apartment.entity.ApartmentRegisterBasic;
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
public class ApartmentRegisterBasicDto {
    private String kaptCode;
    private String rnum;
    private String platPlc;
    private String sigunguCd;
    private String bjdongCd;
    private String platGbCd;
    private String bun;
    private String ji;
    private String mgmBldrgstPk;
    private String mgmUpBldrgstPk;
    private String bldgId;
    private String regstrGbCd;
    private String regstrGbCdNm;
    private String regstrKindCd;
    private String regstrKindCdNm;
    private String newPlatPlc;
    private String bldNm;
    private String splotNm;
    private String block;
    private String lot;
    private String bylotCnt;
    private String naRoadCd;
    private String naBjdongCd;
    private String naUgrndCd;
    private String naMainBun;
    private String naSubBun;
    private String jiyukCd;
    private String jiguCd;
    private String guyukCd;
    private String jiyukCdNm;
    private String jiguCdNm;
    private String guyukCdNm;
    private String crtnDay;

    public ApartmentRegisterBasic toEntity() {

        return ApartmentRegisterBasic.builder()
//                .kaptCode(this.kaptCode)
                .rnum(this.rnum)
                .platPlc(this.platPlc)
                .sigunguCd(this.sigunguCd)
                .bjdongCd(this.bjdongCd)
                .platGbCd(this.platGbCd)
                .bun(this.bun)
                .ji(this.ji)
//                .mgmBldrgstPk(this.mgmBldrgstPk)
//                .mgmUpBldrgstPk(this.mgmUpBldrgstPk)
                .bldgId(this.bldgId)
                .regstrGbCd(this.regstrGbCd)
                .regstrGbCdNm(this.regstrGbCdNm)
                .regstrKindCd(this.regstrKindCd)
                .regstrKindCdNm(this.regstrKindCdNm)
                .newPlatPlc(this.newPlatPlc)
                .bldNm(this.bldNm)
                .splotNm(this.splotNm)
                .block(this.block)
                .lot(this.lot)
                .bylotCnt(this.bylotCnt)
                .naRoadCd(this.naRoadCd)
                .naBjdongCd(this.naBjdongCd)
                .naUgrndCd(this.naUgrndCd)
                .naMainBun(this.naMainBun)
                .naSubBun(this.naSubBun)
                .jiyukCd(this.jiyukCd)
                .jiguCd(this.jiguCd)
                .guyukCd(this.guyukCd)
                .jiyukCdNm(this.jiyukCdNm)
                .jiguCdNm(this.jiguCdNm)
                .guyukCdNm(this.guyukCdNm)
                .crtnDay(this.crtnDay)
                .mgmUpBldrgstPk(this.mgmUpBldrgstPk)
                .pk(ApartmentRegisterPk.builder()
                        .mgmBldrgstPk(this.mgmBldrgstPk)
                        .kaptCode(this.kaptCode)
                        .build())
                .build();
    }
}