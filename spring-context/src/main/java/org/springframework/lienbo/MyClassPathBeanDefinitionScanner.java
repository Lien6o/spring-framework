package org.springframework.lienbo;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.core.type.filter.AnnotationTypeFilter;

public class MyClassPathBeanDefinitionScanner extends ClassPathBeanDefinitionScanner {


	public MyClassPathBeanDefinitionScanner(BeanDefinitionRegistry registry  ) {

		super(registry, false);
		super.addIncludeFilter(new AnnotationTypeFilter(MyBean.class));

	}
}