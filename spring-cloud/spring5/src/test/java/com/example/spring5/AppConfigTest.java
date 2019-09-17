package com.example.spring5;

import com.example.spring5.bean.Person;
import com.example.spring5.config.AppConfig;
import com.example.spring5.config.AppConfig01;
import com.example.spring5.config.AppConfig02;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author YuXiaodan
 * @ClassName AppConfigTest
 * @Description
 * @date 2019年07月16日 2019/7/16
 */
public class AppConfigTest {

	@Test
	public void AppConfigTest() {

		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
		Person person = ac.getBean(Person.class);

		System.out.println(person.toString());
	}

	@Test
	public void AppConfigTest01() {

		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig01.class);

	}

	@Test
	public void AppConfigTest02() {

		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig02.class);

	}
}
