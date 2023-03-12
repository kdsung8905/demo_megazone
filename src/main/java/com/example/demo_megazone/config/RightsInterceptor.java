package com.example.demo_megazone.config;

import com.example.demo_megazone.data.MgzRole;
import com.example.demo_megazone.entity.Role;
import com.example.demo_megazone.entity.User;
import com.example.demo_megazone.service.MgzService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.servlet.HandlerInterceptor;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



@Component
@RequiredArgsConstructor
public class RightsInterceptor implements HandlerInterceptor {

    private final MgzService mgzService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String uri = request.getRequestURI();

        HttpSession session = request.getSession();

        if(session.getAttribute("loginUser") == null){
            throw new HttpServerErrorException(HttpStatus.UNAUTHORIZED, "로그인 정보가 없습니다.");
        }

        String userId = (String) session.getAttribute("loginUser");

        User user = mgzService.findUserByUserId(userId);

        //권한 체크
        checkMyRights(user, uri);


        return HandlerInterceptor.super.preHandle(request, response, handler);
    }

    private void checkMyRights(User user, String uri){

        boolean isAllowed = user.getRole().getRightsList().stream().anyMatch(rights -> uri.contains(rights.getUri()));

        if(!isAllowed){
            throw new HttpServerErrorException(HttpStatus.FORBIDDEN, "접근 권한이 없습니다.");
        }

    }


    //컨트롤러 호출 전 로그인 회원의 권한을 확인하고 싶은 것이기 때문에 아래 메소드는 사용안함
    /*@Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }*/
}
