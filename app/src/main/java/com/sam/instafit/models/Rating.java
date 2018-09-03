package com.sam.instafit.models;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Rating implements Serializable {

    @SerializedName("loves_count")
    @Expose
    private Integer lovesCount;
    @SerializedName("hates_count")
    @Expose
    private Integer hatesCount;
    @SerializedName("votes")
    @Expose
    private Integer votes;
    @SerializedName("rate")
    @Expose
    private Double rate;

    public Integer getLovesCount() {
        return lovesCount;
    }

    public void setLovesCount(Integer lovesCount) {
        this.lovesCount = lovesCount;
    }

    public Integer getHatesCount() {
        return hatesCount;
    }

    public void setHatesCount(Integer hatesCount) {
        this.hatesCount = hatesCount;
    }

    public Integer getVotes() {
        return votes;
    }

    public void setVotes(Integer votes) {
        this.votes = votes;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

}