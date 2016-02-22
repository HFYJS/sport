<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>欢迎来到——运动圈商家管理系统</title>
<link rel="stylesheet" type="text/css"
	href="/sport/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="/sport/easyui/themes/icon.css">
<script type="text/javascript" src="/sport/easyui/jquery.min.js"></script>
<script type="text/javascript" src="/sport/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="/sport/easyui/locale/easyui-lang-zh_CN.js"></script>
</head>
<body class="easyui-layout">
	<div data-options="region:'north',title:'用户名：${shop.user.name }'"
		style="height: 200px;">
		<image src="/sport/img/1.png" width="100%" height="100%" />
	</div>
	<div data-options="region:'west',title:'导航',split:true"
		style="width: 150px;"></div>
	<div data-options="region:'center',title:'业务中心'"
		style="padding: 5px; background: #eee;">
		<iframe src="/sport/ToGoodsListServlet" width="100%" height="100%"
			frameborder="no" marginwidth="0" marginheight="0"> </iframe>
	</div>
</body>
</html>