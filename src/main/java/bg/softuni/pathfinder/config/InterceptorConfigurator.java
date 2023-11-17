package bg.softuni.pathfinder.config;

import bg.softuni.pathfinder.interceptors.IpBlackListInterceptor;
import bg.softuni.pathfinder.interceptors.LoggingInterceptors;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfigurator implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoggingInterceptors());
        registry.addInterceptor(new IpBlackListInterceptor());
    }
}
