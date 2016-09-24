package com.bakigoal.ocjp.format;

import java.util.Currency;
import java.util.Locale;

/**
 * Created by ilmir on 17.04.16.
 */
public class CurrencyDetails {
  public static void main(String[] args) {
    Locale locale = new Locale("ru", "RU");
    Currency currencyInstance = Currency.getInstance(locale);
    System.out.println("Locale = " + locale);
    System.out.println(" currency.getCurrencyCode() \t\t" + currencyInstance.getCurrencyCode()
        + " \n currency.getSymbol() \t\t\t\t" + currencyInstance.getSymbol()
        + " \n currency.getDisplayName() \t\t\t" + currencyInstance.getDisplayName());
  }
}
