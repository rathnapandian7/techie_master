package org.customer.service.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "USER_DTL")
@Data
public class UserDetailsModel {

    @Id
    @GeneratedValue(generator = "USER_DETL_GEN", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "USER_DETL_GEN", sequenceName = "USER_SEQUENCE", initialValue = 80000, allocationSize = 1)

    @Column(name = "USR_ID")
    public Long userId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="customerId",insertable = false, updatable = false)
    private CustomerDetailsModel customerDetailsModel;



    @Column(name = "USR_NAME")
    public String userName;

    @Column(name = "USR_PASWD")
    public String userPassword;

    @Column(name = "USR_FST_NAME")
    public String userFirstName;

    @Column(name = "USR_MDL_NAME")
    public String userMiddleName;

    @Column(name = "USR_LST_NAME")
    public String userLastName;


    @Column(name = "USR_IS_ACT")
    public String userIsActive;

    @Column(name = "USR_PH_NUM")
    public String userPhoneNumber;

    @Column(name = "USR_MBL_NUM")
    public String userMblNumber;

    @Column(name = "CONT_CODE")
    public String contCode;

    @Column(name = "ZN_CD_ID")
    public String zoneCodeId;

    @Column(name = "LOC_ID")
    public String locId;

    @Column(name = "USR_EML_ID")
    public String usermailId;

    @Column(name = "CUST_ID")
    public Long customerId;

    @Column(name = "SIT_ID")
    public String sitId;

    @Column(name = "ROLE_ID")
    public String roleid;

    @Column(name = "USR_STUS")
    public String userStatus;

    @Column(name = "ULTY_ID")
    public String utilityId;


}
