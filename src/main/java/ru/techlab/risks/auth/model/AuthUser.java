package ru.techlab.risks.auth.model;

import org.springframework.security.core.authority.AuthorityUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by dmitry.erohin@xegex.ru on 29.09.2016.
 * Copyright (C) 2016 - present by Xegex Inc.
 * Please see distribution for license.
 */
public class AuthUser extends org.springframework.security.core.userdetails.User implements Serializable {
    private static final long serialVersionUID = 3375159358757648792L;

    private User user;

    public AuthUser(User user) {
        /*super(user.getEmail(), user.getPassword(),
                AuthorityUtils.commaSeparatedStringToAuthorityList(String.join(",", user.getRoles().stream().map(Role::getRole).collect(Collectors.toList()))));*/
        super(user.getEmail(), user.getPassword(), AuthorityUtils.createAuthorityList("ADMIN"));
        List<Role> roles = new ArrayList<>();
        Role role = new Role();
        role.setId(1L);
        role.setName("ADMIN");
        role.setRole("Admin");
        roles.add(role);
        user.setRoles(roles);
        this.user = user;
    }

    public Long getId() {
        return user.getId();
    }
    public String getName() {
        return user.getName();
    }
    public String getEmail() {
        return user.getEmail();
    }
    public List<Role> getRole() {
        return user.getRoles();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        AuthUser authUser = (AuthUser) o;

        return user != null ? user.equals(authUser.user) : authUser.user == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (user != null ? user.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "AuthUser{" +
                "user=" + user +
                '}';
    }
}
