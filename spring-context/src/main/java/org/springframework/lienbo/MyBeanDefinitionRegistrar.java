package org.springframework.lienbo;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.type.AnnotationMetadata;

public class MyBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar, ResourceLoaderAware {
	private ResourceLoader resourceLoader;

	@Override
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
		// 不使用默认过滤器
		MyClassPathBeanDefinitionScanner scanner = new MyClassPathBeanDefinitionScanner(registry);
		scanner.setResourceLoader(resourceLoader);
		// 扫描XBeanScan注解指定的包
		scanner.scan(getBasePackagesToScan(importingClassMetadata));
	}

	@Override
	public void setResourceLoader(ResourceLoader resourceLoader) {
		this.resourceLoader = resourceLoader;
	}

	/**
	 * @param metadata the meta
	 * @return  包路径数组
	 */
	private String[] getBasePackagesToScan(AnnotationMetadata metadata) {
		AnnotationAttributes attributes =
				AnnotationAttributes.fromMap(metadata.getAnnotationAttributes(MyBeanScan.class.getName(), true));
		return attributes.getStringArray("basePackages");
	}
}
