package ru.techlab.risks.auth.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

/**
 * Created by dmitry.erohin@xegex.ru on 26.05.2016.
 * Copyright (C) 2016 - present by Xegex Inc.
 * Please see distribution for license.
 */
@Data
@Entity
@Table(name = "user")
public class User implements Serializable {
    private static final long serialVersionUID = 3375159358757648792L;

    @Id
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "addeddate")
    private Timestamp addedDate;

    @Column(name = "activatedlink")
    private String activatedLink;

    @Column(name = "avatarpath")
    private String avatarPath;
    @Column(name = "birthdate")
    private Timestamp birthDate;
    @Column(name = "name")
    private String name;
    @Column(name = "phone")
    private long phone;

    @ManyToMany
    @JoinTable(name = "userrole",
            joinColumns = @JoinColumn(name = "roleid", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "userid", referencedColumnName = "id"))
    private List<Role> roles;
}
