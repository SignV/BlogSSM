package ssm.blog.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ssm.blog.entity.BlogType;
import ssm.blog.entity.PageBean;
import ssm.blog.service.BlogTypeService;
import ssm.blog.util.ResponseUtil;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("admin/blogType")
public class BlogTypeAdminController {
    @Resource
    private BlogTypeService blogTypeService;

    // 分页查询博客类别
    @RequestMapping("/list")
    public String listBlogType(@RequestParam(value = "page",required = false) String page,
                                @RequestParam(value = "rows",required = false) String rows,
                                HttpServletResponse response) throws Exception{
        //定义分页bean
        PageBean<BlogType> pageBean =
                new PageBean<BlogType>(Integer.parseInt(page),Integer.parseInt(rows));
        //拿到分页结果以及记录总数的pageBean
        pageBean = blogTypeService.listByPage(pageBean);
        //使用阿里巴巴的fastJson创建JSONObject
        JSONObject result = new JSONObject();
        //通过fastJson序列化list为jsonArray
        String jsonArray = JSON.toJSONString(pageBean.getResult());
        JSONArray array = JSONArray.parseArray(jsonArray);
        //将序列化结果放入json对象中
        result.put("rows",array);
        result.put("total",pageBean.getTotal());
        //使用自定义工具类向response中写入数据
        ResponseUtil.write(response,result);
        return null;
    }
    //添加或修改博客类别
    @RequestMapping("/save")
    public String save(BlogType blogType,HttpServletResponse response) throws Exception {
        //resultToal记录返回结果的记录数
        int resultToal = 0;
        if(blogType.getId() == null){   // 说明是第一次插入，为添加操作
            resultToal = blogTypeService.addBlogType(blogType);
        }else { // 有id，为修改操作
            resultToal = blogTypeService.updateBlogType(blogType);
        }

        JSONObject result = new JSONObject();
        if(resultToal > 0){
            result.put("success",true);
        }else {
            result.put("success",false);
        }
        ResponseUtil.write(response,result);
        return null;
    }
    // 博客类别信息删除
    @RequestMapping("/delete")
    public String delete(@RequestParam("ids") String ids,HttpServletResponse response) throws Exception{
        //分割字符串得到id数组
        String[] idsStr = ids.split(",");
        for(int i = 0;i < idsStr.length;i++){
            int id = Integer.parseInt(idsStr[i]);
            //其实在这里我们要判断该博客类别下面是否有博客 如果有就禁止删除博客类别 ，等我们完成博客对应的操作再来完善
            blogTypeService.deleteBlogType(id);
            //当删除类型是外键是需要在数据库指定好 进行级联更新以及级联删除
            //外键指定级联更新、删除：on update cascade on delete cascade
        }
        JSONObject result = new JSONObject();
        result.put("success",true);
        ResponseUtil.write(response,result);
        return null;
    }
}
