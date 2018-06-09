package com.mannydev.wexhelperpro.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Pair {

    @SerializedName("high")
    @Expose
    private Double high;
    @SerializedName("low")
    @Expose
    private Double low;
    @SerializedName("avg")
    @Expose
    private Double avg;
    @SerializedName("vol")
    @Expose
    private Double vol;
    @SerializedName("vol_cur")
    @Expose
    private Double volCur;
    @SerializedName("last")
    @Expose
    private Double last;
    @SerializedName("buy")
    @Expose
    private Double buy;
    @SerializedName("sell")
    @Expose
    private Double sell;
    @SerializedName("updated")
    @Expose
    private Integer updated;

    public Double getHigh() {
        return high;
    }

    public void setHigh(Double high) {
        this.high = high;
    }

    public Double getLow() {
        return low;
    }

    public void setLow(Double low) {
        this.low = low;
    }

    public Double getAvg() {
        return avg;
    }

    public void setAvg(Double avg) {
        this.avg = avg;
    }

    public Double getVol() {
        return vol;
    }

    public void setVol(Double vol) {
        this.vol = vol;
    }

    public Double getVolCur() {
        return volCur;
    }

    public void setVolCur(Double volCur) {
        this.volCur = volCur;
    }

    public Double getLast() {
        return last;
    }

    public void setLast(Double last) {
        this.last = last;
    }

    public Double getBuy() {
        return buy;
    }

    public void setBuy(Double buy) {
        this.buy = buy;
    }

    public Double getSell() {
        return sell;
    }

    public void setSell(Double sell) {
        this.sell = sell;
    }

    public Integer getUpdated() {
        return updated;
    }

    public void setUpdated(Integer updated) {
        this.updated = updated;
    }

}
