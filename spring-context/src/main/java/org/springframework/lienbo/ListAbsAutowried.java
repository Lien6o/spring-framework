package org.springframework.lienbo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Stream;

@Component
public class ListAbsAutowried {

	@Autowired
	StringList stringList;

	public void execute() {
		 stringList.who();
	}
}
