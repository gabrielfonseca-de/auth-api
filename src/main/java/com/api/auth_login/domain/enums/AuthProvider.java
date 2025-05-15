package com.api.auth_login.domain.enums;

public enum AuthProvider {

    LOCAL("local"),
    GOOGLE("google"),
    GITHUB("github"),
    FACEBOOK("facebook");

    private final String providerType;

    AuthProvider(String providerType) {
        this.providerType = providerType;
    }

    public String getProviderType() {
        return providerType;
    }
}
