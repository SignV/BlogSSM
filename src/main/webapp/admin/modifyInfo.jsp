<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改人信息</title>
    <%@include file="./common/head.jspf"%>
    <script type="text/javascript" charset="utf-8"
            src="${blog}/static/ueditor1_4_3_3/ueditor.config.js"></script>
    <script type="text/javascript" charset="utf-8"
            src="${blog}/static/ueditor1_4_3_3/ueditor.all.min.js">
    </script>
    <!--建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败-->
    <!--这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文-->
    <script type="text/javascript" charset="utf-8"
            src="${blog}/static/ueditor1_4_3_3/lang/zh-cn/zh-cn.js"></script>
</head>
<body style="margin: 10px; font-family: microsoft yahei">
    <div id="p" class="easyui-panel" title="修改人信息" style="padding: 10px">
        <c:if test="${!flag && flag != null}">
            <span style="font-weight: bold;font-size: 18px;color: #e41311;">修改博主信息失败!</span>
        </c:if>
        <c:if test="${flag}">
            <span style="font-weight: bold;font-size: 18px;color: #e41311;">修改博主信息成功!</span>
        </c:if>
        <form method="post" id="fm" action="/admin/blogger/save.do" enctype="multipart/form-data">
            <table cellspacing="20px">
                <tr>
                    <td width="80px">用户ID：</td>
                    <td>
                        <input type="text" id="id" name="id" style="width:200px;border: none" readonly="readonly" value="${blogger.id }"/>
                    </td>
                </tr>
                <tr>
                    <td width="80px">用户名：</td>
                    <td>
                        <input type="text" id="userName" name="userName" style="width:200px;border: none" readonly="readonly" value="${blogger.userName }"/>
                    </td>
                </tr>
                <tr>
                    <td>昵称：</td>
                    <td>
                        <input type="text" id="nickName" name="nickName" style="width:200px" value="${blogger.nickName}"
                              />
                    </td>
                </tr>
                <tr>
                    <td>个性签名：</td>
                    <td>
                        <input type="text" id="sign" name="sign" style="width:400px;" value="${blogger.sign}"
                                />
                    </td>
                </tr>
                <tr>
                    <td>个人头像：</td>
                    <td>
                        <img src="${pageContext.request.contextPath}/static/userImages/${blogger.imageName}" width="100" height="170"/>
                        <br/>
                        <input type="file" id="imageFile" name="imageFile"/>
                    </td>
                </tr>
                <tr>
                    <td>个人简介：</td>
                    <td>
                        <textarea id="profile" name="profile" rows="6" cols="54">${blogger.profile}</textarea>
                    </td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="提交">
                </tr>
            </table>
        </form>
    </div>

</body>
</html>
