package service;

import model.Currency;

public class CurrencyCreator {
    private static final String TEST_DATA_CURRENCY_VALUE = "testdata.currency.value";

    public static Currency createCurrency(){
        return new Currency(TestDataReader.getTestData(TEST_DATA_CURRENCY_VALUE));
    }
}
