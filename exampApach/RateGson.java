package com.free.retrofitex.exampApach;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.http.HttpEntity;

/**
 * Created by free on 14.11.14.
 */
public class RateGson {

    @JsonProperty("query")
    String query;
//    @JsonProperty("rate")
//    String rate;
//    @JsonProperty("name")
//    String name;

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public RateGson() {
    }

    public RateGson(String query) {
        this.query = query;
    }

    @Override
    public String toString() {
        return "RateGson{" +
                "query='" + query + '\'' +
                '}';
    }
    //    public String getRate() {
//        return rate;
//    }
//
//    public void setRate(String rate) {
//        this.rate = rate;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
}
