package ssm.blog.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import ssm.blog.entity.BlogType;

import java.util.List;

@Repository //注册为持久层的bean
public interface BlogTypeDao {
    /**
     * 添加博客类别信息
     * @param blogType
     * @return
     */
    Integer addBlogType(BlogType blogType);

    /**
     * 删除博客类别信息
     * @param id
     * @return
     */
    Integer deleteBlogType(Integer id);

    /**
     * 更新博客类别信息
     * @param blogType
     * @return
     */
    Integer updateBlogType(BlogType blogType);

    /**
     * 根据id查询博客类别信息
     * @param id
     * @return
     */
    BlogType getById(Integer id);

    /**
     * 分页查询博客类别信息
     * @param start
     * @param pageSize
     * @return
     */
    List<BlogType> listByPage(@Param("start") Integer start, @Param("pageSize") Integer pageSize);

    /**
     * 查询总记录数
     * @return
     */
    Long getTotal();

    /**
     * 获取所有的博客类型
     */
    List<BlogType> getAllBlogType();

    /**
     * 获取博客分类信息，包括博客分类的计数
     */
    List<BlogType> getBlogTypeDataCount();
}
