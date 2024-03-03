package com.pat.keycloak.extensions.models;

import java.util.stream.*;
import java.util.List;
import org.keycloak.models.RoleModel;

import com.pat.keycloak.extensions.mappers.RoleMapper;

public class GroupDto {
    private String id;
    private String name;
    private List<RoleDto> roleDtos;

    public GroupDto(String id, String name, Stream<RoleModel> roles) {
        final RoleMapper roleMapper = new RoleMapper();

        this.id = id;
        this.name = name;

        final List<RoleDto> rolesDto = roles.map(e -> roleMapper.mapToRoleDto(e)).collect(Collectors.toList());
        this.setRoles(rolesDto);
    }

    public String getGroupId() {
        return this.id;
    }

    public void setGroupId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<RoleDto> getRoles() {
        return this.roleDtos;
    }

    public void setRoles(List<RoleDto> roles) {
        this.roleDtos = roles;
    }
}