package com.example.spring5.service;

/**
 * @author YuXiaodan
 * @ClassName Command
 * @Description
 * @date 2019年07月16日 2019/7/16
 */
public interface Command {

	void setState(Object o);

	Object execute();
}
