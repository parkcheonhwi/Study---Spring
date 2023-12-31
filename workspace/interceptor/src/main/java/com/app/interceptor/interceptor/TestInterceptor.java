package com.app.interceptor.interceptor;

import com.app.interceptor.mapper.AlarmMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
@Slf4j
@RequiredArgsConstructor
public class TestInterceptor implements HandlerInterceptor {
    private final AlarmMapper alarmMapper;

//    컨트롤러 수행 전
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        Member member = (Member)(request.getSession().getAttribute("member"));
        Long memberId = 21L;
        if(memberId != null){
            request.getSession().setAttribute("alarms", alarmMapper.select(memberId));
        }
        return true;
    }

////    컨트롤러 수행 후, 화면 이동 전
//    @Override
//    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
//        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
//    }
//
////    다 하고 나서
//    @Override
//    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
//        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
//    }
}
