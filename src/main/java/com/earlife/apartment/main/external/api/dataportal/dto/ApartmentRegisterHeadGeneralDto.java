package com.earlife.apartment.main.external.api.dataportal.dto;

import com.earlife.apartment.main.domain.api.apartment.entity.ApartmentRegisterHeadGeneral;
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
public class ApartmentRegisterHeadGeneralDto {
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
    private String newOldRegstrGbCd;
    private String newOldRegstrGbCdNm;
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
    private String platArea;
    private String archArea;
    private String bcRat;
    private String totArea;
    private String vlRatEstmTotArea;
    private String vlRat;
    private String mainPurpsCd;
    private String mainPurpsCdNm;
    private String etcPurps;
    private String hhldCnt;
    private String fmlyCnt;
    private String mainBldCnt;
    private String atchBldCnt;
    private String atchBldArea;
    private String totPkngCnt;
    private String indrMechUtcnt;
    private String indrMechArea;
    private String oudrMechUtcnt;
    private String oudrMechArea;
    private String indrAutoUtcnt;
    private String indrAutoArea;
    private String oudrAutoUtcnt;
    private String oudrAutoArea;
    private String pmsDay;
    private String stcnsDay;
    private String useAprDay;
    private String pmsnoYear;
    private String pmsnoKikCd;
    private String pmsnoKikCdNm;
    private String pmsnoGbCd;
    private String pmsnoGbCdNm;
    private String hoCnt;
    private String engrGrade;
    private String engrRat;
    private String engrEpi;
    private String gnBldGrade;
    private String gnBldCert;
    private String itgBldGrade;
    private String itgBldCert;
    private String crtnDay;

    public ApartmentRegisterHeadGeneral toEntity() {
        return ApartmentRegisterHeadGeneral.builder()
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
                .newOldRegstrGbCd(this.newOldRegstrGbCd)
                .newOldRegstrGbCdNm(this.newOldRegstrGbCdNm)
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
                .platArea(this.platArea)
                .archArea(this.archArea)
                .bcRat(this.bcRat)
                .totArea(this.totArea)
                .vlRatEstmTotArea(this.vlRatEstmTotArea)
                .vlRat(this.vlRat)
                .mainPurpsCd(this.mainPurpsCd)
                .mainPurpsCdNm(this.mainPurpsCdNm)
                .etcPurps(this.etcPurps)
                .hhldCnt(this.hhldCnt)
                .fmlyCnt(this.fmlyCnt)
                .mainBldCnt(this.mainBldCnt)
                .atchBldCnt(this.atchBldCnt)
                .atchBldArea(this.atchBldArea)
                .totPkngCnt(this.totPkngCnt)
                .indrMechUtcnt(this.indrMechUtcnt)
                .indrMechArea(this.indrMechArea)
                .oudrMechUtcnt(this.oudrMechUtcnt)
                .oudrMechArea(this.oudrMechArea)
                .indrAutoUtcnt(this.indrAutoUtcnt)
                .indrAutoArea(this.indrAutoArea)
                .oudrAutoUtcnt(this.oudrAutoUtcnt)
                .oudrAutoArea(this.oudrAutoArea)
                .pmsDay(this.pmsDay)
                .stcnsDay(this.stcnsDay)
                .useAprDay(this.useAprDay)
                .pmsnoYear(this.pmsnoYear)
                .pmsnoKikCd(this.pmsnoKikCd)
                .pmsnoKikCdNm(this.pmsnoKikCdNm)
                .pmsnoGbCd(this.pmsnoGbCd)
                .pmsnoGbCdNm(this.pmsnoGbCdNm)
                .hoCnt(this.hoCnt)
                .engrGrade(this.engrGrade)
                .engrRat(this.engrRat)
                .engrEpi(this.engrEpi)
                .gnBldGrade(this.gnBldGrade)
                .gnBldCert(this.gnBldCert)
                .itgBldGrade(this.itgBldGrade)
                .itgBldCert(this.itgBldCert)
                .crtnDay(this.crtnDay)
                .pk(ApartmentRegisterPk.builder()
                        .mgmBldrgstPk(this.mgmBldrgstPk)
                        .kaptCode(this.kaptCode)
                        .build())
                .build();
    }
}