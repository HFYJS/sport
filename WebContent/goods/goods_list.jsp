<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品信息</title>
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
	<div id="p" class="easyui-panel" title="商品列表"
		style="width: 1200px; height: 480px; padding: 10px; background: #fafafa;"
		data-options="iconCls:'icon-save',closable:true,    
                collapsible:true">
		<a id="btn" href="/sport/ToAddGoodsServlet" class="easyui-linkbutton"
			data-options="iconCls:'icon-add',plain:true">Add</a> <a id="btn"
			href="#" class="easyui-linkbutton"
			data-options="iconCls:'icon-remove',plain:true">Remove</a> <a
			id="btn" href="#" class="easyui-linkbutton"
			data-options="iconCls:'icon-edit',plain:true">Edit</a>
		<table class="easyui-datagrid">
			<thead>
				<tr>
					<th data-options="field:'check'"><input type="checkbox" /></th>
					<th data-options="field:'name'">名称</th>
					<th data-options="field:'cate'">分类</th>
					<th data-options="field:'brand'">品牌</th>
					<th data-options="field:'price'">价格</th>
					<th data-options="field:'amount'">总数</th>
					<th data-options="field:'sales'">销量</th>
					<th data-options="field:'popularity'">人气</th>
					<th data-options="field:'des'">描述</th>
					<th data-options="field:'imgpath'">图片路径</th>
					<th data-options="field:'activity'">活动</th>
					<th data-options="field:'actprice'">活动价格</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td><input type="checkbox" /></td>
				</tr>
			</tbody>
		</table>
		<div id="pp" class="easyui-pagination"
			data-options="total:2000,pageSize:10"
			style="background: #efefef; border: 1px solid #ccc;"></div>
	</div>
</body>
</html>