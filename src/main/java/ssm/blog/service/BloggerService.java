package ssm.blog.service;

import ssm.blog.entity.Blogger;

public interface BloggerService {
    //根据ID查找用户信息
    Blogger findBloggerData(String username);
    //验证登录
    String login(String userName,String password);
    //更新博主信息
    Integer updateBlog(Blogger blogger);
}
