package org.springframework.lienbo;

import org.springframework.stereotype.Component;

@Component
public class StringList extends AbstractList{
	@Override
	protected void who() {
		System.out.println("I am is StringList");
	}
}
