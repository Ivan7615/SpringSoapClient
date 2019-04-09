package com.example.springsoapclient;

import CountryInfoService.wsdl.FullCountryInfo;
import CountryInfoService.wsdl.FullCountryInfoResponse;
import CountryInfoService.wsdl.ListOfCountryNamesByCode;
import CountryInfoService.wsdl.ListOfCountryNamesByCodeResponse;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

public class CountryClient extends WebServiceGatewaySupport {

    public ListOfCountryNamesByCodeResponse getListOfCountryNamesByCode() {
        ListOfCountryNamesByCode request = new ListOfCountryNamesByCode();

        ListOfCountryNamesByCodeResponse response = (ListOfCountryNamesByCodeResponse) getWebServiceTemplate().marshalSendAndReceive(
                request,
                new SoapActionCallback(
                        "http://webservices.oorsprong.org/websamples.countryinfo/CountryInfoService.wso/ListOfContinentsByCode"));

        return response;
    }

    public FullCountryInfoResponse getFullCountryInfo(String countryIsoCode) {
        FullCountryInfo request = new FullCountryInfo();
        request.setSCountryISOCode(countryIsoCode);

        FullCountryInfoResponse response = (FullCountryInfoResponse) getWebServiceTemplate().marshalSendAndReceive(
                request,
                new SoapActionCallback(
                        "http://webservices.oorsprong.org/websamples.countryinfo/CountryInfoService.wso/ListOfContinentsByCode"));

        return response;
    }




}
