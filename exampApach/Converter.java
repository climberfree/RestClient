package com.free.retrofitex.exampApach;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

/**
 * Created by free on 14.11.14.
 */
public class Converter {

    private final static String baseFile = "rate.json";

    public static void toJSON(RateGson rateGson) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File(baseFile), rateGson);
        System.out.println("json created!");
    }

    public static String toJavaObject(String str) throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        return mapper.readValue(str, String.class);
    }

}
