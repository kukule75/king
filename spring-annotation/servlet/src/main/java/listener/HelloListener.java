package listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @author kinden
 */
public class HelloListener implements ServletContextListener {

    // 启动初始化
    public void contextInitialized(ServletContextEvent servletContextEvent) {

        System.out.println("HelloListener contextInitialized ...");
    }

    // 停止
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

        System.out.println("HelloListener contextDestroyed ...");
    }
}
