package com.earlife.apartment.main.external.api.dataportal.dto;

import com.earlife.apartment.main.domain.api.apartment.entity.ApartmentDetail;
import com.earlife.apartment.main.domain.api.apartment.entity.ApartmentMaster;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class ApartmentDetailDto {
    private String kaptCode;  // 단지코드
    private String kaptName;  // 단지명
    private String codeMgr;  // 일반관리방식
    private Double kaptMgrCnt;  // 일반관리인원
    private String kaptCcompany;  // 일반관리 계약업체
    private String codeSec;  // 경비관리방식
    private Double kaptdScnt;  // 경비관리인원
    private String kaptdSecCom;  // 경비관리 계약업체
    private String codeClean;  // 청소관리방식
    private Double kaptdClcnt;  // 청소관리인원
    private String codeGarbage;  // 음식물처리방법
    private String codeDisinf;  // 소독관리방식
    private Integer kaptdDcnt;  // 소독관리 연간 소독횟수
    private String disposalType;  // 소독방법
    private String codeStr;  // 건물구조
    private Double kaptdEcapa;  // 수전용량
    private String codeEcon;  // 세대전기계약방식
    private String codeEmgr;  // 전기안전관리자법정선임여부
    private String codeFalarm;  // 화재수신반방식
    private String codeWsupply;  // 급수방식
    private String codeElev;  // 승강기관리형태
    private Integer kaptdEcnt;  // 승강기대수
    private Integer kaptdPcnt;  // 주차대수(지상)
    private Integer kaptdPcntu;  // 주차대수(지하)
    private String codeNet;  // 주차관제.홈네트워크
    private Double kaptdCccnt;  // CCTV대수
    private String welfareFacility;  // 부대.복리시설
    private String kaptdWtimebus;  // 버스정류장 거리
    private String subwayLine;  // 지하철호선
    private String subwayStation;  // 지하철역명
    private String kaptdWtimesub;  // 지하철역 거리
    private String convenientFacility;  // 편의시설
    private String educationFacility;  // 교육시설
    private Double groundElChargerCnt;  // 지상 전기차 충전대수
    private Double undergroundElChargerCnt;  // 지하 전기차 충전대수

    public ApartmentDetail toEntity() {
        return ApartmentDetail.builder()
                /*.apartmentMaster(master)*/
                .kaptCode(this.kaptCode)
                .kaptName(this.kaptName)
                .codeMgr(this.codeMgr)
                .kaptMgrCnt(this.kaptMgrCnt)
                .kaptCcompany(this.kaptCcompany)
                .codeSec(this.codeSec)
                .kaptdScnt(this.kaptdScnt)
                .kaptdSecCom(this.kaptdSecCom)
                .codeClean(this.codeClean)
                .kaptdClcnt(this.kaptdClcnt)
                .codeGarbage(this.codeGarbage)
                .codeDisinf(this.codeDisinf)
                .kaptdDcnt(this.kaptdDcnt)
                .disposalType(this.disposalType)
                .codeStr(this.codeStr)
                .kaptdEcapa(this.kaptdEcapa)
                .codeEcon(this.codeEcon)
                .codeEmgr(this.codeEmgr)
                .codeFalarm(this.codeFalarm)
                .codeWsupply(this.codeWsupply)
                .codeElev(this.codeElev)
                .kaptdEcnt(this.kaptdEcnt)
                .kaptdPcnt(this.kaptdPcnt)
                .kaptdPcntu(this.kaptdPcntu)
                .codeNet(this.codeNet)
                .kaptdCccnt(this.kaptdCccnt)
                .welfareFacility(this.welfareFacility)
                .kaptdWtimebus(this.kaptdWtimebus)
                .subwayLine(this.subwayLine)
                .subwayStation(this.subwayStation)
                .kaptdWtimesub(this.kaptdWtimesub)
                .convenientFacility(this.convenientFacility)
                .educationFacility(this.educationFacility)
                .groundElChargerCnt(this.groundElChargerCnt)
                .undergroundElChargerCnt(this.undergroundElChargerCnt)
                .build();
    }
}