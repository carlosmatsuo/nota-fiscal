package com.nota.fiscal.util;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.nota.fiscal.model.entity.MyMessage;

public class Util {

	public static MyMessage jsonToObj(String json) throws Exception {

		try {

			ObjectMapper objectMapper = new ObjectMapper();
			objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
			objectMapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
			objectMapper.configure(DeserializationFeature.USE_LONG_FOR_INTS, true);

			MyMessage obj = objectMapper.readValue(json, MyMessage.class);

			return obj;

		} catch (Exception e) {
			throw e;
		}

	}

	public static String objToJson(MyMessage obj) throws Exception {

		try {

			try {

				ObjectMapper mapper = new ObjectMapper();
				mapper.enable(SerializationFeature.INDENT_OUTPUT);

				return mapper.writeValueAsString(obj);

			} catch (Exception e) {
				e.printStackTrace();
			}

			return null;

		} catch (Exception e) {
			throw e;
		}

	}

}
