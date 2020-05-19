package org.springframework.lienbo;

import org.springframework.stereotype.Service;

/**
 * @author: Lien6o
 * @description:
 * @date: 2020/5/19 4:57 下午
 * @version: v1.0
 */
@Service
public class AopInterfaceImpl implements AopInterface{

	@Override
	public void doSome() {
		System.out.println("AopInterfaceImpl execute doSome");
	}
}
