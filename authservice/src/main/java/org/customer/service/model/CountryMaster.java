package org.customer.service.model;


import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "cont_mstr")
@Data
public class CountryMaster {

    @Id
    @GeneratedValue(generator = "CONT_MSTR_GEN", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "CONT_MSTR_GEN", sequenceName = "CONT_MSTR_SEQUENCE", initialValue = 50000, allocationSize = 1)
    @Column(name = "CONT_ID")
    public Long id;

    @Column(name = "CONT_NAME")
    public Long countryName;

}
