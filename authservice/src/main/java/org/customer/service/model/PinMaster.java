package org.customer.service.model;


import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "city_mstr")
@Data
public class PinMaster {


    @Id
    @GeneratedValue(generator = "PIN_MSTR_GEN", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "PIN_MSTR_GEN", sequenceName = "PIN_MSTR_SEQUENCE", initialValue = 10000, allocationSize = 1)
    @Column(name = "PN_CD_ID")
    public Long id;

    @Column(name = "PN_NAME")
    public String pinName;
    @Column(name = "CITY_ID")
    public String cityId;
}
