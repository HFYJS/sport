<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品修改</title>
<link rel="stylesheet" type="text/css"
	href="/sport/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="/sport/easyui/themes/icon.css">
<script type="text/javascript" src="/sport/easyui/jquery.min.js"></script>
<script type="text/javascript" src="/sport/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="/sport/easyui/locale/easyui-lang-zh_CN.js"></script>
</head>
<body>
	<div id="p" class="easyui-panel" title="商品修改"
		style="width: 1200px; height: 480px; padding: 10px; background: #fafafa;"
		data-options="iconCls:'icon-save',collapsible:true">
		<form method="post" action="/sport/AddGoodsServlet">
			<input type="hidden" name="sid" value="1" /> 商品名称：<input type="text"
				name="name" value="${goods.name }" /><br> <br>
			分&nbsp;&nbsp;类：<select name="catid"><c:forEach var="cate"
					items="${cates }">
					<option value="${cate.catid }"><c:out
							value="${cate.name }"></c:out></option>
				</c:forEach></select><br> <br> 品&nbsp;&nbsp;牌：<input type="text" name="brand"
				value="${goods.brand }" /><br> <br> 价&nbsp;&nbsp;格：<input
				type="text" name="price" value="${goods.price }" /><br> <br>
			总&nbsp;&nbsp;数：<input type="text" name="amount"
				value="${goods.amount }" /><br> <br> 销&nbsp;&nbsp;量：<input
				type="text" name="sales" value="${goods.sales }" /><br> <br>
			人&nbsp;&nbsp;气：<input type="text" name="popularity"
				value="${goods.popularity }" /><br> <br> 描&nbsp;&nbsp;述：<input
				type="text" name="des" value="${goods.des }" /><br> <br>
			图片路径：<input type="text" name="imgpath" value="${goods.imgPath }" /><br>
			<br> 活&nbsp;&nbsp;动：<select name="actid"><c:forEach
					var="activity" items="${activities }">
					<option value="${activity.actid }"><c:out
							value="${activity.name }"></c:out></option>
				</c:forEach></select><br> <br> 活动价格：<input type="text" name="actprice"
				value="${goods.actPrice }" /><br> <br> <input
				type="submit" value="修改" /> <input type="reset" value="取消" />
		</form>
	</div>
</body>
</html>