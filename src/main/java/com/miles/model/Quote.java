package com.miles.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by bhavi on 3/7/2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Quote {
    private float price;
    private float open;
    private float close;
    private float dayLow;
    private float dayHigh;

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getOpen() {
        return open;
    }

    public void setOpen(float open) {
        this.open = open;
    }

    public float getClose() {
        return close;
    }

    public void setClose(float close) {
        this.close = close;
    }

    public float getDayLow() {
        return dayLow;
    }

    public void setDayLow(float dayLow) {
        this.dayLow = dayLow;
    }

    public float getDayHigh() {
        return dayHigh;
    }

    public void setDayHigh(float dayHigh) {
        this.dayHigh = dayHigh;
    }
}
