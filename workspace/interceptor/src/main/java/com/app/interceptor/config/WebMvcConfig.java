package com.app.interceptor.config;

import com.app.interceptor.interceptor.TestInterceptor;
import com.app.interceptor.mapper.AlarmMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Autowired
    private AlarmMapper alarmMapper;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new TestInterceptor(alarmMapper))
                .excludePathPatterns("/css/**", "/images/**", "/js/**");
    }
}
