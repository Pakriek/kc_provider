package com.pat.keycloak.extensions.models;

import java.util.Map;
import java.util.List;

public class RoleDto {
    private String id;
    private String name;
    private boolean isRestart;

    public RoleDto(String id, String name, Map<String, List<String>> attributes) {
        this.id = id;
        this.name = name;

        boolean isRestart = false;
        final List<String> restartAttribute = attributes.get("restart");
        if (restartAttribute != null && restartAttribute.size() > 0) {
            isRestart = restartAttribute.get(0).equals("true");
        }
        this.setIsRestart(isRestart);
    }

    public String getRoleId() {
        return this.id;
    }

    public void setRoleId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getIsRestart() {
        return this.isRestart;
    }

    public void setIsRestart(boolean isRestart) {
        this.isRestart = isRestart;
    }
}