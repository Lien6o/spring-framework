package org.springframework.lienbo;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

/**
 * @author: Lien6o
 * @description:
 * @date: 2020/1/10 10:24 上午
 * @version: v1.0
 */
@Component
public class IndexDao1 implements IndexDao {
	@Override
	public String query() {
		return "IndexDao1";
	}
}
