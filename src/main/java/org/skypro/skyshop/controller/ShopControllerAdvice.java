package org.skypro.skyshop.controller;

import org.skypro.skyshop.service.NoSuchProductException;
import org.skypro.skyshop.service.ShopError;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ShopControllerAdvice{

    @ExceptionHandler(NoSuchProductException.class)
    public ResponseEntity<ShopError> noSuchProductException(NoSuchProductException e) {
        ShopError shopError = new ShopError("Ошибка 500", "Продукт с таким ID не найден!");
        return new ResponseEntity<ShopError>(shopError, HttpStatusCode.valueOf(404));
    }
}
