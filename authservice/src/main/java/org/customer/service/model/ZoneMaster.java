package org.customer.service.model;


import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "zone_mstr")
@Data
public class ZoneMaster {

    @Id
    @GeneratedValue(generator = "ZONE_MSTR_GEN", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "ZONE_MSTR_GEN", sequenceName = "ZONE_MSTR_SEQUENCE", initialValue = 60000, allocationSize = 1)
    @Column(name = "ZN_ID")
    public Long id;

    @Column(name = "ZN_NAME")
    public String zoneName;

    @Column(name = "CUST_ID")
    public String customerId;

    @Column(name = "CITY_ID")
    public String cityId;

    @Column(name = "STAT_ID")
    public String stateId;

    @Column(name = "CONT_ID")
    public String countryId;

    @Column(name = "PN_CD_ID")
    public String pinCodeId;

    @Column(name = "ZN_IS_ACT")
    public String zoneIsActive;

}
