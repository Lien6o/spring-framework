package org.springframework.mytest;

import org.springframework.stereotype.Component;

/**
 * @author: Lien6o
 * @description:
 * @date: 2020/1/10 10:24 上午
 * @version: v1.0
 */
@Component
public class IndexDao2 implements IndexDao {
	@Override
	public String query() {
		return "IndexDao2";
	}
}
