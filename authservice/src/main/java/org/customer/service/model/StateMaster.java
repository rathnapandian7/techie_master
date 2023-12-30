package org.customer.service.model;


import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "stat_mstr")
@Data
public class StateMaster {

    @Id
    @GeneratedValue(generator = "STAT_MSTR_GEN", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "STAT_MSTR_GEN", sequenceName = "STAT_MSTR_SEQUENCE", initialValue = 90000, allocationSize = 1)
    @Column(name = "STAT_ID")
    public Long id;

    @Column(name = "STAT_NAME")
    public Long stateName;
    @Column(name = "CONT_ID")
    public Long countryId;

}
