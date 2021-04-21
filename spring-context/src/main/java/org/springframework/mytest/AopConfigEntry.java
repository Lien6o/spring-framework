package org.springframework.mytest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.util.Arrays;

/**
 * @author Lien6o
 */

@Configuration
@EnableAspectJAutoProxy(proxyTargetClass = true)
@ComponentScan("org.springframework.mytest")
public class AopConfigEntry {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(AopConfigEntry.class);
 		String[] beanDefinitionNames = context.getBeanDefinitionNames();
		System.out.println("Arrays.toString(beanDefinitionNames) = " + Arrays.toString(beanDefinitionNames));
	}
}
