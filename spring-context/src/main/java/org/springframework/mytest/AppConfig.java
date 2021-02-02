package org.springframework.mytest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author: Lien6o
 * @description:
 * @date: 2019/12/23 5:09 下午
 * @version: v1.0
 */
@Configuration
@EnableAspectJAutoProxy(proxyTargetClass = true)
@ComponentScan("org.springframework.mytest")
public class AppConfig {

	@Bean(initMethod = "initMethod", name = "initSequenceBean")
	public InitSequenceBean initSequenceBean() {
		return new InitSequenceBean();
	}

}
