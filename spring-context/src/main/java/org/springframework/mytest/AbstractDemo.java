package org.springframework.mytest;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Lien6o
 * @description some desc
 * @date 2021/4/6 11:39 上午
 */
public abstract class AbstractDemo {

	@Autowired
	private EatService eatService;

	protected abstract String needImpl();

	/**
	 * 10:37:47.313 [main] INFO org.springframework.aop.framework.CglibAopProxy -
	 * Final method [public final void com.youchat.creative.factory.spring.AbstractDemo.execute()] cannot get proxied via CGLIB:
	 * Calls to this method will NOT be routed to the target instance and might lead to NPEs against uninitialized fields in the proxy instance.
	 */
	@DummyTransactional
	public void execute() {
		System.out.println("public final void execute() " + eatService + " " + eatService.eat());
		ex();
	}

	private void ex() {
		System.out.println("private void ex()  " + eatService.eat());
	}
}
