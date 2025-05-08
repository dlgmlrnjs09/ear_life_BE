package com.earlife.apartment.main.domain.api.apartment.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

@Entity
@Table(name = "external_apartment_register_head_general")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApartmentRegisterHeadGeneral {

    @EmbeddedId
    private ApartmentRegisterPk pk;

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;

    @Comment("순번")
    @Column(name = "rnum", length = 10)
    private String rnum;

//    @Column(name = "kapt_code", length = 20)
//    private String kaptCode;

    @Comment("대지위치")
    @Column(name = "plat_plc", length = 200)
    private String platPlc;

    @Comment("시군구코드")
    @Column(name = "sigungu_cd", length = 10)
    private String sigunguCd;

    @Comment("법정동코드")
    @Column(name = "bjdong_cd", length = 10)
    private String bjdongCd;

    @Comment("대지구분코드")
    @Column(name = "plat_gb_cd", length = 10)
    private String platGbCd;

    @Comment("번")
    @Column(name = "bun", length = 10)
    private String bun;

    @Comment("지")
    @Column(name = "ji", length = 10)
    private String ji;

//    @Comment("관리건축물대장PK")
//    @Column(name = "mgm_bldrgst_pk", length = 30)
//    private String mgmBldrgstPk;

    @Comment("대장구분코드")
    @Column(name = "regstr_gb_cd", length = 10)
    private String regstrGbCd;

    @Comment("대장구분코드명")
    @Column(name = "regstr_gb_cd_nm", length = 50)
    private String regstrGbCdNm;

    @Comment("대장종류코드")
    @Column(name = "regstr_kind_cd", length = 10)
    private String regstrKindCd;

    @Comment("대장종류코드명")
    @Column(name = "regstr_kind_cd_nm", length = 50)
    private String regstrKindCdNm;

    @Comment("신구대장구분코드")
    @Column(name = "new_old_regstr_gb_cd", length = 10)
    private String newOldRegstrGbCd;

    @Comment("신구대장구분코드명")
    @Column(name = "new_old_regstr_gb_cd_nm", length = 50)
    private String newOldRegstrGbCdNm;

    @Comment("도로명대지위치")
    @Column(name = "new_plat_plc", length = 200)
    private String newPlatPlc;

    @Comment("건물명")
    @Column(name = "bld_nm", length = 100)
    private String bldNm;

    @Comment("특수지명")
    @Column(name = "splot_nm", length = 100)
    private String splotNm;

    @Comment("블록")
    @Column(name = "block", length = 100)
    private String block;

    @Comment("로트")
    @Column(name = "lot", length = 100)
    private String lot;

    @Comment("외필지수")
    @Column(name = "bylot_cnt", length = 10)
    private String bylotCnt;

    @Comment("새주소도로코드")
    @Column(name = "na_road_cd", length = 20)
    private String naRoadCd;

    @Comment("새주소법정동코드")
    @Column(name = "na_bjdong_cd", length = 10)
    private String naBjdongCd;

    @Comment("새주소지상지하코드")
    @Column(name = "na_ugrnd_cd", length = 10)
    private String naUgrndCd;

    @Comment("새주소본번")
    @Column(name = "na_main_bun", length = 10)
    private String naMainBun;

    @Comment("새주소부번")
    @Column(name = "na_sub_bun", length = 10)
    private String naSubBun;

    @Comment("대지면적(㎡)")
    @Column(name = "plat_area", length = 20)
    private String platArea;

    @Comment("건축면적(㎡)")
    @Column(name = "arch_area", length = 20)
    private String archArea;

    @Comment("건폐율(%)")
    @Column(name = "bc_rat", length = 20)
    private String bcRat;

    @Comment("연면적(㎡)")
    @Column(name = "tot_area", length = 20)
    private String totArea;

    @Comment("용적률산정연면적(㎡)")
    @Column(name = "vl_rat_estm_tot_area", length = 20)
    private String vlRatEstmTotArea;

    @Comment("용적률(%)")
    @Column(name = "vl_rat", length = 20)
    private String vlRat;

    @Comment("주용도코드")
    @Column(name = "main_purps_cd", length = 10)
    private String mainPurpsCd;

    @Comment("주용도코드명")
    @Column(name = "main_purps_cd_nm", length = 100)
    private String mainPurpsCdNm;

    @Comment("기타용도")
    @Column(name = "etc_purps", length = 200)
    private String etcPurps;

    @Comment("세대수(세대)")
    @Column(name = "hhld_cnt", length = 10)
    private String hhldCnt;

    @Comment("가구수(가구)")
    @Column(name = "fmly_cnt", length = 10)
    private String fmlyCnt;

    @Comment("주건축물수")
    @Column(name = "main_bld_cnt", length = 10)
    private String mainBldCnt;

    @Comment("부속건축물수")
    @Column(name = "atch_bld_cnt", length = 10)
    private String atchBldCnt;

    @Comment("부속건축물면적(㎡)")
    @Column(name = "atch_bld_area", length = 20)
    private String atchBldArea;

    @Comment("총주차수")
    @Column(name = "tot_pkng_cnt", length = 10)
    private String totPkngCnt;

    @Comment("옥내기계식대수(대)")
    @Column(name = "indr_mech_utcnt", length = 10)
    private String indrMechUtcnt;

    @Comment("옥내기계식면적(㎡)")
    @Column(name = "indr_mech_area", length = 20)
    private String indrMechArea;

    @Comment("옥외기계식대수(대)")
    @Column(name = "oudr_mech_utcnt", length = 10)
    private String oudrMechUtcnt;

    @Comment("옥외기계식면적(㎡)")
    @Column(name = "oudr_mech_area", length = 20)
    private String oudrMechArea;

    @Comment("옥내자주식대수(대)")
    @Column(name = "indr_auto_utcnt", length = 10)
    private String indrAutoUtcnt;

    @Comment("옥내자주식면적(㎡)")
    @Column(name = "indr_auto_area", length = 20)
    private String indrAutoArea;

    @Comment("옥외자주식대수(대)")
    @Column(name = "oudr_auto_utcnt", length = 10)
    private String oudrAutoUtcnt;

    @Comment("옥외자주식면적(㎡)")
    @Column(name = "oudr_auto_area", length = 20)
    private String oudrAutoArea;

    @Comment("허가일")
    @Column(name = "pms_day", length = 20)
    private String pmsDay;

    @Comment("착공일")
    @Column(name = "stcns_day", length = 20)
    private String stcnsDay;

    @Comment("사용승인일")
    @Column(name = "use_apr_day", length = 20)
    private String useAprDay;

    @Comment("허가번호년")
    @Column(name = "pmsno_year", length = 10)
    private String pmsnoYear;

    @Comment("허가번호기관코드")
    @Column(name = "pmsno_kik_cd", length = 10)
    private String pmsnoKikCd;

    @Comment("허가번호기관코드명")
    @Column(name = "pmsno_kik_cd_nm", length = 50)
    private String pmsnoKikCdNm;

    @Comment("허가번호구분코드")
    @Column(name = "pmsno_gb_cd", length = 10)
    private String pmsnoGbCd;

    @Comment("허가번호구분코드명")
    @Column(name = "pmsno_gb_cd_nm", length = 50)
    private String pmsnoGbCdNm;

    @Comment("호수(호)")
    @Column(name = "ho_cnt", length = 10)
    private String hoCnt;

    @Comment("에너지효율등급")
    @Column(name = "engr_grade", length = 10)
    private String engrGrade;

    @Comment("에너지절감율")
    @Column(name = "engr_rat", length = 20)
    private String engrRat;

    @Comment("EPI점수")
    @Column(name = "engr_epi", length = 20)
    private String engrEpi;

    @Comment("친환경건축물등급")
    @Column(name = "gn_bld_grade", length = 10)
    private String gnBldGrade;

    @Comment("친환경건축물인증점수")
    @Column(name = "gn_bld_cert", length = 20)
    private String gnBldCert;

    @Comment("지능형건축물등급")
    @Column(name = "itg_bld_grade", length = 10)
    private String itgBldGrade;

    @Comment("지능형건축물인증점수")
    @Column(name = "itg_bld_cert", length = 20)
    private String itgBldCert;

    @Comment("생성일자")
    @Column(name = "crtn_day", length = 20)
    private String crtnDay;
}