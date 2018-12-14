package com.incidents.util;

public class Util {

	public static String getMethodName() {
		String methodName = Thread.currentThread().getStackTrace()[2].getMethodName();
		System.out.println("methodName = " + methodName);
		return methodName;
	}
}
