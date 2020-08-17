package com.dev.core.util;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Description: 定义Timestamp的输出格式
 * @Author lvcy
 * @Date 2020/5/28
 **/
@Component
public class JsonTimeSerializer extends JsonSerializer<Date> {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Override
    public void serialize(Date date, JsonGenerator gen, SerializerProvider provider) throws IOException {
        String formattedDate = dateFormat.format(date);
        gen.writeString(formattedDate);
    }
}
