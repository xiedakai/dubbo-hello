package com.emep.dubbo.demo.utils;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

public class PinYinUtils {
	
	/**
	 * 拼音转换
	 * @param inputString
	 * @return
	 */
    public static String getPinYin(String companyName,String companyNameShort) {  
        
        HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();  
        format.setCaseType(HanyuPinyinCaseType.LOWERCASE);  
        format.setToneType(HanyuPinyinToneType.WITHOUT_TONE);  
        format.setVCharType(HanyuPinyinVCharType.WITH_U_UNICODE);  
  
        char[] companyNameInput = companyName.trim().replaceAll("[^\u4e00-\u9fa5]", "").toCharArray();
        char[] companyNameShortInput = companyNameShort.trim().replaceAll("[^\u4e00-\u9fa5]", "").toCharArray();
        StringBuffer output = new StringBuffer("");  
  
        try {  
            for (int i = 0; i < companyNameInput.length; i++) {  
                    String[] temp = PinyinHelper.toHanyuPinyinStringArray(companyNameInput[i], format);  
                    output.append(temp[0]);  
            }
            output.append("_");
            for (int i = 0; i < companyNameInput.length; i++) {  
                String[] temp = PinyinHelper.toHanyuPinyinStringArray(companyNameInput[i], format);  
                output.append(temp[0].charAt(0));  
            }
            if(companyNameShort!=null&&!companyNameShort.equals(null)&&!companyNameShort.equals("")){
	            output.append("_");
	            for (int i = 0; i < companyNameShortInput.length; i++) {  
	                String[] temp = PinyinHelper.toHanyuPinyinStringArray(companyNameShortInput[i], format);  
	                output.append(temp[0]);
	            }
	            output.append("_");
	            for (int i = 0; i < companyNameShortInput.length; i++) {  
	                String[] temp = PinyinHelper.toHanyuPinyinStringArray(companyNameShortInput[i], format);  
	                output.append(temp[0].charAt(0));  
	            }
            }
        } catch (BadHanyuPinyinOutputFormatCombination e) {  
            e.printStackTrace();  
        }  
        return output.toString();  
    }

}
