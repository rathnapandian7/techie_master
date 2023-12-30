package org.customer.service.model;


import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "site_mstr")
@Data
public class SiteMaster {

    @Id
    @GeneratedValue(generator = "SITE_MSTR_GEN", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "SITE_MSTR_GEN", sequenceName = "SITE_MSTR_SEQUENCE", initialValue = 3000, allocationSize = 1)
    @Column(name = "SIT_ID")
    public Long id;

    @Column(name = "SIT_NAME")
    public String siteName;

    @Column(name = "SIT_DESC")
    public String siteDescription;

    @Column(name = "SIT_LOG")
    public String siteLog;

    @Column(name = "SIT_EML_ID")
    public String siteEmailId;

    @Column(name = "SIT_PH_NUM")
    public String sitePhoneNumber;

    @Column(name = "SIT_MBL_NUM")
    public String siteMobNumber;

    @Column(name = "ADD_ID")
    public String siteAddId;

    @Column(name = "SIT_CONT_CODE")
    public String siteContCode;
    @Column(name = "CUST_ID")
    public String customerId;
    @Column(name = "ULTY_ID")
    public String utilityId;
    @Column(name = "ZN_ID")
    public String zoneId;
    @Column(name = "LOC_ID")
    public String localId;


}
