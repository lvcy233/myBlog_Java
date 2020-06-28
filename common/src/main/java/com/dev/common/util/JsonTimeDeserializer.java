package com.dev.common.util;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Description: TODO
 * @Author lvcy
 * @Date 2020/5/28
 **/

@Component
public class JsonTimeDeserializer extends JsonDeserializer<Date> {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Override
    public Date deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
        String dateStr = jp.getText();
        if (dateStr == null)
            return null;
        else {
            try {
                return dateFormat.parse(dateStr);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
