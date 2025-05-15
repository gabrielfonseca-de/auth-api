package com.api.auth_login.domain.enums;

public enum ValidationRules {

    PASSWORD_MIN_LENGTH(8),
    USERNAME_MIN_LENGTH(4),
    PASSWORD_SPECIAL_CHARS_REQUIRED(1);

    private final int value;

    ValidationRules(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
