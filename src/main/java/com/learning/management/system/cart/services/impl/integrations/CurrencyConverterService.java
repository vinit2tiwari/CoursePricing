package com.learning.management.system.cart.services.impl.integrations;

import com.learning.management.system.cart.exceptions.ApiException;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service("request")
public class CurrencyConverterService {

    @Value("${currency.converter.api}")
    private String apiUrl;//?base=INR

    @Value("${base.currency}")
    private String baseCurrency;

    private RestTemplate restTemplate = new RestTemplate();

    private Map<String , Double> currencyRates;

    public Double getCurrencyRate(String currency , String sourceCurrency) throws ApiException{
        if(currencyRates  == null) {
            fetchData(sourceCurrency);
        }
        if(currencyRates.containsKey(currency)){
            return currencyRates.get(currency);
        }
        throw new ApiException("Requested currency not supported by the Api");
    }

    private synchronized void fetchData(String sourceCurrency) throws ApiException {
        try{
            baseCurrency = sourceCurrency == null || sourceCurrency.isEmpty() ?  baseCurrency : sourceCurrency;
            Map<String , Object> response = restTemplate.getForObject(apiUrl+ "?base=" + baseCurrency, Map.class);
            currencyRates = (Map<String, Double>) response.get("rates");
        }catch (Exception e){
            throw new ApiException("Error occured while getting currency rates :: " ,e);
        }
    }
}
