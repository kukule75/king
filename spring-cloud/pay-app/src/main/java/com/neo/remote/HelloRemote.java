package com.neo.remote;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by summer on 2017/5/11.
 */
@FeignClient(name= "acc-app",contextId = "hello", fallback=HelloRemoteHystrix.class)
public interface HelloRemote {

//    @RequestMapping(value = "/hello")
//    String hello(@RequestParam(value = "name") String name);

    @GetMapping("/hello/{name}")
    String hello(@PathVariable String name);


}