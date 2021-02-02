package org.springframework.mytest;

import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * @author: Lien6o
 * @description:
 * @date: 2020/6/1 10:49 上午
 * @version: v1.0
 */
public class User {
	public Properties props;
	public int[] intarr;
	public List<Integer> list;
	public Map<Integer, String> map;
	public String name;

	public Properties getProps() {
		return props;
	}

	public void setProps(Properties props) {
		this.props = props;
	}

	public int[] getIntarr() {
		return intarr;
	}

	public void setIntarr(int[] intarr) {
		this.intarr = intarr;
	}

	public List<Integer> getList() {
		return list;
	}

	public void setList(List<Integer> list) {
		this.list = list;
	}

	public Map<Integer, String> getMap() {
		return map;
	}

	public void setMap(Map<Integer, String> map) {
		this.map = map;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
