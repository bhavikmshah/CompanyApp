package com.miles.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by bhavi on 3/7/2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Company {

    private String companyName;
    private String companyPopularName;
    private String companyCode;
    private String securitySymbol;
    private String brandName;
    private String brandCode;
    private String giftItemCode;


    private Quote quote;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyPopularName() {
        return companyPopularName;
    }

    public void setCompanyPopularName(String companyPopularName) {
        this.companyPopularName = companyPopularName;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getSecuritySymbol() {
        return securitySymbol;
    }

    public void setSecuritySymbol(String securitySymbol) {
        this.securitySymbol = securitySymbol;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getBrandCode() {
        return brandCode;
    }

    public void setBrandCode(String brandCode) {
        this.brandCode = brandCode;
    }

    public Quote getQuote() {
        return quote;
    }

    public void setQuote(Quote quote) {
        this.quote = quote;
    }

    public String getGiftItemCode() {
        return giftItemCode;
    }

    public void setGiftItemCode(String giftItemCode) {
        this.giftItemCode = giftItemCode;
    }
}


