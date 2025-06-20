package org.skypro.skyshop.service;

public class ShopError {
    private final String Code;
    private final String message;

    public ShopError(String code, String message) {
        Code = code;
        this.message = message;
    }

    public String getCode() {
        return Code;
    }

    public String getMessage() {
        return message;
    }
}
