package ssm.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ssm.blog.entity.Blog;
import ssm.blog.entity.Blogger;
import ssm.blog.service.BlogService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Resource
    private BlogService blogService;

    @RequestMapping("/getBlogByType")
    public String getBlogByType(@RequestParam("id") String id, Model model, HttpServletRequest request){
        HttpSession session = request.getSession();
        Blogger blogger = (Blogger) session.getAttribute("blogger");
        int typeId = Integer.parseInt(id);
        List<Blog> blogInfoList = blogService.getInfoByTypeId(typeId);
        model.addAttribute("blogInfoList",blogInfoList);
        model.addAttribute("blogger",blogger);
        return "forward:/index.jsp";
    }
    @RequestMapping("/getBlogByKey")
    public String getBlogByKey(@RequestParam("searchKey") String searchKey,Model model){
        List<Blog> keyBlogList = blogService.getBlogByKey(searchKey);
        model.addAttribute("keyBlogList",keyBlogList);
        return "index";
    }
    @RequestMapping("/getBlogByClick")
    public String getBlogByClick(@RequestParam("id") String id,Model model){
        Blog clickBlog = blogService.getById(Integer.parseInt(id));
        model.addAttribute("clickBlog",clickBlog);
        return "index";
    }
}
