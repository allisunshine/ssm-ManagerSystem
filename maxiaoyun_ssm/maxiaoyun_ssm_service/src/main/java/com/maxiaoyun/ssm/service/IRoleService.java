package com.maxiaoyun.ssm.service;

import com.maxiaoyun.ssm.domain.Permission;
import com.maxiaoyun.ssm.domain.Role;

import java.util.List;

public interface IRoleService {

    public List<Role> findAll() throws Exception;

    void save(Role role) throws Exception;

    Role findById(String roleId) throws Exception;

    void deleteRole(String roleId);

    List<Permission> findOtherPermissions(String roleId);

    void addPermissionToRole(String roleId, String[] permissionIds) throws Exception;
}
