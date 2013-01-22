/**
 * @文件名称：StringUtil.java
 * @类路径：com.qqw.crm.biz.util
 * @版权:Copyright (c)2012
 * @公司名称：杭州商友全球网信息技术有限公司
 * @作者：lafeng
 * @时间：2012-5-7下午4:43:03
 */
package com.lafengmaker.core.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.lafengmaker.core.entity.User;
import com.lafengmaker.core.exception.UserException;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import net.sf.json.JSONArray;
/**
 * 
 * @描述：字符串处理的通用类
 * @部门：研发部
 * @作者：lafeng
 * @创建时间：2012-5-7下午4:46:09
 */
public class StringUtil{
	public static int getCount(String str, String reg) {
		int count = 0;
		int index = 0;
		while ((index = str.indexOf(reg, index)) != -1) {
			count++;
			index++;
		}
		return count;
	}

	public static String encodeSqlString(String sql) {
		String result = "";
		if (sql != null) {
			result = sql.replaceAll("'", "''");
		}
		return result;
	}

	public static String upcaseFirstLetter(String word) {
		String result = word;
		if ((word != null) && (word.length() > 0)) {
			result = word.substring(0, 1).toUpperCase() + word.substring(1);
		}
		return result;
	}

	public static int getLastsIndex(String word, String re, int times) {
		int result = -1;
		int count = getCount(word, re);
		if ((times < 0) || (times > count))
			return result;
		int index = word.length();
		while (times-- > 0) {
			index = word.lastIndexOf(re, index) - 1;
		}
		return index + 1;
	}

	public static String[] split(String str, String re) {
		if ((str == null) || (str.trim().length() == 0))
			return new String[0];
		if (str.endsWith(re))
			str = str.substring(0, str.length() - re.length());
		if (str.startsWith(re))
			str = str.substring(re.length());
		String[] strs = str.trim().split(re);
		for (int i = 0; i < strs.length; i++) {
			strs[i] = strs[i].trim();
		}
		return strs;
	}

	public static List split2List(String str, String re) {
		List list = new ArrayList();
		String[] results = str.split(re);
		for (int i = 0; i < results.length; i++){
			if(!isEmpty(results[i]))
			list.add(results[i]);
			
		}
		return list;
	}

	public static int getFirstNotCharIndex(String str, int from, char nch) {
		int index = -1;
		if ((str == null) || (from < 0) || (from > str.length()))
			return index;
		do {
			char ch = str.charAt(from);
			if (ch != nch) {
				index = from;
				break;
			}
			from++;
		} while (from < str.length());

		return index;
	}

	public static String string2Unicode(String message) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < message.length(); i++) {
			char c = message.charAt(i);
			if (c <= '?') {
				sb.append(c);
			} else {
				String hexString = Integer.toHexString(c);
				if (hexString.length() < 4) {
					while (hexString.length() < 4) {
						hexString = "0" + hexString;
					}
				}
				sb.append("&#x" + hexString + ";");
			}
		}
		return sb.toString();
	}

	public static String removeIfLast(String info, String last) {
		String result = info;
		if (info != null) {
			int index = info.lastIndexOf(last);
			if (index != -1)
				result = info.substring(0, index);
		}
		return result;
	}

	public static String array2String(String[] infos, String split, boolean pre) {
		StringBuffer sb = new StringBuffer();
		if (pre)
			sb.append(split);
		for (int i = 0; (infos != null) && (i < infos.length); i++)
			sb.append(infos[i] + split);
		return sb.toString();
	}

	public static List array2List(String[] infos) {
		List list = new ArrayList();
		for (int i = 0; (infos != null) && (i < infos.length); i++)
			list.add(infos[i]);
		return list;
	}

	public static String[] list2Array(List list) {
		if (list != null) {
			String[] array = new String[list.size()];
			for (int i = 0; i < list.size(); i++)
				array[i] = ((String) list.get(i));
			return array;
		}
		return null;
	}

	public static String list2String(List infos, String split) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; (infos != null) && (i < infos.size()); i++) {
			sb.append((String) infos.get(i));
			if (i < infos.size() - 1)
				sb.append(split);
		}
		return sb.toString();
	}
	public static String Set2String(Set<String> infos, String split){
		StringBuffer sb = new StringBuffer();
		if(null!=infos&&infos.size()>0){
			int i=0;
			for(String s:infos){
				if(i!=0){
					sb.append(split);
				}
				sb.append(s);
				i++;
			}
		}
		return sb.toString();
	}

	public static boolean isEmpty(String info) {
		return (info == null) || (info.trim().length() == 0);
	}

	public static String trim(String info, String t) {
		if ((info == null) || (info.length() <= t.length() * 2)) {
			return info;
		}
		if (info.startsWith(t))
			info = info.substring(t.length());
		if (info.endsWith(t))
			info = info.substring(0, info.length() - t.length());
		return info;
	}

	public static String repeat(String str, int count) {
		StringBuffer sb = new StringBuffer();
		while (count-- > 0)
			sb.append(str);
		return sb.toString();
	}

	public static String dictionary(String code, String defstr) {
		if ((code == null) || (defstr == null))
			return null;
		String[] defs = split(defstr, ";");
		for (String def : defs) {
			String[] infos = split(def, ":");
			if ((infos.length >= 2) && (code.equals(infos[0]))) {
				return infos[1];
			}
		}
		return code;
	}

	public static boolean isChinese(char c) {
		return (c >= '一') && (c <= 40869);
	}

//	public static String getStringOrder(String str) {
//		return getStringOrder(str, "");
//	}

//	public static String getStringOrder(String str, String split) {
//		if (isEmpty(str)) {
//			return str;
//		}
//		StringBuffer sb = new StringBuffer();
//		for (int i = 0; i < str.length(); i++) {
//			char c = str.charAt(i);
//			if (isChinese(c))
//				try {
//					String[] pinyins = PinyinHelper.toHanyuPinyinStringArray(c);
//					if ((pinyins != null) && (pinyins.length > 0)) {
//						sb.append(pinyins[0]);
//						if (isEmpty(split))
//							continue;
//						sb.append(split);
//						continue;
//					}
//					sb.append(c);
//				} catch (Exception e) {
//					sb.append(c);
//				}
//			else {
//				sb.append(c);
//			}
//		}
//		if ((sb.length() > 0) && (!isEmpty(split))) {
//			String lastChar = String.valueOf(sb.charAt(sb.length() - 1));
//			if (lastChar.equals(split))
//				sb.deleteCharAt(sb.length() - 1);
//		}
//		return sb.toString();
//	}

	public static String native2Ascii(String message) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < message.length(); i++) {
			char c = message.charAt(i);
			if (c <= '?') {
				sb.append(c);
			} else {
				String hexString = Integer.toHexString(c);
				if (hexString.length() < 4) {
					while (hexString.length() < 4) {
						hexString = "0" + hexString;
					}
				}
				sb.append("\\u" + hexString);
			}
		}
		return sb.toString();
	}

	public static String trim(String str, int specialCharsLength) {
		if ((str == null) || ("".equals(str)) || (specialCharsLength < 1)) {
			return "";
		}
		char[] chars = str.toCharArray();
		int charsLength = getCharsLength(chars, specialCharsLength);
		return new String(chars, 0, charsLength);
	}

	private static int getCharsLength(char[] chars, int specialCharsLength) {
		return getCharsLength(chars, specialCharsLength, 0);
	}

	private static int getCharsLength(char[] chars, int specialCharsLength,
			int startIndex) {
		int count = 0;
		int normalCharsLength = 0;
		for (int i = startIndex; i < chars.length; i++) {
			int specialCharLength = getSpecialCharLength(chars[i]);
			if (count > specialCharsLength - specialCharLength)
				break;
			count += specialCharLength;
			normalCharsLength++;
		}

		return normalCharsLength;
	}

	private static int getSpecialCharLength(char c) {
		if (isLetter(c)) {
			return 1;
		}
		return 2;
	}

	private static boolean isLetter(char c) {
		int k = 128;
		return c / k == 0;
	}
	 public static String[] stringToArray(String source)
	 /*     */   {
	 /* 287 */     StringTokenizer strcStr = new StringTokenizer(source, ",");
	 /* 288 */     int intNum = strcStr.countTokens();
	 /* 289 */     String[] strArray = new String[intNum];
	 /* 290 */     for (int i = 0; i < intNum; i++) {
	 /* 291 */       strArray[i] = strcStr.nextToken();
	 /*     */     }
	 /* 293 */     return strArray;
	 /*     */   }
	 /*     */ 
	 /*     */   public static Long[] stringToLongArray(String source) {
	 /* 297 */     String[] s = stringToArray(source);
	 /* 298 */     Long[] l = new Long[s.length];
	 /* 299 */     for (int i = 0; i < l.length; i++) {
	 /* 300 */       l[i] = getLong(s[i]);
	 /*     */     }
	 /* 302 */     return l;
	 /*     */   }
	 /*     */ 
	 /*     */   public static Long getLong(Object o) {
		 /*     */     try {
			 if(null==o){
				 return 0l;
			 }
		 /* 270 */       return Long.valueOf(Long.parseLong(o.toString())); } catch (Exception e) {
		 /*     */     }
		 /* 272 */     return Long.valueOf(0L);
		 /*     */   }


public static Long getLongnull(String o){
	if(null==o){
		return null;
	}else{
		try{
		return 	Long.valueOf(Long.parseLong(o.toString())); } catch (Exception e) {	e.printStackTrace();	}
		return null;
	}
}
public static boolean isListEmpty(List list){
	if(null!=list&&list.size()>0){
		return true;
	}else{
		return false;
	}
}
public static int fronStringtoInt(String str){
	if(!isEmpty(str)){
		try {
			Integer i=Integer.parseInt(str);
			return i.intValue();
		} catch (NumberFormatException e) {
			e.printStackTrace();
			return 0;
		}
	}else{
		return 0;
	}
	
}
public static Integer fronStringtoInteger(String str){
	if(!isEmpty(str)){
		try {
			Integer i=Integer.parseInt(str);
			return i;
		} catch (NumberFormatException e) {
			e.printStackTrace();
			return null;
		}
	}else{
		return null;
	}
	
}
public static Double fronStringtoDouble(String str){
	if(!isEmpty(str)){
		try {
		Double 	ddd=Double.parseDouble(str);
			return ddd;
		} catch (NumberFormatException e) {
			e.printStackTrace();
			return null;
		}
	}else{
		return null;
	}
	
}
public static Object getValue (Object o,String field){
	Class classType=o.getClass();
	String first=field.substring(0, 1).toUpperCase();
	String getName="get"+first+field.substring(1);
	Object value=null;
	try {
		Method getMethod=classType.getMethod(getName, new Class[]{});
		value=getMethod.invoke(o, new Object[]{});    

	} catch (Exception e) {
		
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return value;
}

public static Long stringToLong(String ss) {
	if(!isEmpty(ss)){
		try {
			Long l=Long.parseLong(ss);
			return l;
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0l;
		}
	}else{
		return 0l;
	}
}
public static String trim(String s){
	if(s!=null&&!"".equals(s.trim())){
		Pattern pattern = Pattern.compile("　");
		Matcher matcher = pattern.matcher(s);
		String tmp=matcher.replaceAll("");
		return tmp.trim();
		
		
	}else{
		return "";
	}
	
}
public static String toString(Object o){
	if(null!=o){
		return o.toString();
	}
	return null;
}
/**
 * 
 * @方法功能说明：list转换成字符串
 * @修改者名字：lafeng
 * @修改时间：2012-3-16下午06:35:45
 * @修改内容：
 * @参数：@param list
 * @参数：@return
 * @return:String
 * @throws
 */
public static String listtoJson(List list ){
	String json="";
	if(null!=list&&list.size()>0){
		JSONArray jsonarr=JSONArray.fromObject(list); 
		json=jsonarr.toString();
	}
	return json;
}
/**
 * 
 * @方法功能说明：防止汉字乱码，编码
 * @修改者名字: lafeng
 * @修改时间：2012-5-7下午1:32:54
 * @参数：@param s
 * @参数：@param locale
 * @参数：@return
 * @return:String
 */
public static String encode(String s,String locale){
	if(StringUtil.isEmpty(s))
		return null;
	try {
		return URLEncoder.encode( s,locale);
	} catch (UnsupportedEncodingException e) {
		// TODO Auto-generated catch block
		return null;
	}
}
/**
 * 
 * @方法功能说明：解码
 * @修改者名字: lafeng
 * @修改时间：2012-5-7下午4:47:50
 * @参数：@param s
 * @参数：@param locale
 * @参数：@return
 * @return:String
 */
public static String decode(String s,String locale){
	if(StringUtil.isEmpty(s)){
		return null;
	}
	try {
		return URLDecoder.decode(s, locale).trim();
	} catch (UnsupportedEncodingException e) {
		// TODO Auto-generated catch block
		return null;
	}
}
/**
 * 
 * @方法功能说明：字符串改成LongList
 * @修改者名字: lafeng
 * @修改时间：2012-5-8下午8:24:58
 * @参数：@param str
 * @参数：@param re
 * @参数：@return
 * @return:List<Long>
 */
public static List<Long> split2LongList(String str, String re) {
	List<Long> list = new ArrayList<Long>();
	String[] results = str.split(re);
	for (int i = 0; i < results.length; i++){
		if(!isEmpty(results[i]))
		list.add(getLong(results[i]));
		
	}
	return list;
}
public static String[] fromStringtoStringarr(String s){
	String[] res=new String[0];
	if(!isEmpty(s)){
		res=s.split(",");
	}
	return res;
}
public static String propertyPlaceHolderReplace( String content,Map<String, String> parammap) {
	if(!isEmpty(content)){
		Pattern pattern = Pattern.compile("\\$\\{(\\w+)\\}");
		Matcher matcher =pattern.matcher(content);
		while(matcher.find()){
			content=content.replace(matcher.group(), parammap.get(matcher.group(1)));
		}
	}
	return content;
}
public static void main(String[] args) {
//	String ss="您有一份快递已于${senddate}寄出，快递内容：${sendcontent}，发票单号：${excode}。请注意查收，或联系专属业务员。";
//	String ss2="您有一份快或联系专属业务员。";
//	Pattern pattern = Pattern.compile("\\$\\{(\\w+)\\}");
//	Matcher matcher =pattern.matcher(ss2);
////	System.out.println(matcher.groupCount());
//	while(matcher.find()){
//		System.out.println(matcher.group());
//		System.out.println(matcher.group(1));
//	}
//	int i=0;
//	while(matcher.find(i)){
//		System.out.println(matcher.group());
//		i++;
//	}
	try {
		System.out.println(encryptBASE64("2013-1-1".getBytes()));
		String date=StringUtil.readProperty("key", new User());
		//date="";
		System.out.println(DateUtil.formatStringTodate(StringUtil.decrypt(date), DateUtil.DATE));
		if(StringUtil.isEmpty(date)||!DateUtil.isDateBefore(new Date(), DateUtil.formatStringTodate(StringUtil.decrypt(date), DateUtil.DATE))){
			throw new UserException("已过期");
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
	
	
	public static Map getParamMap(){
		Map m=new HashMap();
		return m;
	}
	/***
	 * 读取SRC下配置文件的值
	 * @param key 键
	 * @param fileName 文件名
	 */
	public static String readProperty(String key,String fileName,Object o){
		Properties prop=new Properties();
		InputStream stream=o.getClass().getClassLoader().getResourceAsStream(fileName);
		try {
			prop.load(stream);
		} catch (IOException e){
		}
		String value=prop.getProperty(key);
		value=trim(value);
		return value;
	}
	public static String readProperty(String key,Object o){
		return readProperty(key, "day.properties", o);
	}
	public static boolean notHaveChar(String str ,String charstr){
		boolean f=true;
		if(!isEmpty(str)){
			if(str.indexOf(charstr)!=-1){
				f=false;
			}
		}else{
			f=false;
		}
		return f;
	}
	public static List<String>changODEStr2List(String s){
		List<String>list=new  ArrayList<String>();
//		@multi,1,3,2
		if(!isEmpty(s)){
			s=s.replace("@multi", "");
			String[] dd=s.split(",");
			if(null!=dd&&dd.length>0){
				for(String ss:dd){
					if(!isEmpty(ss))
					list.add(ss);
				}
			}
		}
		return list;
	}
	public static  boolean iszhixia(String areaid){
		if(!isEmpty(areaid)){
			int id=Integer.parseInt(areaid);
			if(id==15806||id==15834
					||id==15820||id==15809
					||id==15807||id==15814||id==15801){
				return true;
			}
			
		}
		return false;
	}
	public static String toStr(Object o){
		if(null!=o){
			return o.toString();
		}else{
			return "";
		}
	}
	public static boolean isDigit(String ss){
		if(!isEmpty(ss)){
			Pattern pattern = Pattern.compile("[0-9]*"); 
			return pattern.matcher(ss).matches(); 
		}
		return false;
	}
	/**
	 * 判断前一个字符串是否包含后一个字符串
	 * @方法功能说明：
	 * @修改者名字: lafeng
	 * @修改时间：2012-11-21下午4:23:28
	 * @参数：@param s1
	 * @参数：@param s2
	 * @参数：@return
	 * @return:boolean
	 */
	public static boolean Contain(String s1,String s2){
		if (isEmpty(s1)||isEmpty(s2)) {
			return false;
		}else{
			if(s1.indexOf(s2)!=-1){
				return true;
			}
		}
		return false;
	}
	public static String decrypt(String key) {
		try {
			return new String((new BASE64Decoder()).decodeBuffer(key));
		} catch (IOException e) {
			return "";
		}
	}
	/** * BASE64解密 * @param key * @return * @throws Exception */
	public static byte[] decryptBASE64(String key) throws Exception {
		return (new BASE64Decoder()).decodeBuffer(key);
	}

	/** * BASE64加密 * @param key * @return * @throws Exception */
	public static String encryptBASE64(byte[] key) throws Exception {
		return (new BASE64Encoder()).encodeBuffer(key);
	}
}
