package com.earlife.apartment.main.domain.api.apartment.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "external_apartment_master")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class ApartmentMaster {

    @Id
    @Column(name = "kapt_code", length = 20)
    private String kaptCode;

    @Column(name = "kapt_name", length = 100, nullable = false)
    private String kaptName;

    @Column(name = "as1", length = 50, nullable = false)
    private String as1;

    @Column(name = "as2", length = 50, nullable = false)
    private String as2;

    @Column(name = "as3", length = 50, nullable = false)
    private String as3;

    @Column(name = "as4", length = 50)
    private String as4;

    @Column(name = "bjd_code", length = 10, nullable = false)
    private String bjdCode;

    @OneToOne(mappedBy = "apartmentMaster", cascade = CascadeType.ALL)
    private ApartmentDetail apartmentDetail;
}
