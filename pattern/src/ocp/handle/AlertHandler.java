package ocp.handle;

import ocp.AlertRule;
import ocp.ApiStatInfo;
import ocp.Notification;

/**
 * @author louis.yu
 */
public abstract class AlertHandler {

    protected AlertRule rule;
    protected Notification notification;

    public AlertHandler(AlertRule rule, Notification notification) {
        this.rule = rule; this.notification = notification;
    }

    public abstract void check(ApiStatInfo apiStatInfo);
}
