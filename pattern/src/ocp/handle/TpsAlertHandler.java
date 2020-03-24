package ocp.handle;

import ocp.AlertRule;
import ocp.ApiStatInfo;
import ocp.Notification;
import ocp.NotificationEmergencyLevel;
import ocp.handle.AlertHandler;

/**
 * @author louis.yu
 */
public class TpsAlertHandler extends AlertHandler {

    public TpsAlertHandler(AlertRule rule, Notification notification) {
        super(rule, notification);
    }

    @Override
    public void check(ApiStatInfo apiStatInfo) {

        long tps = apiStatInfo.getRequestCount()/ apiStatInfo.getDurationOfSeconds();

        if (tps > rule.getMatchedRule(apiStatInfo.getApi()).getMaxTps()) {
            notification.notify(NotificationEmergencyLevel.URGENCY, "...");
        }
    }
}
