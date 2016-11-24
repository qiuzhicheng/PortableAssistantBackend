package com.codejstudio.common;
 

import java.util.Date;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import com.whalin.MemCached.MemCachedClient;
import com.whalin.MemCached.SockIOPool;

public class MemcacheHelper { 
	private static Logger log = LoggerFactory.getLogger(MemcacheHelper.class);
       
    protected static MemCachedClient mcc;  
      
    private MemcacheHelper() {  
    }  
    
    public static boolean isAvailable(){
    	return mcc != null;
    }
       
    static {
    	try{
	    	Map<String,String> memCfg = ResourceHelper.list("/memcache.properties");  
	    	
	        String[] servers = { memCfg.get("memcache.server") };  
	          
	        /* 设置缓存大小 */  
	        Integer[] weights = { 2 };  
	          
	        /* 拿到一个连接池的实例 */  
	        SockIOPool pool = SockIOPool.getInstance();  
	          
	        /* 注入服务器组信息 */  
	        pool.setServers(servers);  
	        pool.setWeights(weights);  
	          
	        /* 配置缓冲池的一些基础信息 */  
	        pool.setInitConn(Integer.valueOf(memCfg.get("memcache.initConn")) );  
	        pool.setMinConn(Integer.valueOf(memCfg.get("memcache.minConn")) );  
	        pool.setMaxConn(Integer.valueOf(memCfg.get("memcache.maxConn")) );  
	        pool.setMaxIdle(1000 * 60 * 60 * Integer.valueOf(memCfg.get("memcache.maxIdel")));  
	          
	        /* 设置线程休眠时间 */  
	        pool.setMaintSleep(Integer.valueOf(memCfg.get("memcache.maintSleep")));  
	          
	        /* 设置关于TCP连接 */  
	        pool.setNagle(Boolean.valueOf(memCfg.get("memcache.nagel")));// 禁用nagle算法  
	        pool.setSocketConnectTO(0);  
	        pool.setSocketTO(Integer.valueOf(memCfg.get("memcache.socketTO")));// 3秒超时  
	          
	        /* 初始化 */  
	        pool.initialize();  
	        
	        mcc = new MemCachedClient();
	        mcc.setPrimitiveAsString(true);
    	}catch(Exception e){
    		log.error("memcache init error");
    		if (log.isInfoEnabled()){
    			e.printStackTrace();
    		}
    	}
    }  
      
    public static boolean set(String key, Object value) {  
        return mcc.set(key, value);  
    }  
    
    public static boolean set(String key,Object value,Date expire){
    	return mcc.set(key,value,expire); 
    }
    
    public static long inc(String key){
    	return mcc.incr(key);
    }
     
      
    public static Object get(String key) {  
        return mcc.get(key);  
    }  
     
}
