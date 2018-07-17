package ssm.blog.service.impl;

import org.springframework.stereotype.Service;
import ssm.blog.dao.BlogDao;
import ssm.blog.entity.Blog;
import ssm.blog.entity.PageBean;
import ssm.blog.service.BlogService;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service("blogService") //注册业务层的Bean
public class BlogServiceimpl implements BlogService{
    @Resource
    private BlogDao blogDao;

    public List<Blog> listBlog(Map<String, Object> map) {

        return blogDao.listBlog(map);
    }

    public PageBean<Blog> listBlog(String title, PageBean<Blog> pageBean) {
        Map<String,Object> map = new HashMap<String, Object>();
        //设置查询条件
        map.put("title",title);
        //总记录放入pageBean
        pageBean.setTotal(blogDao.getTotal(map));
        map.put("start",pageBean.getStart());
        map.put("pageSize",pageBean.getPageSize());
        //把分页结果放入pageBean
        pageBean.setResult(blogDao.listBlog(map));
        return pageBean;
    }

    public long getTotal(Map<String, Object> map) {
        return blogDao.getTotal(map);
    }

    public Integer getBlogByTypeId(Integer typeId) {
        return blogDao.getBlogByTypeId(typeId);
    }

    public Integer saveBlog(Blog blog) {
        return blogDao.saveBlog(blog);
    }

    public Integer updateBlog(Blog blog) {
        return blogDao.updateBlog(blog);
    }

    public Integer deleteBlog(Integer id) {
        return blogDao.deleteBlog(id);
    }

    public Blog getById(Integer id) {
        return blogDao.getById(id);
    }

    public List<Blog> getInfoByTypeId(Integer typeId) {
        return blogDao.getBlogInfoByTypeId(typeId);
    }
    //获取最新的五条博客按照发表日期降序
    public List<Blog> get5NewBlog() {
        List<Blog> allBlog = blogDao.getAllBlog();
        List<Blog> newBlog = allBlog.subList(0,5);
        return newBlog;
    }

    public List<Blog> getBlogByKey(String searchKey) {
        return blogDao.getBlogByKey(searchKey);
    }
}
