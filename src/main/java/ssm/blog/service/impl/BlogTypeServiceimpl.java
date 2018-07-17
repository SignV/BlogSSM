package ssm.blog.service.impl;

import org.springframework.stereotype.Service;
import ssm.blog.dao.BlogTypeDao;
import ssm.blog.entity.BlogType;
import ssm.blog.entity.PageBean;
import ssm.blog.service.BlogTypeService;

import javax.annotation.Resource;
import java.util.List;

@Service //注册业务层的Bean
public class BlogTypeServiceimpl implements BlogTypeService {
    @Resource
    private BlogTypeDao blogTypeDao;

    public PageBean<BlogType> listByPage(PageBean<BlogType> pageBean) {
        Long count = blogTypeDao.getTotal();
        List<BlogType> blogTypeList = blogTypeDao.listByPage(pageBean.getStart(),pageBean.getPageSize());
        pageBean.setResult(blogTypeList);   //通过传入的pageBean查询分页结果
        pageBean.setTotal(count);           //通过传入的pageBean查询记录总数
        return pageBean;
    }

    public Integer addBlogType(BlogType blogType) {
        return blogTypeDao.addBlogType(blogType);
    }

    public Integer updateBlogType(BlogType blogType) {
        return blogTypeDao.updateBlogType(blogType);
    }

    public Integer deleteBlogType(Integer id) {
        return blogTypeDao.deleteBlogType(id);
    }

    public List<BlogType> getBlogTypeData() {
        return blogTypeDao.getAllBlogType();
    }

    public List<BlogType> getBlogTypeDataCount() {
        return blogTypeDao.getBlogTypeDataCount();
    }

}
