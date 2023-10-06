package org.selenium.pom.dataProviders;

import objects.BillingAddress;
import objects.BillingCountries;
import objects.Products;
import org.testng.annotations.DataProvider;
import utils.JacksonUtils;

import java.io.IOException;

public class AppDataProviders {

    @DataProvider(name = "getFeaturedProducts", parallel = true)
    public Products[] getFeaturedProducts() throws IOException {
        String productsJsonFilePath = "./json_files/products.json";
        return JacksonUtils.deserializeJson(productsJsonFilePath, Products[].class);
    }

    @DataProvider(name = "getCountryNames",parallel = true)
    public BillingCountries[] getCountryNames() throws IOException {
        String countryNameJsonFilePath = "./json_files/checkout_page_billing_country.json";
        return JacksonUtils.deserializeJson(countryNameJsonFilePath, BillingCountries[].class);
    }




}
