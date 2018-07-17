package ssm.blog.service.impl;

import org.springframework.stereotype.Service;
import ssm.blog.dao.BloggerDao;
import ssm.blog.entity.Blogger;
import ssm.blog.service.BloggerService;

import javax.annotation.Resource;

@Service //注册业务层的Bean
public class BloggerServiceimpl implements BloggerService {

    @Resource
    private BloggerDao bloggerDao;

    public Blogger findBloggerData(String username) {
        return bloggerDao.getBloggerByUserName(username);
    }

    public String login(String userName, String password) {
        Blogger blogger = bloggerDao.getBloggerByUserName(userName);
        if(blogger != null){
            if(blogger.getPassword().equals(password)){
                return "success";
            }else
                return "用户名密码错误，请输入正确的用户名密码！";
        }else {
            return "该博主用户不存在，请输入正确的用户名！";
        }
    }

    public Integer updateBlog(Blogger blogger) {
        return bloggerDao.UpdateBloge(blogger);
    }
}
