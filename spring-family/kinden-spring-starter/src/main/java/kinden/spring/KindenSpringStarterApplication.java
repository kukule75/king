package kinden.spring;

import kinden.spring.mapper.AccountMapper;
import kinden.spring.model.Account;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@Slf4j
@MapperScan("kinden.spring.mapper")
public class KindenSpringStarterApplication
//		implements ApplicationRunner
{

	@Autowired
	private AccountMapper accountMapper;

	public static void main(String[] args) {
		SpringApplication.run(KindenSpringStarterApplication.class, args);
	}

	@RequestMapping("/hello")
	public String hello() {

		return "Hello World!";
	}

//	@Override
//	public void run(ApplicationArguments args) throws Exception {
//
//		Account account = Account.builder().accNo("qaz").accCode(11).
//									userId(101L).status("1111").statusCode(8L).accType("2").
//									dcFlag("C").minusFlag("a").build();
//
//		accountMapper.save(account);
//	}
}
