package com.example.springsoapclient;

import CountryInfoService.wsdl.ArrayOftCountryCodeAndName;
import CountryInfoService.wsdl.ListOfCountryNamesByCodeResponse;
import CountryInfoService.wsdl.TCountryCodeAndName;
import CountryInfoService.wsdl.TCountryInfo;
import com.example.springsoapclient.model.Country;
import com.example.springsoapclient.service.ExcelService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SpringSoapClientApplication {

    public static void main(String[] args) {

        ApplicationContext ctx = SpringApplication.run(CountryConfiguration.class, args);

        CountryClient countryClient = ctx.getBean(CountryClient.class);

        ListOfCountryNamesByCodeResponse response = countryClient.getListOfCountryNamesByCode();
        ArrayOftCountryCodeAndName res = response.getListOfCountryNamesByCodeResult();
        List<TCountryCodeAndName> countryCodeAndNameList = res.getTCountryCodeAndName();
        List<Country> countryList = new ArrayList<>();

        for (TCountryCodeAndName countryCodeAndName : countryCodeAndNameList) {
            TCountryInfo fullCountryInfo = countryClient.getFullCountryInfo(countryCodeAndName.getSISOCode()).getFullCountryInfoResult();

            countryList.add(new Country(
                    fullCountryInfo.getSContinentCode(),
                    countryCodeAndName.getSISOCode(),
                    countryCodeAndName.getSName(),
                    fullCountryInfo.getSCapitalCity(),
                    fullCountryInfo.getSPhoneCode(),
                    fullCountryInfo.getSCurrencyISOCode()
                     ));
            System.out.println(countryCodeAndName.getSISOCode() + " : " + countryCodeAndName.getSName());
        }

        ExcelService.writeResultInExcelFile(countryList);
    }

}
