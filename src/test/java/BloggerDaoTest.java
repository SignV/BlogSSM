import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ssm.blog.dao.BloggerDao;
import ssm.blog.entity.Blogger;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class) //使用spring测试
@ContextConfiguration(locations = "classpath:spring-beans.xml") //设置spring配置文件路径
public class BloggerDaoTest {
    @Resource
    private BloggerDao bloggerDao;

    @Test
    public void getBloggerData() throws Exception{
//        Blogger blogger = bloggerDao.getBloggerData();
//        System.out.println(blogger);
    }
}
