package condition;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @author kinden
 */
public class WindowCondition implements Condition {

    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {

        Environment environment = context.getEnvironment();
        BeanDefinitionRegistry registry = context.getRegistry();

        if (environment.getProperty("os.name").equals("window")) {
            System.out.println("os.name is window");
            return true;
        }

        return false;
    }
}
