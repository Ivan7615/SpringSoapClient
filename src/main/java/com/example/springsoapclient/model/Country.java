package com.example.springsoapclient.model;

public class Country {
    private String continentalCode;
    private String countryCode;
    private String countryName;
    private String capitalCity;
    private String phoneCode;
    private String currencyCode;

    public Country(String continentalCode, String countryCode, String countryName, String capitalCity, String phoneCode, String currencyCode) {
        this.continentalCode = continentalCode;
        this.countryCode = countryCode;
        this.countryName = countryName;
        this.capitalCity = capitalCity;
        this.phoneCode = phoneCode;
        this.currencyCode = currencyCode;
    }

    public String getContinentalCode() {
        return continentalCode;
    }

    public void setContinentalCode(String continentalCode) {
        this.continentalCode = continentalCode;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCapitalCity() {
        return capitalCity;
    }

    public void setCapitalCity(String capitalCity) {
        this.capitalCity = capitalCity;
    }

    public String getPhoneCode() {
        return phoneCode;
    }

    public void setPhoneCode(String phoneCode) {
        this.phoneCode = phoneCode;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }
}
