import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ssm.blog.dao.BlogTypeDao;
import ssm.blog.entity.BlogType;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class) //使用spring测试
@ContextConfiguration(locations = "classpath:spring-beans.xml") //设置spring配置文件路径
public class BlogTypeDaoTest {
    @Resource
    private BlogTypeDao blogTypeDao;
    private BlogType blogType;

    @Test
    public void addBlogType() throws Exception{
//        blogType = new BlogType("zsafd",66);
//        int result = blogTypeDao.addBlogType(blogType);
//        System.out.println(result);
    }
    @Test
    public void deleteBlogType() throws Exception{
        blogTypeDao.deleteBlogType(17);
    }
    @Test
    public void updateBlogType() throws Exception{
//        blogType = new BlogType(16,"WebSoft",53);
//        blogTypeDao.updateBlogType(blogType);
    }
    @Test
    public void getById() throws Exception{
        blogType = blogTypeDao.getById(16);
        System.out.println(blogType);
    }
    @Test
    public void listByPage() throws Exception{
        List<BlogType> blogTypeList = blogTypeDao.listByPage(3,3);
        System.out.println("=============================");
        System.out.println(blogTypeList);
        System.out.println("=============================");
    }
    @Test
    public void getTotal() throws Exception{
        Long count = blogTypeDao.getTotal();
        System.out.println("=============================");
        System.out.println(count);
        System.out.println("=============================");
    }
}
