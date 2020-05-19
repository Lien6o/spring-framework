/*
 * Copyright 2002-2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.context.annotation;

import org.springframework.aop.config.AopConfigUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.type.AnnotationMetadata;

/**
 * Registers an {@link org.springframework.aop.aspectj.annotation.AnnotationAwareAspectJAutoProxyCreator
 * AnnotationAwareAspectJAutoProxyCreator} against the current {@link BeanDefinitionRegistry}
 * as appropriate based on a given @{@link EnableAspectJAutoProxy} annotation.
 *
 * @author Chris Beams
 * @author Juergen Hoeller
 * @since 3.1
 * @see EnableAspectJAutoProxy
 *
 * todo
 *  1、@EnableAspectJAutoProxy 会注册一个AnnotationAwareAspectJAutoProxyCreator
 *  2、AnnotationAwareAspectJAutoProxyCreator是一个InstantiationAwareBeanPostProcessor
 *  3、创建流程
 *  	1 registerBeanPostProcessors() 注册后置处理器，创建AnnotationAwareAspectJAutoProxyCreator
 *  	2 finishBeanFactoryInitialization 初始化剩下的单实例Bean
 *  		1 创建Bean和切面
 *  		2 AnnotationAwareAspectJAutoProxyCreator拦截创建过程
 * 			3 创建完Bean判断是否需要增强。通过BeanPostProcessorsAfterInitialization，wrapIfNecessary() 包装代理对象
 *  4、执行目标方法
 *  	1 获取拦截器链（advisor包装为Interceptor）
 *  	2 递归调用拦截器链
 *  		前置通知、目标方法、后置通知、返回通知、异常通知
 */
class AspectJAutoProxyRegistrar implements ImportBeanDefinitionRegistrar {

	/**
	 * Register, escalate, and configure the AspectJ auto proxy creator based on the value
	 * of the @{@link EnableAspectJAutoProxy#proxyTargetClass()} attribute on the importing
	 * {@code @Configuration} class.
	 */
	@Override
	public void registerBeanDefinitions(
			AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
		// todo AOP实现类 如有必要，注册Aspect J注释自动代理创建器
		//  bdMap 注入了这个属性
		//  注册AspectJAnnotationAutoProxyCreator，注册类的定义信息（不是对象，还没有实例化）
		//  注册AnnotationAwareAspectJAutoProxyCreator的目的是：
		//  把这个类的BeanDefinition通过registerBeanDefinition方法（DefaultListableBeanFactory类中）
		//  加入到beanDefinitionMap中，作为一个Bean让Spring管理，这样Spring就可以随意取得它了。

		AopConfigUtils.registerAspectJAnnotationAutoProxyCreatorIfNecessary(registry);

		AnnotationAttributes enableAspectJAutoProxy =
				AnnotationConfigUtils.attributesFor(importingClassMetadata, EnableAspectJAutoProxy.class);
		if (enableAspectJAutoProxy != null) {
			if (enableAspectJAutoProxy.getBoolean("proxyTargetClass")) {
				AopConfigUtils.forceAutoProxyCreatorToUseClassProxying(registry);
			}
			if (enableAspectJAutoProxy.getBoolean("exposeProxy")) {
				AopConfigUtils.forceAutoProxyCreatorToExposeProxy(registry);
			}
		}
	}

}
