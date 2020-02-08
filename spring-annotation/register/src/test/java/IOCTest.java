import bean.Person;
import config.MainConfig;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.core.env.SystemEnvironmentPropertySource;


/**
 * @author kinden
 */
public class IOCTest {

    @Test
    public void test() {

        ApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(MainConfig.class);

        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();

        for(String s : beanDefinitionNames) {
            System.out.println(s);
        }

        Person person1 = applicationContext.getBean(Person.class);
        Person person2 = applicationContext.getBean(Person.class);

        System.out.println(person1 == person2);

    }

    @Test
    public void test01() {

        ApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(MainConfig.class);

        String[] beanNamesForType = applicationContext.getBeanNamesForType(Person.class);

        for(String s : beanNamesForType){
            System.out.println(s);
        }
    }
}
