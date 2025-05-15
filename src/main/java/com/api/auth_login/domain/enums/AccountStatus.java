package com.api.auth_login.domain.enums;

import lombok.Getter;

public enum AccountStatus {

    ACTIVE("Ativa", true),
    PENDING_EMAIL_VERIFICATION("Pending Email", false),
    LOCKED("Bloqueada", false),
    DISABLED("Desativada", false);

    @Getter
    private final String description;
    private final boolean canLogin;

    // Construtor correto
    AccountStatus(String description, boolean canLogin) {
        this.description = description;
        this.canLogin = canLogin;
    }

    public boolean canLogin() {
        return canLogin;
    }
}
