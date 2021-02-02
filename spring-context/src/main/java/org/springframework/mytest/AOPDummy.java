package org.springframework.mytest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author: Lien6o
 * @description:
 * @date: 2020/5/19 4:01 下午
 * @version: v1.0
 */
@Component
public class AOPDummy {

	@Autowired
	AopInterface aopInterface;

	public void testAop() {
		aopInterface.doSome();
	}


	private String fields;

	public String getFields() {
		return fields;
	}

	public void setFields(String fields) {
		this.fields = fields;
	}
}
