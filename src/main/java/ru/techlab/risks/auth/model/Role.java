package ru.techlab.risks.auth.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

/**
 * Created by dmitry.erohin@xegex.ru on 27.05.2016.
 * Copyright (C) 2016 - present by Xegex Inc.
 * Please see distribution for license.
 */
@Data
@Entity
@Table(name = "role")
public class Role implements Serializable {
    private static final long serialVersionUID = 3375159358757648792L;

    @Id
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "code")
    private String role;

    @ManyToMany(mappedBy = "roles")
    private List<User> users;
}
