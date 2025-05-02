package com.earlife.apartment.main.external.api.dataportal.dto;

import com.earlife.apartment.main.domain.api.apartment.entity.ApartmentMaster;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class ApartmentDto {
    private String kaptCode;
    private String kaptName;
    private String as1;
    private String as2;
    private String as3;
    private String as4;
    private String bjdCode;

    public ApartmentMaster toEntity() {
        return ApartmentMaster.builder()
                .kaptCode(this.kaptCode)
                .kaptName(this.kaptName)
                .as1(this.as1)
                .as2(this.as2)
                .as3(this.as3)
                .as4(this.as4)
                .bjdCode(this.bjdCode)
                .build();
    }
}
