package com.lafengmaker.core.util;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.lafengmaker.core.entity.User;

public class GenericUtil {
	@SuppressWarnings("rawtypes")
	public static Class getEntityClass(Class clazz, int index){
		Type genType = clazz.getGenericSuperclass();//得到泛型父类  
        //如果没有实现ParameterizedType接口，即不支持泛型，直接返回Object.class   
        if (!(genType instanceof ParameterizedType)) {
            return Object.class;   
        }  
        //返回表示此类型实际类型参数的Type对象的数组,数组里放的都是对应类型的Class, 如BuyerServiceBean extends DaoSupport<Buyer,Contact>就返回Buyer和Contact类型   
        Type[] params = ((ParameterizedType) genType).getActualTypeArguments();                   
        if (index >= params.length || index < 0) { 
        	 throw new RuntimeException("你输入的索引"+ (index<0 ? "不能小于0" : "超出了参数的总数"));
        }      
        if (!(params[index] instanceof Class)) {
            return Object.class;   
        }   
        return (Class) params[index];  
	}
	@SuppressWarnings("rawtypes")
	public static Class getSuperClassGenricType(Class clazz) {
    	return getEntityClass(clazz,0);
    }
	public static void main(String[] args) {
//		BaseDaoImpl<User> b=new BaseDaoImpl<User>();
		List<User>u=new ArrayList<User>();
//		BaseDao<User>b=new BaseDaoImpl<User>();
		System.out.println(getSuperClassGenricType(u.getClass()));
	}
}
