package org.springframework.lienbo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author: Lien6o
 * @description:
 * @date: 2019/12/23 5:08 下午
 * @version: v1.0
 */
public class CoreEntry {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

		TryAutowiredMap map = (TryAutowiredMap) context.getBean("tryAutowiredMap");
		System.err.println(map.toString());
		Thread.interrupted();
		map.print();
	}
}
