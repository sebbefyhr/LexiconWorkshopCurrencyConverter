package org.fyr;

public class Converter {
    private String originalCurrency;
    private String convertedCurrency;
    private double conversionRate;


    public Converter(String originalCurrency, String convertedCurrency, double conversionRate) {
        this.originalCurrency = originalCurrency;
        this.convertedCurrency = convertedCurrency;
        this.conversionRate = conversionRate;
    }

    public String getOriginalCurrency() {
        return originalCurrency;
    }

    public void setOriginalCurrency(String originalCurrency) {
        this.originalCurrency = originalCurrency;
    }

    public String getConvertedCurrency() {
        return convertedCurrency;
    }

    public void setConvertedCurrency(String convertedCurrency) {
        this.convertedCurrency = convertedCurrency;
    }

    public double getConversionRate() {
        return conversionRate;
    }

    public void setConversionRate(double conversionRate) {
        this.conversionRate = conversionRate;
    }
}
