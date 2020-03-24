package ocp;

import java.util.List;

/**
 * @author louis.yu
 *
 * Notification 是告警通知类，支持邮件、短信、微信、手机等多种通知渠道
 */
public class Notification {

    private List emailAddresses;
    private List telephones;
    private List wechatIds;

    public Notification() {

    }

    public void setEmailAddress(List emailAddress) {
        this.emailAddresses = emailAddress;
    }

    public void setTelephones(List telephones) {
        this.telephones = telephones;
    }

    public void setWechatIds(List wechatIds) {
        this.wechatIds = wechatIds;
    }

    public void notify(NotificationEmergencyLevel level, String message) {

        if (level.equals(NotificationEmergencyLevel.SEVERE)) {
            //...自动语音电话
        } else if (level.equals(NotificationEmergencyLevel.URGENCY)) {
            //...发微信
        } else if (level.equals(NotificationEmergencyLevel.NORMAL)) {
            //...发邮件
        } else if (level.equals(NotificationEmergencyLevel.TRIVIAL)) {
            //...发邮件
        }
    }
}
