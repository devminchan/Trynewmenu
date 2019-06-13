package com.tailors.trynewmenu.domain.account;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "TRM_Account_Access_Email")
@Access(AccessType.FIELD)
@DiscriminatorValue(value = "email")
@Getter
@NoArgsConstructor
public class EmailAccountAccess extends AccountAccess {
    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;
}