package com.earlife.apartment.main.external.api.dataportal.dto;

import com.earlife.apartment.main.domain.api.apartment.entity.ApartmentBasic;
import com.earlife.apartment.main.domain.api.apartment.entity.ApartmentMaster;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.Version;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class ApartmentBasicDto {
    private String kaptCode;
    private String kaptName;
    private String kaptAddr;
    private String codeSaleNm;
    private String codeHeatNm;
    private BigDecimal kaptTarea;
    private Integer kaptDongCnt;
    private Integer kaptdaCnt;
    private String kaptBcompany;
    private String kaptAcompany;
    private String kaptTel;
    private String kaptFax;
    private String kaptUrl;
    private String codeAptNm;
    private String doroJuso;
    private Integer hoCnt;
    private String codeMgrNm;
    private String codeHallNm;
    private String kaptUsedate;
    private BigDecimal kaptMarea;
    private Integer kaptMparea60;
    private Integer kaptMparea85;
    private Integer kaptMparea135;
    private Integer kaptMparea136;
    private BigDecimal privArea;
    private String bjdCode;
    private Integer kaptTopFloor;
    private Integer ktownFlrNo;
    private Integer kaptBaseFloor;
    private Integer kaptdEcntp;
    private String zipcode;

    public ApartmentBasic toEntity() {
        return ApartmentBasic.builder()
                /*.apartmentMaster(master)*/
                .kaptCode(this.kaptCode)
                .kaptName(this.kaptName)
                .kaptAddr(this.kaptAddr)
                .codeSaleNm(this.codeSaleNm)
                .codeHeatNm(this.codeHeatNm)
                .kaptTarea(this.kaptTarea)
                .kaptDongCnt(this.kaptDongCnt)
                .kaptdaCnt(this.kaptdaCnt)
                .kaptBcompany(this.kaptBcompany)
                .kaptAcompany(this.kaptAcompany)
                .kaptTel(this.kaptTel)
                .kaptFax(this.kaptFax)
                .kaptUrl(this.kaptUrl)
                .codeAptNm(this.codeAptNm)
                .doroJuso(this.doroJuso)
                .hoCnt(this.hoCnt)
                .codeMgrNm(this.codeMgrNm)
                .codeHallNm(this.codeHallNm)
                .kaptUsedate(this.kaptUsedate)
                .kaptMarea(this.kaptMarea)
                .kaptMparea60(this.kaptMparea60)
                .kaptMparea85(this.kaptMparea85)
                .kaptMparea135(this.kaptMparea135)
                .kaptMparea136(this.kaptMparea136)
                .privArea(this.privArea)
                .bjdCode(this.bjdCode)
                .kaptTopFloor(this.kaptTopFloor)
                .ktownFlrNo(this.ktownFlrNo)
                .kaptBaseFloor(this.kaptBaseFloor)
                .kaptdEcntp(this.kaptdEcntp)
                .zipcode(this.zipcode)
                .build();
    }
}
