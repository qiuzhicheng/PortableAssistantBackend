package com.codejstudio.common.converter;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.util.FileCopyUtils;

/** 
 * @Description: 继承StringHttpMessageConverter
 * 				   将springMvc中json格式为由默认的
 * 				 ISO-8859-1改为UTF-8
 * @author Marco
 * @date 2015年6月11日 下午5:22:25
 *
 */
public class UTF8StringHttpMessageConverter extends StringHttpMessageConverter { 
	
	private static String charSet = "UTF-8";

	private static final MediaType utf8 = new MediaType("text","plain",Charset.forName(charSet)); 

	private boolean writeAcceptCharset = true; 
	
	@Override 
	protected MediaType getDefaultContentType(String dumy) { 

		return utf8; 

	} 

	protected List<Charset> getAcceptedCharsets() { 

		return Arrays.asList(utf8.getCharSet()); 

	} 
	protected void writeInternal(String s, HttpOutputMessage outputMessage) 

			throws IOException { 

		if (this.writeAcceptCharset) { 

			outputMessage.getHeaders().setAcceptCharset(getAcceptedCharsets()); 

		} 
		Charset charset = utf8.getCharSet(); 

		FileCopyUtils.copy(s, new OutputStreamWriter(outputMessage.getBody(), 

				charset)); 

	} 

	public boolean isWriteAcceptCharset() { 

		return writeAcceptCharset; 

	} 

	public void setWriteAcceptCharset(boolean writeAcceptCharset) { 

		this.writeAcceptCharset = writeAcceptCharset; 

	}

	public static String getCharSet() {
		return charSet;
	}

	public static void setCharSet(String charSet) {
		UTF8StringHttpMessageConverter.charSet = charSet;
	}

	public void setCharSet(Object arg0) {
		UTF8StringHttpMessageConverter.charSet = (String) arg0;
		
	} 

	
} 
