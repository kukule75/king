package ocp.handle;

import ocp.AlertRule;
import ocp.ApiStatInfo;
import ocp.Notification;
import ocp.NotificationEmergencyLevel;
import ocp.handle.AlertHandler;

/**
 * @author louis.yu
 */
public class ErrorAlertHandler extends AlertHandler {

    public ErrorAlertHandler(AlertRule rule, Notification notification){
        super(rule, notification);
    }

    @Override
    public void check(ApiStatInfo apiStatInfo) {

        if (apiStatInfo.getErrorCount() > rule.getMatchedRule(apiStatInfo.getApi()).getMaxErrorCount()) {
            notification.notify(NotificationEmergencyLevel.SEVERE, "...");
        }
    }
}
