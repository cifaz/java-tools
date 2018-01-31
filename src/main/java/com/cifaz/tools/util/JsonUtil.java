package com.cifaz.tools.util;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.text.SimpleDateFormat;

import static com.fasterxml.jackson.databind.DeserializationFeature.*;

public class JsonUtil {
    private static final Logger logger = LoggerFactory.getLogger(JsonUtil.class);
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();


    private JsonUtil() {
    }

    public static ObjectMapper getObjectMapper() {
        return OBJECT_MAPPER;
    }

    public static <T> T json2GenericObject(String jsonString, TypeReference<T> tr) {
        if (!StringUtils.isBlank(jsonString)) {
            try {
                return OBJECT_MAPPER.readValue(jsonString, tr);
            } catch (Exception var3) {
                logger.warn("json error:" + var3.getMessage());
            }
        }

        return null;
    }

    public static String toJson(Object object) {
        try {
            return null == object ? "" : OBJECT_MAPPER.writeValueAsString(object);
        } catch (Exception var2) {
            logger.warn("json error:" + var2.getMessage());
            return "";
        }
    }

    public static Object json2Object(String jsonString, Class<?> c) {
        if (!StringUtils.isBlank(jsonString)) {
            try {
                return OBJECT_MAPPER.readValue(jsonString, c);
            } catch (Exception var3) {
                logger.warn("json error:" + var3.getMessage());
            }
        }

        return null;
    }

    public static boolean isValidJson(String json) {
        boolean valid = false;

        try {
            JsonParser parser = (new ObjectMapper()).getFactory().createParser(json);

            while (parser.nextToken() != null) {
            }

            valid = true;
            return valid;
        } catch (JsonParseException var3) {
            return valid;
        } catch (IOException var4) {
            return valid;
        }
    }

    static {
        OBJECT_MAPPER.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        OBJECT_MAPPER.configure(FAIL_ON_UNKNOWN_PROPERTIES, false);
        OBJECT_MAPPER.getSerializerProvider().setNullKeySerializer(new JsonSerializer<Object>() {
            public void serialize(Object paramT, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider) throws IOException, JsonProcessingException {
                paramJsonGenerator.writeString("");
            }
        });
        OBJECT_MAPPER.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        OBJECT_MAPPER.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
    }
}
