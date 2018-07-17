<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/bootstrap3/css/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/bootstrap3/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/blog.css">
<script src="${pageContext.request.contextPath}/static/bootstrap3/js/jquery-1.11.2.min.js"></script>
<script src="${pageContext.request.contextPath}/static/bootstrap3/js/bootstrap.min.js"></script>
<title>博客主页</title>
<style type="text/css">
	body{
		padding-top:10px;
		padding-bottom:40px;
		background-color: #F8F8FF;
		font-family: microsoft yahei;
	}
	.container{
		width: 1200px;
	}
</style>
</head>

<body>
	<%--<%--%>
		<%--String userName = request.getParameter("userName");--%>
		<%--if(userName == null){--%>
		    <%--response.sendRedirect("/login.jsp");--%>
		<%--}--%>
	<%--%>--%>
	<div class="container">
		<div class="row">
			<div class="col-md-4">
				<div class="blog"><strong>${blogger.nickName}的博客</strong></div>
			</div>
			<div class="col-md-8">
				<iframe style="float:right" width="420" scrolling="no" height="60" frameborder="0"
					allowtransparency="true"
					src="http://i.tianqi.com/index.php?c=code&id=12&icon=1&num=5"></iframe>
			</div>
		</div>
		
		<div class="row" style="padding-top: 10px">
			<div class="col-md-12">
				<nav class="navbar navbar-default">
				  <div class="container-fluid">				    
				    <!-- Collect the nav links, forms, and other content for toggling -->
				    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
				      <ul class="nav navbar-nav">
				      	<li class="active"><a class="navbar-brand" href="/index.jsp">博客首页</a></li>
				        <li><a class="navbar-brand" href="/blogType.jsp">关于博主</a></li>
				        <li><a class="navbar-brand" href="#">我的相册</a></li>
				        <li><a class="navbar-brand" href="#">资源小站</a></li>
				        <li><a class="navbar-brand" href="#">程序人生</a></li>
				        <li><a class="navbar-brand" href="#">CSDN</a></li>
				      </ul>
				      <form class="navbar-form navbar-right" role="search" action="/blog/getBlogByKey.do">
				        <div class="form-group">
				          <input type="text" name="searchKey" class="form-control" placeholder="请输入要查询的关键字">
				        </div>
				        <button type="submit" class="btn btn-default">搜索</button>
				      </form>
				    </div><!-- /.navbar-collapse -->
				  </div><!-- /.container-fluid -->
				</nav>
			</div>
		</div>
		<%--<script type="application/javascript">--%>
			<%--alert(${blogger.imageName})--%>
		<%--</script>--%>
		<div class="row">	
		  <div class="col-md-3">
		  	<div class="data_list">
				<div class="data_list_title">
					<img src="${pageContext.request.contextPath}/static/images/user_icon.png"/>
					博主信息
				</div>
				<div class="user_image" width="100%" height="100%">
					<img src="${pageContext.request.contextPath}/static/userImages/${blogger.imageName}"/>
				</div>
				<div class="nickName" align="center">昵称：${blogger.nickName }</div>
				<div class="userSign" align="center">签名：${blogger.sign }</div>
			</div>	
			
			<div class="data_list">
				<div class="data_list_title">
					<img src="${pageContext.request.contextPath}/static/images/byType_icon.png"/>
					文章分类
				</div>
				<div class="datas">
					<ul>						
							<c:forEach items="${blogTypeList }" var="blogType">
								<li><span><a href="/blog/getBlogByType.do?id=${blogType.id}">${blogType.typeName }（${blogType.blogCount }）</a></span></li>
							</c:forEach>					
					</ul>
				</div>
			</div>
			
			<div class="data_list">
				<div class="data_list_title">
					<img src="${pageContext.request.contextPath}/static/images/byDate_icon.png"/>
					文章存档
				</div>
				<div class="datas">
					<ul>						
							<c:forEach items="${blogList }" var="blog">
								<li><span><a href="#">${blog.releaseDateStr }（${blog.blogCount }）</a></span></li>
							</c:forEach>						
					</ul>
				</div>
			</div>
			
			<div class="data_list">
				<div class="data_list_title">
					<img src="${pageContext.request.contextPath}/static/images/link_icon.png"/>
					友情链接
				</div>
				<div class="datas">
					<ul>						
						<c:forEach items="${linkList }" var="link">
							<li><span><a href="${link.linkUrl }" target="_blank">${link.linkName }</a></span></li>
						</c:forEach>											
					</ul>
				</div>
			</div>
			
			  	
		  </div>
		  	  
		  <div class="col-md-9">
		  	<div class="data_list">
				<c:if test="${blogInfoList !=null }">
		  		<div class="data_list_title">
					<img src="${pageContext.request.contextPath}/static/images/list_icon.png"/>&nbsp;该类相关博客
				</div>	
				<div class="datas">
					<ul>

						<c:forEach items="${blogInfoList }" var="blogInfo">
							<li><span><a href="/blog/getBlogByClick.do?id=${blogInfo.id}">${blogInfo.title }（${blogInfo.blogType.typeName }）</a></span></li>

							<li style="margin-bottom: 30px">
                                <span class="title">
                                    <img alt="文章类型" src="${pageContext.request.contextPath}/static/userImages/yuan.jpg">
                                    ${blogInfo.title }
                                </span>
								<span class="summary">${blogInfo.summary }</span>
								<span class="img">
                                        &nbsp;&nbsp;
                                </span>
								<span class="info">
                                    <font color="#999">${blogInfo.releaseDate }</font> &nbsp;&nbsp;
                                    <font color="#33a5ba"><a href="#">阅读</a><font color="#999">(${blogInfo.clickHit })</font>&nbsp;&nbsp;</font>
                                    <font color="#33a5ba"><a href="#">评论</a><font color="#999">(${blogInfo.replyHit })</font>&nbsp;&nbsp;</font>
                                </span>
							</li>
							<hr style="height:5px;border:none;border-top:1px dashed gray;padding-bottom:10px;" />
						</c:forEach>

					</ul>
				</div>
				</c:if>

				<c:if test="${blogInfoList == null && keyBlogList == null && clickBlog == null}">
					<div class="data_list_title">
						<img src="${pageContext.request.contextPath}/static/images/list_icon.png"/>&nbsp;最新博客
					</div>
					<div class="datas">
						<ul>

							<c:forEach items="${newBlogList }" var="newBlogInfo">
								<li><span><a href="/blog/getBlogByClick.do?id=${newBlogInfo.id}">${newBlogInfo.title }（${newBlogInfo.blogType.typeName }）</a></span></li>

								<li style="margin-bottom: 30px">
                                <span class="title">
                                    <img alt="文章类型" src="${pageContext.request.contextPath}/static/userImages/yuan.jpg">
                                    ${newBlogInfo.title }
                                </span>
									<span class="summary">${newBlogInfo.summary }</span>
									<span class="img">
                                        &nbsp;&nbsp;
                                </span>
									<span class="info">
                                    <font color="#999">${newBlogInfo.releaseDate }</font> &nbsp;&nbsp;
                                    <font color="#33a5ba"><a href="#">阅读</a><font color="#999">(${newBlogInfo.clickHit })</font>&nbsp;&nbsp;</font>
                                    <font color="#33a5ba"><a href="#">评论</a><font color="#999">(${newBlogInfo.replyHit })</font>&nbsp;&nbsp;</font>
                                </span>
								</li>
								<hr style="height:5px;border:none;border-top:1px dashed gray;padding-bottom:10px;" />
							</c:forEach>
						</ul>
					</div>
				</c:if>

				<c:if test="${keyBlogList != null}">
					<div class="data_list_title">
						<img src="${pageContext.request.contextPath}/static/images/list_icon.png"/>&nbsp;最新博客
					</div>
					<div class="datas">
						<ul>

							<c:forEach items="${keyBlogList }" var="keyBlogInfo">
								<li><span><a href="/blog/getBlogByClick.do?id=${keyBlogInfo.id}">${keyBlogInfo.title }（${keyBlogInfo.blogType.typeName }）</a></span></li>

								<li style="margin-bottom: 30px">
                                <span class="title">
                                    <img alt="文章类型" src="${pageContext.request.contextPath}/static/userImages/yuan.jpg">
                                    ${keyBlogInfo.title }
                                </span>
									<span class="summary">${keyBlogInfo.summary }</span>
									<span class="img">
                                        &nbsp;&nbsp;
                                </span>
									<span class="info">
                                    <font color="#999">${keyBlogInfo.releaseDate }</font> &nbsp;&nbsp;
                                    <font color="#33a5ba"><a href="#">阅读</a><font color="#999">(${keyBlogInfo.clickHit })</font>&nbsp;&nbsp;</font>
                                    <font color="#33a5ba"><a href="#">评论</a><font color="#999">(${keyBlogInfo.replyHit })</font>&nbsp;&nbsp;</font>
                                </span>
								</li>
								<hr style="height:5px;border:none;border-top:1px dashed gray;padding-bottom:10px;" />
							</c:forEach>
						</ul>
					</div>
				</c:if>
				<%--点击进入查看博客--%>
				<c:if test="${clickBlog != null}">
					<div class="data_list_title">
						<img src="${pageContext.request.contextPath}/static/images/list_icon.png"/>&nbsp;最新博客
					</div>
					<div class="datas">
						<ul>
								<li><span>${clickBlog.title }（${clickBlog.blogType.typeName }）</span></li>

								<li style="margin-bottom: 30px">
                                <span class="title">
                                    <img alt="文章类型" src="${pageContext.request.contextPath}/static/userImages/yuan.jpg">
                                    ${clickBlog.title }
                                </span>
									<span class="summary">${clickBlog.summary }</span>
									<span class="content">${clickBlog.content }</span>
									<span class="img">
                                        &nbsp;&nbsp;
                                </span>
									<span class="info">
                                    <font color="#999">${clickBlog.releaseDate }</font> &nbsp;&nbsp;
                                    <font color="#33a5ba"><a href="#">阅读</a><font color="#999">(${clickBlog.clickHit })</font>&nbsp;&nbsp;</font>
                                    <font color="#33a5ba"><a href="#">评论</a><font color="#999">(${clickBlog.replyHit })</font>&nbsp;&nbsp;</font>
                                </span>
								</li>
								<hr style="height:5px;border:none;border-top:1px dashed gray;padding-bottom:10px;" />
						</ul>
					</div>
				</c:if>
		  	</div>
		  </div>
		  
		</div>
		
		<div class="row">
			<div class="col-md-12" >
				<div class="footer" align="center" style="padding-top: 120px" >
					<font>Copyright © 2012-2017 SSM个人博客系统 版权所有</font>
					  
				</div>
			</div>			
		</div>
	</div>
</body>
</html>
