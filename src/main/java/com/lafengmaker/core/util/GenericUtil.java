package com.lafengmaker.core.util;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.lafengmaker.core.entity.User;

public class GenericUtil {
	@SuppressWarnings("rawtypes")
	public static Class getEntityClass(Class clazz, int index){
		Type genType = clazz.getGenericSuperclass();//�õ����͸���  
        //���û��ʵ��ParameterizedType�ӿڣ�����֧�ַ��ͣ�ֱ�ӷ���Object.class   
        if (!(genType instanceof ParameterizedType)) {
            return Object.class;   
        }  
        //���ر�ʾ������ʵ�����Ͳ����Type���������,������ŵĶ��Ƕ�Ӧ���͵�Class, ��BuyerServiceBean extends DaoSupport<Buyer,Contact>�ͷ���Buyer��Contact����   
        Type[] params = ((ParameterizedType) genType).getActualTypeArguments();                   
        if (index >= params.length || index < 0) { 
        	 throw new RuntimeException("�����������"+ (index<0 ? "����С��0" : "�����˲��������"));
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
