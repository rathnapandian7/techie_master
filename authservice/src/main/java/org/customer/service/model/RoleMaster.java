package org.customer.service.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "role_mstr")
@Data
public class RoleMaster {

    @Id
    @GeneratedValue(generator = "ROLE_MSTR_GEN", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "ROLE_MSTR_GEN", sequenceName = "ROLE_MSTR_SEQUENCE", initialValue = 30000, allocationSize = 1)
    @Column(name = "ROLE_ID")
    public Long id;

    @Column(name = "ROLE_TYP")
    public String roleType;


}
