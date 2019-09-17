package kinden.spring.indicator;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

/**
 * @author YuXiaodan
 * @ClassName CustomerIndicator
 * @Description
 * @date 2019年09月16日 2019/9/16
 */
@Slf4j
@Component
public class CustomerIndicator implements HealthIndicator {

	@Override
	public Health health() {

		log.info("CustomerIndicator.health ...");
		return Health.up().withDetail("message", "hello health").build();
	}
}
