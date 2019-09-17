package com.example.spring5.config;

import com.example.spring5.bean.Bar;
import com.example.spring5.bean.Foo;
import com.example.spring5.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author YuXiaodan
 * @ClassName AppConfig
 * @Description
 * @date 2019年07月16日 2019/7/16
 */
@Configuration
public class AppConfig {

	@Bean
	public Person person() {
		return new Person("张四", 20);
	}

	@Bean
	public Foo foo() {
		return new Foo(bar());
	}

	@Bean
	public Bar bar() {
		return new Bar();
	}
}
