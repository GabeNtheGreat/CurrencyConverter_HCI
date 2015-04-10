package com.currencyconverter.np.currencyconverter;

import org.apache.http.HttpResponse;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import java.io.IOException;

/**
 * This class handles the API Calls and returns a String/ENUM with the currencies to be used
 * for the converter
 * Created by PeanutMan on 26.03.2015.
 */
public class ConverterCurrencyAPICall {
    static String callResponse = null;

    /**
     * ClassConstructor
     */
    public ConverterCurrencyAPICall (){}

    /**
     * Function to get the currency values from the fixer.io API
     */
    public String getCurrencies() {
        DefaultHttpClient httpClient = new DefaultHttpClient();
        HttpEntity httpEntity = null;
        HttpResponse httpResponse = null;
        String response = null;
        String url = "http://api.fixer.io/latest";

        HttpGet httpGet = new HttpGet(url);
        try {
            httpResponse = httpClient.execute(httpGet);
            httpEntity = httpResponse.getEntity();
            response = EntityUtils.toString(httpEntity);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return response;
    }


}
