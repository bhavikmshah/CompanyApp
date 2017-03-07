package com.miles.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

/**
 * Created by bhavi on 3/7/2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CompanyWrapper {
    List<Company> result;

    public List<Company> getResult() {
        return result;
    }

    public void setResult(List<Company> result) {
        this.result = result;
    }
}
