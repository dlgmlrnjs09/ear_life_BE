package com.earlife.apartment.main.domain.api.apartment.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

import java.io.Serializable;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApartmentRegisterPk implements Serializable {
    @Column(name = "kapt_code", length = 20)
    private String kaptCode;

    @Comment("관리건축물대장PK")
    @Column(name = "mgm_bldrgst_pk", length = 30)
    private String mgmBldrgstPk;

//    @Comment("관리상위건축물대장PK")
//    @Column(name = "mgm_up_bldrgst_pk", length = 30)
//    private String mgmUpBldrgstPk;
}
