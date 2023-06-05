package com.gsstrozi.ff4j.controller;

import com.gsstrozi.ff4j.services.GetPaymentMethodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PaymentController {

  private final GetPaymentMethodsService getPaymetMethods;

  public PaymentController(@Autowired GetPaymentMethodsService getPaymetMethods) {
    this.getPaymetMethods = getPaymetMethods;
  }

  @GetMapping("/payment/method")
  public ResponseEntity<List<String>> getPaymentMethods(@RequestHeader("country") String country) {

    List<String> methods = getPaymetMethods.getPaymentMethods(country);
    return new ResponseEntity<List<String>>(methods, HttpStatus.OK);
  }
}
