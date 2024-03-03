package com.pat.keycloak.extensions.models;

public class RoleDto {
    private String id;
    private String name;

    public RoleDto(String id, String name) {
        this.id = id;
        this.name = name;
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
}