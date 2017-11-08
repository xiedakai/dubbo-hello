package com.emep.dubbo.demo.utils;  
  
import java.io.File;
import java.io.FileInputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import redis.clients.jedis.Jedis;  
import redis.clients.jedis.JedisPool;  
import redis.clients.jedis.JedisPoolConfig;  
  
/**    
 * Redis操作接口 
 * 
 * @version 1.0 2013-6-14 上午08:54:14    
 */  
public class RedisUtil2 {
    private static JedisPool pool = null;
    public static String host = ""; // 连接mongodb的IP
    public static String port = "";
    public static boolean HasInit = false;
    
    static
    {
        try {
            if(HasInit == false)
            {
               // File file = new File(Thread.currentThread().getContextClassLoader().getResource("redis.properties").getFile());
                Properties properties = new Properties();
                properties.load(RedisUtil2.class.getResourceAsStream("/redis.properties"));
                //properties.load(new FileInputStream(file));
                host = properties.getProperty("redis.host");
                port = properties.getProperty("redis.port"); 
                HasInit = true;
            }
        } catch (Exception e) {
        	e.printStackTrace();
        }
    }
      
    /** 
     * 构建redis连接池 
     *  
     * @param ip 
     * @param port 
     * @return JedisPool 
     */  
    public static JedisPool getPool() {  
        if (pool == null) {  
            JedisPoolConfig config = new JedisPoolConfig();  
            //控制一个pool可分配多少个jedis实例，通过pool.getResource()来获取；  
            //如果赋值为-1，则表示不限制；如果pool已经分配了maxActive个jedis实例，则此时pool的状态为exhausted(耗尽)。  
            //config.setMaxActive(500);  
            //控制一个pool最多有多少个状态为idle(空闲的)的jedis实例。  
            config.setMaxIdle(5);
            config.setMaxWaitMillis(24*3600*3);
            //表示当borrow(引入)一个jedis实例时，最大的等待时间，如果超过等待时间，则直接抛出JedisConnectionException；  
           // config.setMaxWait(100000l);  
            //在borrow一个jedis实例时，是否提前进行validate操作；如果为true，则得到的jedis实例均是可用的；  
            config.setTestOnBorrow(true);  
            pool = new JedisPool(config, host, Integer.parseInt(port));
        }  
        return pool;  
    }  
      
    /** 
     * 返还到连接池 
     *  
     * @param pool  
     * @param redis 
     */  
    public static void returnResource(JedisPool pool, Jedis redis) {  
        if (redis != null) {  
            pool.returnResource(redis);  
        }  
    }  
      
    /** 
     * 获取数据 
     *  
     * @param key 
     * @return 
     */  
    public static String get(String key){  
        String value = null;  
          
        JedisPool pool = null;  
        Jedis jedis = null;  
        try {  
            pool = getPool();  
            jedis = pool.getResource();  
            value = jedis.get(key);
        } catch (Exception e) {  
            //释放redis对象  
            pool.returnBrokenResource(jedis);  
            e.printStackTrace();  
        } finally {  
            //返还到连接池  
            returnResource(pool, jedis);  
        }  
          
        return value;  
    }
    
    /** 
     * 获取数据 
     *  
     * @param key 
     * @return 
     */  
    public static String set(String key,String value){  
          
        JedisPool pool = null;  
        Jedis jedis = null;  
        try {  
            pool = getPool();  
            jedis = pool.getResource();  
            jedis.set(key,value);
        } catch (Exception e) {  
            //释放redis对象  
            pool.returnBrokenResource(jedis);  
            e.printStackTrace();  
        } finally {  
            //返还到连接池  
            returnResource(pool, jedis);  
        }  
          
        return value;  
    }
    
    public static void delete(String key){
        JedisPool pool = null;  
        Jedis jedis = null;  
        try {  
            pool = getPool();  
            jedis = pool.getResource();
            jedis.del(key);
        } catch (Exception e) {  
            //释放redis对象  
            pool.returnBrokenResource(jedis);  
            e.printStackTrace();  
        } finally {  
            //返还到连接池  
            returnResource(pool, jedis);  
        }  
    }
    
    /** 
     * 获取数据 
     *  
     * @param key 
     * @return 
     */  
    public static void setMap(String key,Map<String,String> map){    
        JedisPool pool = null;  
        Jedis jedis = null;  
        try {  
            pool = getPool();  
            jedis = pool.getResource();  
            jedis.hmset(key,map);  
        } catch (Exception e) {  
            //释放redis对象  
            pool.returnBrokenResource(jedis);  
            e.printStackTrace();  
        } finally {  
            //返还到连接池  
            returnResource(pool, jedis);  
        } 
    }
    
    /** 
     * 获取数据 
     *  
     * @param key 
     * @return 
     */  
    public static Map<String,String> getMap(String key){  
    	Map<String,String> value = null;  
          
        JedisPool pool = null;  
        Jedis jedis = null;  
        try {  
            pool = getPool();  
            jedis = pool.getResource();  
            value = jedis.hgetAll(key);  
        } catch (Exception e) {  
            //释放redis对象  
            pool.returnBrokenResource(jedis);  
            e.printStackTrace();  
        } finally {  
            //返还到连接池  
            returnResource(pool, jedis);  
        }  
          
        return value;  
    }
    
    public static void deleteMap(String key){
        JedisPool pool = null;  
        Jedis jedis = null;  
        try {  
            pool = getPool();  
            jedis = pool.getResource();
            jedis.del(key);
        } catch (Exception e) {  
            //释放redis对象  
            pool.returnBrokenResource(jedis);  
            e.printStackTrace();  
        } finally {  
            //返还到连接池  
            returnResource(pool, jedis);  
        }  
    }
    public static void main(String[] args) {
	}
}  