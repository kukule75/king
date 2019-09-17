package com.neo.filter;

import com.netflix.zuul.ZuulFilter;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;

/**
 * @author YuXiaodan
 * @ClassName TestFilter
 * @Description 测试过滤器，过滤器有四种类型
 * 	1.pre过滤器，路由映射、授权控制、权限认证、调试信息
 * 	2.routing过滤器，请求转发
 * 	3.post过滤器，修改httpheader、搜集统计信息指标
 * 	4.error过滤器，发生错误时调用
 * @date 2019年09月04日 2019/9/4
 */
public class TestFilter extends ZuulFilter {

	/**
	 * 过滤器的类型：定义在请求执行过程中何时被执行
	 * @return
	 */
	@Override
	public String filterType() {
		return PRE_TYPE;
	}

	/**
	 * 执行顺序：当存在多个过滤器时，用来指示执行的顺序，值越小就会越早执行
	 * @return
	 */
	@Override
	public int filterOrder() {
		return 0;
	}

	/**
	 * 判断是否需要执行该过滤器
	 * @return
	 */
	@Override
	public boolean shouldFilter() {
		return false;
	}

	/**
	 * 要执行的具体过滤动作
	 * @return
	 */
	@Override
	public Object run() {
		return null;
	}
}
