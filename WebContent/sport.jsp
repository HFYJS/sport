<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<link href="css/public.css" type="text/css" rel="stylesheet">
<link href="css/houtai.css" type="text/css" rel="stylesheet">
<link href="css/smartMenu.css" type="text/css" rel="stylesheet">
<title>运动圈</title>
</head>
<body>
	<div id="admin">
		<div class="ad-menu" id="ad-menu">
			<div class="ad-logo">
				<img src="image/m-logo.png" height="103" width="240">
			</div>
			<div class="ad-list">
				<ul>

					<li>
						<div class="li-item">
							<em class="scm li-ico ic2"></em>店面管理<span class="scm arrow"></span>
						</div>
						<dl>
							<dd>
								<a href="#" class="dd-item">店面信息<span class="scm dd-ar"></span></a>
							</dd>
							<dd>
								<a href="#" class="dd-item">修改信息<span class="scm dd-ar"></span></a>
							</dd>
						</dl>
					</li>
					<li>
						<div class="li-item">
							<em class="scm li-ico ic1"></em>商品管理<span class="scm arrow"></span>
						</div>
						<dl>
							<dd>
								<a href="#" class="dd-item">商品列表<span class="scm dd-ar"></span></a>
								<ul class="ad-item-list">
									<li class="J_menuItem" href="index_v1.html" data-index="1">测试用例一</li>
									<li class="J_menuItem" href="index_v2.html" data-index="2">测试用例二</li>
									<li class="J_menuItem" href="index_v3.html" data-index="3">测试用例三</li>
								</ul>
							</dd>
							<dd>
								<a href="#" class="dd-item">商品添加<span class="scm dd-ar"></span></a>
								<ul class="ad-item-list">
									<li class="J_menuItem" href="index_v1.html" data-index="1">测试用例一</li>
									<li class="J_menuItem" href="index_v2.html" data-index="2">测试用例二</li>
									<li class="J_menuItem" href="index_v3.html" data-index="3">测试用例三</li>
								</ul>
							</dd>
						</dl>
					</li>
					<li>
						<div class="li-item">
							<em class="scm li-ico ic1"></em>销售管理<span class="scm arrow"></span>
						</div>
						<dl>
							<dd>
								<a href="#" class="dd-item">订单处理<span class="scm dd-ar"></span></a>
								<ul class="ad-item-list">
									<li class="J_menuItem" href="index_v1.html" data-index="1">测试用例一</li>
									<li class="J_menuItem" href="index_v2.html" data-index="2">测试用例二</li>
									<li class="J_menuItem" href="index_v3.html" data-index="3">测试用例三</li>
								</ul>
							</dd>
							<dd>
								<a href="#" class="dd-item">发货处理<span class="scm dd-ar"></span></a>
								<ul class="ad-item-list">
									<li class="J_menuItem" href="index_v1.html" data-index="1">测试用例一</li>
									<li class="J_menuItem" href="index_v2.html" data-index="2">测试用例二</li>
									<li class="J_menuItem" href="index_v3.html" data-index="3">测试用例三</li>
								</ul>
							</dd>
						</dl>
					</li>
				</ul>
			</div>
		</div>
		<div class="ad-comment-box" id="ad-comment">
			<div class="ad-top-comment">
				<div class="ad-message">
					<div class="ad-top-left">
						<div class="ad-search-box clear">
							<div class="ad-search-sel">
								<select>
									<option>新闻类</option>
									<option>新闻吩咐道类</option>
									<option>新闻广告费类</option>
									<option>新闻苟富贵类</option>
								</select>
							</div>
							<div class="ad-search-cha">
								<input type="text" class="ad-search-input"
									placeholder="请输入你要查找的内容"> <input type="submit"
									class="scm ad-search-btn" value="">
							</div>
						</div>
					</div>
					<div class="ad-top-right">
						<div class="ad-welcom">
							<div class="ad-wel-text">
								<div class="font-wel">
									欢迎您！<strong>李春华</strong>
								</div>
								<div class="font-wel">
									<a href="javascript:;"><strong>【退出】</strong></a>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="ad-sub-nav-box content-tabs">
					<div class="ad-sub-wraper page-tabs J_menuTabs">
						<ul class="ad-sub-list page-tabs-content">
							<li class="active J_menuTab" data-id="index_v0.html">首页</li>
						</ul>
					</div>
				</div>
			</div>
			<div class="ad-main-comment J_mainContent" id="ad-iframe">
				<iframe class="J_iframe" name="iframe0" width="100%" height="100%"
					src="/sport/ToGoodsListServlet" frameborder="0"
					data-id="index_v0.html" seamless></iframe>
			</div>
		</div>
	</div>
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript" src="js/contabs.js"></script>
	<script type="text/javascript" src="js/maintabs.js"></script>
	<script type="text/javascript" src="js/jquery-smartMenu-min.js"></script>
	<script type="text/javascript" src="js/jquery.nicescroll.min.js"></script>
	<script type="text/javascript">
		$(function() {
			$(".ad-menu").niceScroll({
				cursorborder : "0 none",
				cursorcolor : "#1a1a19",
				cursoropacitymin : "0",
				boxzoom : false
			});
		})
	</script>
</body>
</html>