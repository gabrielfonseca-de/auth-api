package com.api.auth_login.domain.enums;

public enum Role {

    ADMIN("ROLE_ADMIN", "Acesso total"),
    USER("ROLE_USER", "Acesso básico"),
    MODERATOR("ROLE_MODERATOR", "Acesso moderado");

    private final String authority;
    private final String description;

    Role(String authority, String description) {
        this.authority = authority;
        this.description = description;
    }

    public String getAuthority() {
        return authority;
    }

    public String getDescription() {
        return description;
    }
}
