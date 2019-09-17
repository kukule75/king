package com.example.spring5.service;

/**
 * @author YuXiaodan
 * @ClassName AsyncCommand
 * @Description
 * @date 2019年07月16日 2019/7/16
 */
public class AsyncCommand implements Command{

	private Object object;

	@Override
	public void setState(Object object) {
		this.object = object;
		System.out.println("setState ...");
	}

	@Override
	public Object execute() {
		System.out.println("execute ...");

		return this.object;
	}
}
