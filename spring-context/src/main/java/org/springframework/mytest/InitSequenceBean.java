package org.springframework.mytest;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.lang.Nullable;

import javax.annotation.PostConstruct;

/**
 * @author: Lien6o
 * @description:
 * @date: 2020/1/14 4:33 下午
 * @version: v1.0
 */
public class InitSequenceBean implements InitializingBean, BeanPostProcessor {
	/**
	 * result:
	 * 前置 BeanPostProcessor
	 * InitSequenceBean: construct
	 * InitSequenceBean: postConstruct
	 * InitSequenceBean: afterPropertiesSet
	 * InitSequenceBean: initMethod
	 * 后置 BeanPostProcessor
	 */
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("InitSequenceBean: postProcessBeforeInitialization");
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("InitSequenceBean: postProcessAfterInitialization");
		return bean;
	}

	public InitSequenceBean() {
		System.out.println("InitSequenceBean: construct");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("InitSequenceBean: afterPropertiesSet");
	}

	@PostConstruct
	public void postConstruct() {
		System.out.println("InitSequenceBean: postConstruct");
	}

	public void initMethod() {
		System.out.println("InitSequenceBean: initMethod");
	}
}
