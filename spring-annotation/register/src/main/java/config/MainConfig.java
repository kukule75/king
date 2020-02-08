package config;

import bean.Person;
import condition.LinuxCondition;
import condition.WindowCondition;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

/**
 * @author kinden
 *
 * ComponectScans是ComponentScan的集合，用来指定扫描规则
 * 包括includeFilters,excludeFilters，规则类型包括下面五种
 *     ANNOTATION,          注解
 *     ASSIGNABLE_TYPE,     类型，比如说指定不扫描Person类
 *     ASPECTJ,
 *     REGEX,
 *     CUSTOM;              自定义，必须实现TypeFilter接口
 */
@Configuration
@ComponentScan(value = "bean", excludeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Controller.class, Service.class})
})
@Conditional(LinuxCondition.class)
public class MainConfig {

    // 方法名做bean ID
//    @Scope("prototype")
    @Lazy
    @Bean("person")
    public Person person() {
        System.out.println("create zhangsan ...");
        return new Person("zhangsan", 20);
    }

    @Bean("bill")
    @Conditional(WindowCondition.class)
    public Person person01() {
        System.out.println("create bill ...");
        return new Person("bill", 40);
    }

    @Bean("linux")
    @Conditional(LinuxCondition.class)
    public Person person02() {
        System.out.println("create linux ...");
        return new Person("linux", 50);
    }
}
