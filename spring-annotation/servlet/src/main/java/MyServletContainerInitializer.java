import filter.HelloFilter;
import listener.HelloListener;
import service.HelloService;
import servlet.HelloServlet;

import javax.servlet.*;
import javax.servlet.annotation.HandlesTypes;
import java.util.EnumSet;
import java.util.Set;

/**
 * @author kinden
 *
 * HandlesTypes指定Set<Class<?>> set中的元素
 */
@HandlesTypes(value = {HelloService.class})
public class MyServletContainerInitializer implements ServletContainerInitializer {

    public void onStartup(Set<Class<?>> set, ServletContext servletContext) throws ServletException {

        for (Class<?> clz : set){
            System.out.println(clz);
        }

        ServletRegistration.Dynamic helloServlet = servletContext.addServlet("helloServlet", new HelloServlet());
        helloServlet.addMapping("/hello");

        servletContext.addListener(HelloListener.class);

        FilterRegistration.Dynamic helloFilter = servletContext.addFilter("helloFilter", HelloFilter.class);
        helloFilter.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST), true, "/*");
    }
}
