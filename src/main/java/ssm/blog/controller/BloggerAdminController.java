package ssm.blog.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import ssm.blog.entity.Blog;
import ssm.blog.entity.Blogger;
import ssm.blog.entity.PageBean;
import ssm.blog.service.BlogService;
import ssm.blog.service.BloggerService;
import ssm.blog.util.DateUtil;
import ssm.blog.util.PathUtil;
import ssm.blog.util.ResponseUtil;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;

@Controller
@RequestMapping("/admin/blogger")
public class BloggerAdminController {
    @Resource
    private BloggerService bloggerService;
    //登录后台
    @RequestMapping(value = "/login")
    public String login(Blogger blogger, HttpServletRequest request) throws Exception{
        String loginStr = bloggerService.login(blogger.getUserName(),blogger.getPassword());
        HttpSession session = request.getSession();
        if(loginStr.equals("success")){
            blogger = bloggerService.findBloggerData(blogger.getUserName());
            session.setAttribute("blogger",blogger);
            return "redirect:/admin/menu.jsp";
        }
        else {
            //回显
//            model.addObject("blogger",blogger);
//            request.setAttribute("blogger",blogger);
            //提示信息
            session.setAttribute("errorInfo",loginStr);
//            request.setAttribute("errorInfo",loginStr);
            return "admin/loginAdmin";
        }
    }
    //更新或者新增博客
    @RequestMapping("/save")
    public String saveBlog(@RequestParam(value = "imageFile") MultipartFile imageFile,Blogger blogger, HttpServletRequest request) throws Exception{

        if(!imageFile.isEmpty()){
            //获取服务器根路径
            String filePath = "D:\\IntelliJ IDEA 2017.3.4\\workspace\\BlogSSM";
            //图片新名字
            String imageName = DateUtil.getCurrentDateStr() + "." +
                    imageFile.getOriginalFilename().split("\\.")[1];
            //把内存中图片写入磁盘
            imageFile.transferTo(new File(filePath +
                    "/src/main/webapp/static/userImages/" + imageName));
            //将新图片名称写入数据库的imagename，即存入blogger的imageName属性
            blogger.setImageName(imageName);
        }
        int resultTotal = bloggerService.updateBlog(blogger);
        boolean flag = false;
        if(resultTotal > 0 ){
            flag = true;
        }else {
            flag = false;
        }
        request.getSession().setAttribute("flag",flag);
        return "admin/modifyInfo";
    }
}
