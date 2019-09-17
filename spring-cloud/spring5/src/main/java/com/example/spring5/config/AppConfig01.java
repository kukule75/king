package com.example.spring5.config;

import com.example.spring5.ext.CommandManager;
import com.example.spring5.service.AsyncCommand;
import com.example.spring5.service.Command;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

/**
 * @author YuXiaodan
 * @ClassName AppConfig01
 * @Description
 * @date 2019年07月16日 2019/7/16
 */
public class AppConfig01 {

	@Bean
	@Scope("prototype")
	public AsyncCommand asyncCommand() {
		AsyncCommand command = new AsyncCommand();
		// inject dependencies here as required
		return command;
	}

	@Bean
	public CommandManager commandManager() {
		// return new anonymous implementation of CommandManager with command() overridden
		// to return a new prototype Command object
		return new CommandManager() {
			protected Command createCommand() {
				return asyncCommand();
			}
		};
	}
}
