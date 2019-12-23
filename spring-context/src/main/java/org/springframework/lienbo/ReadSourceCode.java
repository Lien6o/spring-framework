package org.springframework.lienbo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author: Lien6o
 * @description:
 * @date: 2019/12/23 5:08 下午
 * @version: v1.0
 */
public class ReadSourceCode {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

		Object appConfig = context.getBean("appConfig");
		System.err.println(appConfig.toString());
	}
}
