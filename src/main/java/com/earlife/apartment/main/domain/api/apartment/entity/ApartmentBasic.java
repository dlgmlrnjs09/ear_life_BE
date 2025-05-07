package com.earlife.apartment.main.domain.api.apartment.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

@Entity
@Table(name = "external_apartment_basic")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApartmentBasic {

    @Version
    private Long version;

    @Id
    @Column(name = "kapt_code", length = 20)
    private String kaptCode;

    @Column(name = "kapt_name", nullable = false, length = 100)
    private String kaptName;

    @Column(name = "kapt_addr", length = 200)
    private String kaptAddr;

    @Column(name = "code_sale_nm", length = 50)
    private String codeSaleNm;

    @Column(name = "code_heat_nm", length = 50)
    private String codeHeatNm;

    @Column(name = "kapt_tarea", precision = 15, scale = 3)
    private BigDecimal kaptTarea;

    @Column(name = "kapt_dong_cnt")
    private Integer kaptDongCnt;

    @Column(name = "kaptda_cnt")
    private Integer kaptdaCnt;

    @Column(name = "kapt_bcompany", length = 100)
    private String kaptBcompany;

    @Column(name = "kapt_acompany", length = 100)
    private String kaptAcompany;

    @Column(name = "kapt_tel", length = 20)
    private String kaptTel;

    @Column(name = "kapt_fax", length = 20)
    private String kaptFax;

    @Column(name = "kapt_url", length = 200)
    private String kaptUrl;

    @Column(name = "code_apt_nm", length = 50)
    private String codeAptNm;

    @Column(name = "doro_juso", length = 200)
    private String doroJuso;

    @Column(name = "ho_cnt")
    private Integer hoCnt;

    @Column(name = "code_mgr_nm", length = 50)
    private String codeMgrNm;

    @Column(name = "code_hall_nm", length = 50)
    private String codeHallNm;

    @Column(name = "kapt_usedate", length = 8)
    private String kaptUsedate;

    @Column(name = "kapt_marea", precision = 15, scale = 3)
    private BigDecimal kaptMarea;

    @Column(name = "kapt_mparea60")
    private Integer kaptMparea60;

    @Column(name = "kapt_mparea85")
    private Integer kaptMparea85;

    @Column(name = "kapt_mparea135")
    private Integer kaptMparea135;

    @Column(name = "kapt_mparea136")
    private Integer kaptMparea136;

    @Column(name = "priv_area", precision = 15, scale = 4)
    private BigDecimal privArea;

    @Column(name = "bjd_code", length = 10)
    private String bjdCode;

    @Column(name = "kapt_top_floor")
    private Integer kaptTopFloor;

    @Column(name = "ktown_flr_no")
    private Integer ktownFlrNo;

    @Column(name = "kapt_base_floor")
    private Integer kaptBaseFloor;

    @Column(name = "kaptd_ecntp")
    private Integer kaptdEcntp;

    @Column(name = "zipcode", length = 10)
    private String zipcode;

    /*@OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "kapt_code")
    private ApartmentMaster apartmentMaster;*/
}
