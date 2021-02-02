package org.springframework.mytest;

/**
 *
 *
 *
 * 1、bean创建完成后，会调用 populateBean() 填充Bean，在populateBean()方法里会获取所有的BeanPostProcessor，并循环执行 BeanPostProcessor#postProcessPropertyValues() 设置属性
 *
 * 2、其中有个AutowiredAnnotationBeanPostProcessor，这个处理器里会根据当前Bean的Class，通过反射获取 Field 和 Method ，分别获取 Field 和 Method 上的自动注入的注解(@Autowired 和 @Value)，构建注入元数据InjectionMetadata
 *
 * 3、调用注入元数据InjectionMetadata的 inject() 方法，装配属性(有两种：AutowiredFieldElement 和AutowiredMethodElement)，会调用this.beanFactory.resolveDependency(desc,beanName,autowiredBeanNames, typeConverter) 解析依赖的属性值
 *
 * 4、resolveDependency 最终会调用到 resolveMultipleBeans ，而 resolveMultipleBeans 会根据当前注入属性的类型分别按 Array、Collection、Map 走不同的分支，在分支里调用 findAutowireCandidates 获取注入bean的实例，最终回调到 AbstractBeanFactory#doGetBean
 *
 * 5、获取到所有需要注入的属性 bean 实例后，通过反射设置到对应的属性或方法里去，就完成了自动注入全流程了
 *
 *
 */
public abstract class AbstractList {

	protected abstract void who()  ;
}
