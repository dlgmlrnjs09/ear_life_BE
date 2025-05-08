package com.earlife.apartment.main.domain.api.apartment.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

@Entity
@Table(name = "external_apartment_register_floor")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApartmentRegisterFloor {

    @EmbeddedId
    private ApartmentRegisterPk pk;

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @Column(name = "kapt_code", length = 20)
//    private String kaptCode;

    @Comment("순번")
    @Column(name = "rnum", length = 10)
    private String rnum;

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

    @Comment("동명칭")
    @Column(name = "dong_nm", length = 100)
    private String dongNm;

    @Comment("층구분코드")
    @Column(name = "flr_gb_cd", length = 10)
    private String flrGbCd;

    @Comment("층구분코드명")
    @Column(name = "flr_gb_cd_nm", length = 50)
    private String flrGbCdNm;

    @Comment("층번호")
    @Column(name = "flr_no", length = 10)
    private String flrNo;

    @Comment("층번호명")
    @Column(name = "flr_no_nm", length = 50)
    private String flrNoNm;

    @Comment("구조코드")
    @Column(name = "strct_cd", length = 10)
    private String strctCd;

    @Comment("구조코드명")
    @Column(name = "strct_cd_nm", length = 50)
    private String strctCdNm;

    @Comment("기타구조")
    @Column(name = "etc_strct", length = 200)
    private String etcStrct;

    @Comment("주용도코드")
    @Column(name = "main_purps_cd", length = 10)
    private String mainPurpsCd;

    @Comment("주용도코드명")
    @Column(name = "main_purps_cd_nm", length = 100)
    private String mainPurpsCdNm;

    @Comment("기타용도")
    @Column(name = "etc_purps", length = 200)
    private String etcPurps;

    @Comment("주부속구분코드")
    @Column(name = "main_atch_gb_cd", length = 10)
    private String mainAtchGbCd;

    @Comment("주부속구분코드명")
    @Column(name = "main_atch_gb_cd_nm", length = 50)
    private String mainAtchGbCdNm;

    @Comment("면적(㎡)")
    @Column(name = "area", length = 20)
    private String area;

    @Comment("면적제외여부")
    @Column(name = "area_exct_yn", length = 1)
    private String areaExctYn;

    @Comment("생성일자")
    @Column(name = "crtn_day", length = 20)
    private String crtnDay;
}
