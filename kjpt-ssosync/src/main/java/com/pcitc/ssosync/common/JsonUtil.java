package com.pcitc.ssosync.common;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.IOException;

public class JsonUtil {

    public static <T> T stringToObject(String json, Class<T> clazz) throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        //在序列化时日期格式默认为 yyyy-MM-dd'T'HH:mm:ss.SSSZ
        mapper.configure(DeserializationFeature.READ_DATE_TIMESTAMPS_AS_NANOSECONDS, false);

        return mapper.readValue(json, clazz);

    }

    public static String ObjectToString(Object obj) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();

        //在序列化时日期格式默认为 yyyy-MM-dd'T'HH:mm:ss.SSSZ
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);

        return mapper.writeValueAsString(obj);

    }
}