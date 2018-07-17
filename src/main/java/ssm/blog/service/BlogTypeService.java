package ssm.blog.service;

import ssm.blog.entity.Blog;
import ssm.blog.entity.BlogType;
import ssm.blog.entity.PageBean;

import java.util.List;

public interface BlogTypeService {
    //分页查询
    PageBean<BlogType> listByPage(PageBean<BlogType> pageBean);

    // 添加博客类别
    public Integer addBlogType(BlogType blogType);

    // 更新博客类别
    public Integer updateBlogType(BlogType blogType);

    // 删除博客类别
    public Integer deleteBlogType(Integer id);

    //获取博客类别数据
    public List<BlogType> getBlogTypeData();

    //获取博客分类信息，有博客分类计数
    public List<BlogType> getBlogTypeDataCount();
}
