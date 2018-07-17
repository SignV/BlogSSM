package ssm.blog.service;

import ssm.blog.entity.Blog;
import ssm.blog.entity.PageBean;

import java.util.List;
import java.util.Map;

public interface BlogService {
    // 分页查询博客
    public List<Blog> listBlog(Map<String,Object> map);

    // 分页查询博客
    public PageBean<Blog> listBlog(String title, PageBean<Blog> pageBean);

    //获取总记录数
    long getTotal(Map<String, Object> map);

    // 根据博客类型的id查询该类型下的博客数量
    public Integer getBlogByTypeId(Integer typeId);

    //添加博客
    public Integer saveBlog(Blog blog);

    //更新博客
    public Integer updateBlog(Blog blog);

    //通过id删除博客
    public Integer deleteBlog(Integer id);

    //通过id获取博客
    public Blog getById(Integer id);

    //通过typeId获取博客信息
    public List<Blog> getInfoByTypeId(Integer typeId);

    //获取最新的五条博客
    public List<Blog> get5NewBlog();

    //根据关键字查询
    public List<Blog> getBlogByKey(String searchKey);
}
