package com.gsstrozi.ff4j.strategy;

import org.ff4j.core.FeatureStore;
import org.ff4j.core.FlippingExecutionContext;
import org.ff4j.strategy.AbstractFlipStrategy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CountryFlippingStrategy extends AbstractFlipStrategy {
  private final Set<String> allowedCountries = new HashSet<>();
  private static final String ALLOWED_COUNTRIES = "allowed_countries";
  private static final String USER_COUNTRY = "user_country";

  @Override
  public void init(String featureName, Map<String, String> initValue) {
    super.init(featureName, initValue);

    assertRequiredParameter(ALLOWED_COUNTRIES);

    String[] countries = initValue.get(ALLOWED_COUNTRIES).split(",");
    allowedCountries.addAll(Arrays.asList(countries));
  }

  @Override
  public boolean evaluate(String s, FeatureStore featureStore, FlippingExecutionContext context) {
    return allowedCountries.contains(context.getString(USER_COUNTRY, true));
  }
}
