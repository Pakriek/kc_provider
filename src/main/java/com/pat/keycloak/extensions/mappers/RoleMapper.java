package com.pat.keycloak.extensions.mappers;

import org.keycloak.models.RoleModel;
import com.pat.keycloak.extensions.models.RoleDto;

public class RoleMapper {
    public RoleDto mapToRoleDto(RoleModel rm) {
        return new RoleDto(
                rm.getId(),
                rm.getName(),
                rm.getAttributes());
    }
}