package com.example.spring5.bean;

/**
 * @author YuXiaodan
 * @ClassName Foo
 * @Description
 * @date 2019年07月16日 2019/7/16
 */
public class Foo {

	private Bar bar;

//	private Foo() {
//		System.out.println("Foo construct ...");
//	}

	public Foo (Bar bar) {
		this.bar = bar;
		System.out.println("Foo construct ...");
	}
}
