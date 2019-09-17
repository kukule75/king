package king.controller;

import king.service.HelloService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * @author YuXiaodan
 * @ClassName Hello
 * @Description
 * @date 2017年09月13日 2017/9/13
 */
@Controller
@RequestMapping("/home")
public class Hello {

	private static final Logger LOGGER = LoggerFactory.getLogger(Hello.class);

	@Autowired
	private HelloService helloService;

	@RequestMapping(value = "/test")
	public String test(Model model, @RequestParam("amount") BigDecimal amount) {

		helloService.test();

//		model.addAttribute("greeting", "扣款成功");

		return "home";
	}

	@RequestMapping(value = "/debit")
	public String debit(Model model, @RequestParam("amount") BigDecimal amount) {

		helloService.debit(amount);

		model.addAttribute("greeting", "扣款成功");

		return "home";
	}

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index(Model model, @RequestParam("name") String name) {

		LOGGER.info("controller hello index {}...", name);

		model.addAttribute("greeting", helloService.hello(name));

		return "home";
	}

	@RequestMapping("/doTrans")
	public String doTrans(Model model, @RequestParam("userId") Long userId,
						@RequestParam("amount") BigDecimal amount) {

		boolean result = helloService.doTrans(userId, amount);

		model.addAttribute("greeting", result ? "事务成功" : "事务回滚");

		return "home";
	}

	@RequestMapping("/doTransA")
	public String doTransA(Model model, @RequestParam("userId") Long userId,
						  @RequestParam("amount") BigDecimal amount) {

		helloService.doTransA(userId, amount);

		//model.addAttribute("greeting", result ? "事务成功" : "事务回滚");

		return "home";
	}

}
