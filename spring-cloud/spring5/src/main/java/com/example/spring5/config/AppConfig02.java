package com.example.spring5.config;

import com.example.spring5.dao.ClientDao;
import com.example.spring5.dao.ClientDaoImpl;
import com.example.spring5.service.ClientService;
import com.example.spring5.service.ClientServiceImpl;
import org.springframework.context.annotation.Bean;

/**
 * @author YuXiaodan
 * @ClassName AppConfig02
 * @Description
 * @date 2019年07月16日 2019/7/16
 */
public class AppConfig02 {

	@Bean
	public ClientService clientService1() {
		ClientServiceImpl clientService = new ClientServiceImpl();
		clientService.setClientDao(clientDao());
		return clientService;
	}

	@Bean
	public ClientService clientService2() {
		ClientServiceImpl clientService = new ClientServiceImpl();
		clientService.setClientDao(clientDao());
		return clientService;
	}

	@Bean
	public ClientDao clientDao() {
		return new ClientDaoImpl();
	}
}
