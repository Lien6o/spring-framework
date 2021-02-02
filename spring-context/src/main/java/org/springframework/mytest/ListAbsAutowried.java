package org.springframework.mytest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ListAbsAutowried {

	@Autowired
	StringList stringList;

	public void execute() {
		 stringList.who();
	}
}
