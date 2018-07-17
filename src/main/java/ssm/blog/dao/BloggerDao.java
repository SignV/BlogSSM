package ssm.blog.dao;

import org.springframework.stereotype.Repository;
import ssm.blog.entity.Blogger;

@Repository //注册为持久层的bean
public interface BloggerDao {
    /**
     * 查询博主信息
     * @return
     */
    Blogger getBloggerData(Integer id);

    /**
     *根据用户名查找博主用户
     */
    Blogger getBloggerByUserName(String userName);

    /**
     * 更新博主信息
     */
    Integer UpdateBloge(Blogger blogger);
}