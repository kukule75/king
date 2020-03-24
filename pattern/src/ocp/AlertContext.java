package ocp;

import ocp.handle.ErrorAlertHandler;
import ocp.handle.TimeoutAlertHandler;
import ocp.handle.TpsAlertHandler;

/**
 * @author louis.yu
 */

public class AlertContext {

    private AlertRule alertRule;
    private Notification notification;
    private Alert alert;

    public void initializeBeans() {
        alertRule = new AlertRule(/*.省略参数.*/); //省略一些初始化代码
        notification = new Notification(/*.省略参数.*/); //省略一些初始化代码
        alert = new Alert();
        alert.addAlertHandler(new TpsAlertHandler(alertRule, notification));
        alert.addAlertHandler(new ErrorAlertHandler(alertRule, notification));
        alert.addAlertHandler(new TimeoutAlertHandler(alertRule, notification));
    }
    public Alert getAlert() { return alert; }

    // 饿汉式单例
    private static final AlertContext instance = new AlertContext();
    private AlertContext() {
        instance.initializeBeans();
    }

    public static AlertContext getInstance() {
        return instance;
    }
}
