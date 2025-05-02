package com.earlife.apartment.main.domain.api.apartment.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "external_apartment_detail")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class ApartmentDetail {

    @Version
    private Long version;

    @Id
    @Column(name = "kapt_code", length = 20)
    private String kaptCode;  // 단지코드

    @Column(name = "kapt_name", length = 100, nullable = false)
    private String kaptName;  // 단지명

    @Column(name = "code_mgr", length = 20)
    private String codeMgr;  // 일반관리방식

    @Column(name = "kapt_mgr_cnt")
    private Integer kaptMgrCnt;  // 일반관리인원

    @Column(name = "kapt_ccompany", length = 100)
    private String kaptCcompany;  // 일반관리 계약업체

    @Column(name = "code_sec", length = 20)
    private String codeSec;  // 경비관리방식

    @Column(name = "kaptd_scnt")
    private Integer kaptdScnt;  // 경비관리인원

    @Column(name = "kaptd_sec_com", length = 100)
    private String kaptdSecCom;  // 경비관리 계약업체

    @Column(name = "code_clean", length = 20)
    private String codeClean;  // 청소관리방식

    @Column(name = "kaptd_clcnt")
    private Integer kaptdClcnt;  // 청소관리인원

    @Column(name = "code_garbage", length = 20)
    private String codeGarbage;  // 음식물처리방법

    @Column(name = "code_disinf", length = 20)
    private String codeDisinf;  // 소독관리방식

    @Column(name = "kaptd_dcnt")
    private Integer kaptdDcnt;  // 소독관리 연간 소독횟수

    @Column(name = "disposal_type", length = 50)
    private String disposalType;  // 소독방법

    @Column(name = "code_str", length = 20)
    private String codeStr;  // 건물구조

    @Column(name = "kaptd_ecapa")
    private Integer kaptdEcapa;  // 수전용량

    @Column(name = "code_econ", length = 20)
    private String codeEcon;  // 세대전기계약방식

    @Column(name = "code_emgr", length = 20)
    private String codeEmgr;  // 전기안전관리자법정선임여부

    @Column(name = "code_falarm", length = 20)
    private String codeFalarm;  // 화재수신반방식

    @Column(name = "code_wsupply", length = 20)
    private String codeWsupply;  // 급수방식

    @Column(name = "code_elev", length = 20)
    private String codeElev;  // 승강기관리형태

    @Column(name = "kaptd_ecnt")
    private Integer kaptdEcnt;  // 승강기대수

    @Column(name = "kaptd_pcnt")
    private Integer kaptdPcnt;  // 주차대수(지상)

    @Column(name = "kaptd_pcntu")
    private Integer kaptdPcntu;  // 주차대수(지하)

    @Column(name = "code_net", length = 20)
    private String codeNet;  // 주차관제.홈네트워크

    @Column(name = "kaptd_cccnt")
    private Integer kaptdCccnt;  // CCTV대수

    @Column(name = "welfare_facility", columnDefinition = "TEXT")
    private String welfareFacility;  // 부대.복리시설

    @Column(name = "kaptd_wtimebus", length = 50)
    private String kaptdWtimebus;  // 버스정류장 거리

    @Column(name = "subway_line", length = 50)
    private String subwayLine;  // 지하철호선

    @Column(name = "subway_station", length = 50)
    private String subwayStation;  // 지하철역명

    @Column(name = "kaptd_wtimesub", length = 50)
    private String kaptdWtimesub;  // 지하철역 거리

    @Column(name = "convenient_facility", columnDefinition = "TEXT")
    private String convenientFacility;  // 편의시설

    @Column(name = "education_facility", columnDefinition = "TEXT")
    private String educationFacility;  // 교육시설

    @Column(name = "ground_el_charger_cnt")
    private Integer groundElChargerCnt;  // 지상 전기차 충전대수

    @Column(name = "underground_el_charger_cnt")
    private Integer undergroundElChargerCnt;  // 지하 전기차 충전대수

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "kapt_code")
    private ApartmentMaster apartmentMaster;
}
