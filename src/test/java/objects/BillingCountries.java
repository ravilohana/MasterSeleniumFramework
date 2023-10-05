package objects;

import utils.JacksonUtils;

import java.io.IOException;

public class BillingCountries {

    private String countryName;
    private String stateName;

    private String zipCode;

    public BillingCountries(){}



    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }


    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public BillingCountries(String  countryName, String stateName,String zipCode) throws IOException {
        String countriesJsonFilePath = "./json_files/checkout_page_billing_country.json";
        BillingCountries[] billingCountries = JacksonUtils.deserializeJson(countriesJsonFilePath,BillingCountries[].class);
        for (BillingCountries country: billingCountries) {
            if (country.getCountryName().equals(countryName)) {
                this.countryName = countryName;
                this.stateName = stateName;
                this.zipCode = zipCode;
                break;
            }
        }
    }
}
