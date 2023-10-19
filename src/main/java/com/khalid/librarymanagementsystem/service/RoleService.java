package com.khalid.librarymanagementsystem.service;

import com.khalid.librarymanagementsystem.entity.RoleEntity;
import com.khalid.librarymanagementsystem.entity.RoleEnum;

public interface RoleService {

    public RoleEntity addRole(RoleEnum role);
    public RoleEntity getRole(String roleName);


}
