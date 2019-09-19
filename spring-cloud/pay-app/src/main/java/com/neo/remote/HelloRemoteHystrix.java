package com.neo.remote;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author YuXiaodan
 * @ClassName HelloRemoteHystrix
 * @Description
 * @date 2019年07月11日 2019/7/11
 */
@Component
public class HelloRemoteHystrix implements HelloRemote {

    @Override
	public String hello(@RequestParam(value = "name") String name) {
		return "hello " +name+", this messge send failed ";
	}
}
