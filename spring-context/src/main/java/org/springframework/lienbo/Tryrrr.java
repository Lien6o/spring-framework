package org.springframework.lienbo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author: Lien6o
 * @description:
 * @date: 2020/1/10 10:29 上午
 * @version: v1.0
 */
@Component
public class Tryrrr {

	// todo 神乎其技的操作 ，注入 Map 就可以回去该接口下的所有实现类。。。。。
	@Autowired
	private Map<String, IndexDao> map;

	public void print() {
		System.out.println(map.toString());
	}
}
