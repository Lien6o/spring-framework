package org.springframework.mytest;

import org.springframework.core.env.StandardEnvironment;


/**
 * @author: Lien6o
 * @description:
 * @date: 2020/1/14 3:41 下午
 * @version: v1.0
 */
public class EnvTry {
	public static void main(String[] args) {
		StandardEnvironment standardEnvironment = new StandardEnvironment();
		System.out.println(standardEnvironment.getSystemEnvironment());
		System.out.println(standardEnvironment.toString());
	}
}
