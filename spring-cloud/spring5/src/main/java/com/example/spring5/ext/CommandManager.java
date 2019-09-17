package com.example.spring5.ext;

import com.example.spring5.service.Command;

/**
 * @author YuXiaodan
 * @ClassName CommandManager
 * @Description
 * @date 2019年07月16日 2019/7/16
 */
public abstract class CommandManager {

	public Object process(Object commandState) {
		// grab a new instance of the appropriate Command interface
		Command command = createCommand();
		// set the state on the (hopefully brand new) Command instance
		command.setState(commandState);
		return command.execute();
	}

	// okay... but where is the implementation of this method?
	protected abstract Command createCommand();
}
