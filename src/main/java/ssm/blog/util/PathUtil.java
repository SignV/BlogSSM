package ssm.blog.util;

import javax.servlet.http.HttpServletRequest;

public class PathUtil {

    /**
     * 获取根项目路径
     * @return
     */
    public static String getRootPath(){
        String path=PathUtil.class.getResource("/").toString();
        for (int i = 0; i < 5; i++) {
            int end = path.lastIndexOf("/");
            path = path.substring(0, end);
        }
        int index = path.indexOf(":");
        return path.substring(index+1);
    }
}
