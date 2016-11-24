package com.codejstudio.service.util;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;


public class CustomDateSerializer extends JsonSerializer<Date> { 
	
	
	@Override
	public void serialize(Date value, JsonGenerator jgen,SerializerProvider provider)
			throws IOException,JsonProcessingException { 
		 
		TimeZone tz = TimeZone.getTimeZone("UTC");
	    DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
	    df.setTimeZone(tz);
	    String nowAsISO = df.format(value); 
		jgen.writeString(nowAsISO);
		return;
	} 

}




