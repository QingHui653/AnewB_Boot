package com.newb;

import java.util.ArrayList;
import java.util.List;

public class formot {
	public static String listToString(List<String> stringList) {
		if (stringList == null) {
			return null;
		}
		StringBuilder result = new StringBuilder();
		boolean flag = false;
		for (String string : stringList) {
			if (flag) {
				result.append(",");
			} else {
				flag = true;
			}
			result.append(string);
		}
		return result.toString();
	}
	
	
	public static void main(String[] args) {
		List<String> bookList =new ArrayList<>();
		
		bookList.add("111111");
		bookList.add("222222");
		bookList.add("333333");
		
		String sql =listToString(bookList);
		
		System.out.println(sql);
	}
}
