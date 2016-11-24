package com.codejstudio.common.safe;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;



public class ResponseJSON extends JSONObject{ 
    /**
     * 
     */
    private static final long serialVersionUID = -5699393074713564165L; 

    private static Logger logger = LoggerFactory.getLogger(ResponseJSON.class);

    public static ResponseJSON toResponseJSON(Object obj){
	ResponseJSON r = new ResponseJSON();
	toResponseJSON(r,obj);
	return r;
    }

    public static ResponseJSON toResponseJSON(ResponseJSON r,Object obj){
	ObjectMapper mapper = new ObjectMapper();
	String jsonStr = "";
	try {
	    jsonStr = mapper.writeValueAsString(obj);
	} catch (JsonProcessingException e) {
	    logger.error("error msg :....................");
	    logger.error(e.getLocalizedMessage());
	    return new ResponseJSON();
	} catch (IOException e) {
	    logger.error("error msg :....................");
	    logger.error(e.getLocalizedMessage());
	    return new ResponseJSON();
	}
	JSONObject json	= JSONObject.parseObject(jsonStr);
	Set<String> keyString = json.keySet();
	Iterator<String> keyIterator = keyString.iterator();
	while(keyIterator.hasNext()){
	    String tempKey = keyIterator.next();
	    Object v = json.get(tempKey);
	    if(null!=v){
		r.put(tempKey, v);
	    }

	}
	return r;
    }


}
