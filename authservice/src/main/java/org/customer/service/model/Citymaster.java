package org.customer.service.model;


import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "city_mstr")
@Data
public class Citymaster {


    @Id
    @GeneratedValue(generator = "CITY_MSTR_GEN", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "CITY_MSTR_GEN", sequenceName = "CITY_MSTR_SEQUENCE", initialValue = 8000, allocationSize = 1)
    @Column(name = "CITY_ID")
    public Long id;

    @Column(name = "CITY_NAME")
    public String cityName;

    @Column(name = "STAT_ID")
    public String stateId;
}
