package org.customer.service.model;


import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "loc_mstr")
@Data
public class LocalMaster {

    @Id
    @GeneratedValue(generator = "LOCAL_MSTR_GEN", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "LOCAL_MSTR_GEN", sequenceName = "LOCAL_MSTR_SEQUENCE", initialValue = 40000, allocationSize = 1)
    @Column(name = "LOC_ID")
    public Long id;

    @Column(name = "LOC_NAME")
    public String localName;

    @Column(name = "CUST_ID")
    public String customerId;

    @Column(name = "CITY_ID")
    public String cityId;

    @Column(name = "STAT_ID")
    public String stateId;

    @Column(name = "PN_CD_ID")
    public String pinCodeId;

    @Column(name = "LOC_IS_ACT")
    public String localIsActive;


    @Column(name = "LOC_STUS")
    public String localStatus;

    @Column(name = "ULTY_ID")
    public String utilityId;


}
