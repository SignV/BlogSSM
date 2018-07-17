package ssm.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import ssm.blog.entity.Blogger;
import ssm.blog.service.BloggerService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Controller
@RequestMapping(value = "/blogger")    //请求路径
public class BloggerController {
    @Resource
    private BloggerService bloggerService;

    @RequestMapping(value = "/login")
    public String login(Blogger blogger, HttpServletRequest request) throws Exception{
        String loginStr = bloggerService.login(blogger.getUserName(),blogger.getPassword());
        HttpSession session = request.getSession();
        if(loginStr.equals("success")){
            blogger = bloggerService.findBloggerData(blogger.getUserName());
            session.setAttribute("blogger",blogger);
            return "redirect:/index.jsp";
        }
        else {
            //回显
//            model.addObject("blogger",blogger);
//            request.setAttribute("blogger",blogger);
            //提示信息
            session.setAttribute("errorInfo",loginStr);
//            request.setAttribute("errorInfo",loginStr);
            return "login";
        }
    }
}
