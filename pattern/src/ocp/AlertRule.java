package ocp;

/**
 * @author louis.yu
 *
 * AlertRule 存储告警规则，可以自由设置
 */
public class AlertRule {

    public AlertRule getMatchedRule(String api) {

        return new AlertRule();
    }

    public long getMaxErrorCount() {
        return 1L;
    }

    public long getMaxTimeoutTps() {
        return 2L;
    }

    public long getMaxTps() {
        return 3L;
    }
}
