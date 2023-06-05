package com.gsstrozi.ff4j.services;

import org.ff4j.FF4j;
import org.ff4j.core.FlippingExecutionContext;
import org.springframework.stereotype.Service;

@Service
public class FeatureToggleService {
  private final FF4j ff4j;

  public FeatureToggleService(FF4j ff4j) {
    this.ff4j = ff4j;
  }

  public boolean featureIsEnabled(String feature, String country) {
    final String USER_COUNTRY = "user_country";

    final FlippingExecutionContext context = new FlippingExecutionContext();
    context.addValue(USER_COUNTRY, country);

    return this.ff4j.check(feature, context);

  }
}
