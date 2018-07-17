package ssm.blog.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import ssm.blog.entity.Blogger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {
        public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
            Blogger blogger = (Blogger) request.getSession().getAttribute("blogger");
            if(blogger != null){
                //验证身份
                return true;
            }
            //若是执行到这里则表示身份认证失败，跳转到登录页面
            request.getRequestDispatcher("/login.jsp").forward(request,response);
            return false;
        }

    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
