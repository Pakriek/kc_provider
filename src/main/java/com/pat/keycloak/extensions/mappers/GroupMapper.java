package com.pat.keycloak.extensions.mappers;

import org.keycloak.models.GroupModel;
import com.pat.keycloak.extensions.models.GroupDto;

public class GroupMapper {
    public GroupDto mapToGroupDto(GroupModel gm) {
        return new GroupDto(
                gm.getId(),
                gm.getName(),
                gm.getRoleMappingsStream());
    }
}