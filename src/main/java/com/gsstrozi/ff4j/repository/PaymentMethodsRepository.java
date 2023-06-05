package com.gsstrozi.ff4j.repository;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PaymentMethodsRepository {
  private final String MONEY = "Dinheiro";
  private final String CREDIT_CARD = "Cartão de cŕedito";
  private final String PIX = "PIX";

  public List<String> retrievePaymentMethods() {
    List<String> methods = new ArrayList<String>() {{
      add(MONEY);
      add(CREDIT_CARD);
    }};

    return methods;
  }

  public List<String> retrievePaymentMethodsWithPix() {
    List<String> methods = new ArrayList<String>() {{
      add(MONEY);
      add(CREDIT_CARD);
      add(PIX);
    }};

    return methods;
  }
}
