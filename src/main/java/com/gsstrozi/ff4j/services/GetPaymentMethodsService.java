package com.gsstrozi.ff4j.services;

import com.gsstrozi.ff4j.repository.PaymentMethodsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetPaymentMethodsService {
  private final FeatureToggleService featureToggleService;
  private final PaymentMethodsRepository paymentMethodsRepository;

  final String ENABLE_PIX_PAYMENT_METHOD_FEATURE = "enable-pix-payment-method";

  public GetPaymentMethodsService(FeatureToggleService featureToggleService, PaymentMethodsRepository paymentMethodsRepository) {
    this.featureToggleService = featureToggleService;
    this.paymentMethodsRepository = paymentMethodsRepository;
  }

  public List<String> getPaymentMethods(String country) {
    if (featureToggleService.featureIsEnabled(ENABLE_PIX_PAYMENT_METHOD_FEATURE, country)) {
      return paymentMethodsRepository.retrievePaymentMethodsWithPix();
    }

    return paymentMethodsRepository.retrievePaymentMethods();
  }
}
