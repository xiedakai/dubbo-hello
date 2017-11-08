package com.emep.dubbo.demo.utils;

import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

import org.apache.commons.codec.binary.Base64;

public class DESUtil{
	 private static String strDefaultKey = "!~@!!!$%=-^&*()trrfdas34ljfr好sja@#8$%dfkl;js&4*abcdef大家好，你懂的";
    //算法名称/加密模式/填充方式 
    //DES共有四种工作模式-->>ECB：电子密码本模式、CBC：加密分组链接模式、CFB：加密反馈模式、OFB：输出反馈模式
    private static final String CIPHER_ALGORITHM = "DES/ECB/NoPadding";

    /**
     *   
     * 生成密钥key对象
     * @param KeyStr 密钥字符串 
     * @return 密钥对象 
     * @throws InvalidKeyException   
     * @throws NoSuchAlgorithmException   
     * @throws InvalidKeySpecException   
     * @throws Exception 
     */
    private static SecretKey keyGenerator(String keyStr) throws Exception {
        byte input[] = HexString2Bytes(keyStr);
        DESKeySpec desKey = new DESKeySpec(input);
        //创建一个密匙工厂，然后用它把DESKeySpec转换成
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
        SecretKey securekey = keyFactory.generateSecret(desKey);
        return securekey;
    }

    private static int parse(char c) {
        if (c >= 'a') return (c - 'a' + 10) & 0x0f;
        if (c >= 'A') return (c - 'A' + 10) & 0x0f;
        return (c - '0') & 0x0f;
    }

    // 从十六进制字符串到字节数组转换 
    private static byte[] HexString2Bytes(String hexstr) {
        byte[] b = new byte[hexstr.length() / 2];
        int j = 0;
        for (int i = 0; i < b.length; i++) {
            char c0 = hexstr.charAt(j++);
            char c1 = hexstr.charAt(j++);
            b[i] = (byte) ((parse(c0) << 4) | parse(c1));
        }
        return b;
    }
    private static String getEncryptedData(String data){
		int pad = data.length()%8;
		for(int i=0;i<(8-pad);i++) 
			data += " ";
		return data;
    }

    /** 
     * 加密数据
     * @param data 待加密数据
     * @param key 密钥
     * @return 加密后的数据 
     */
    private static String encrypt(String data) throws Exception {
        Key deskey = keyGenerator(strDefaultKey);
        // 实例化Cipher对象，它用于完成实际的加密操作
        Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
        SecureRandom random = new SecureRandom();
        // 初始化Cipher对象，设置为加密模式
        cipher.init(Cipher.ENCRYPT_MODE, deskey, random);
        data=getEncryptedData(data);
        byte[] results = cipher.doFinal(data.getBytes());
        // 执行加密操作。加密后的结果通常都会用Base64编码进行传输 
        return new String(Base64.encodeBase64(results),"utf8").replaceAll("=", ":");
    }
 
    /** 
     * 解密数据 
     * @param data 待解密数据 
     * @param key 密钥 
     * @return 解密后的数据 
     */
    private static String decrypt(String data) throws Exception {
    	data=data.replaceAll(":", "=");
        Key deskey = keyGenerator(strDefaultKey);
        Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
        //初始化Cipher对象，设置为解密模式
        cipher.init(Cipher.DECRYPT_MODE, deskey);
        // 执行解密操作
        return new String(cipher.doFinal(Base64.decodeBase64(data.getBytes())),"utf8");
    }
    /**
     * 获取用户的身份标识token,validMinute分钟内token有效，否则过期
     * @param userAcoount 用户账号
     * @param validMinute 分钟
     * @return
     */
    public static String getToken(String userAcoount,int validMinute){
    	try {
    		userAcoount=userAcoount+"&"+(System.currentTimeMillis()+validMinute * 60L *1000L);//账号加时间戳加密，用&号区别
    		System.out.println("原文: " + userAcoount);
			return encrypt(userAcoount);
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return null;
    }
    /**
     * 验证token是否过期，账号与token不匹配时也算过期
     * @param token 身份标识token
     * @param userAcoount 用户账号
     * @return
     */
    public static boolean validaToken(String token,String userAcoount){
    	boolean flag=false;
    	try {
    		 String decrypt = decrypt(token);
    		 String oldUserAcoount = decrypt.substring(0, decrypt.indexOf('&'));
    		 Long tokenTime =Long.parseLong(decrypt.substring(decrypt.indexOf('&')+1).trim());
    		 long currentTime = System.currentTimeMillis();
    		 if(oldUserAcoount.equals(userAcoount)&&currentTime<tokenTime){
    			 flag=true;
    		 }
    	} catch (Exception e) {
    		flag=false;
    		e.printStackTrace();
    	}
    	return flag;
    }

    public static void main(String[] args) throws Exception {
    	System.out.println(System.currentTimeMillis());
        System.out.println("加密后: " + DESUtil.getToken("18903460463",10080));
        boolean validaToken = DESUtil.validaToken("6f8xqFWcNFbLLXbV6F+dU1t43Cust17YUmtVNeAQOns:","18903460463");
      System.out.println(validaToken);
      System.out.println(System.currentTimeMillis());
    }
}