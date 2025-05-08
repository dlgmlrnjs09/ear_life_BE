package com.earlife.apartment.main.domain.api.apartment.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Comment;

@Entity
@Table(name = "external_apartment_register_basic")
@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ApartmentRegisterBasic {

    @EmbeddedId
    private ApartmentRegisterPk pk;

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)

//    @Column(name = "id")
//    private Long id;

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

    @Comment("관리상위건축물대장PK")
    @Column(name = "mgm_up_bldrgst_pk", length = 30)
    private String mgmUpBldrgstPk;

    @Comment("건물_아이디")
    @Column(name = "bldg_id", length = 30)
    private String bldgId;

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

    @Comment("지역코드")
    @Column(name = "jiyuk_cd", length = 10)
    private String jiyukCd;

    @Comment("지구코드")
    @Column(name = "jigu_cd", length = 10)
    private String jiguCd;

    @Comment("구역코드")
    @Column(name = "guyuk_cd", length = 10)
    private String guyukCd;

    @Comment("지역코드명")
    @Column(name = "jiyuk_cd_nm", length = 50)
    private String jiyukCdNm;

    @Comment("지구코드명")
    @Column(name = "jigu_cd_nm", length = 50)
    private String jiguCdNm;

    @Comment("구역코드명")
    @Column(name = "guyuk_cd_nm", length = 50)
    private String guyukCdNm;

    @Comment("생성일자")
    @Column(name = "crtn_day", length = 20)
    private String crtnDay;
}
