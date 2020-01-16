package org.springframework.lienbo;

import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;

/**
 * @author: Lien6o
 * @description:
 * @date: 2020/1/14 4:33 下午
 * @version: v1.0
 */
public class InitSequenceBean implements InitializingBean {
	/**
	 * result:
	 *
	 * InitSequenceBean: construct
	 * InitSequenceBean: postConstruct
	 * InitSequenceBean: afterPropertiesSet
	 * InitSequenceBean: initMethod
	 */

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
