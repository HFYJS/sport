$(function() {
	$("#edit").click(function() {
		if ($("input[type='checkbox']:checked").length != 1) {
			alert("必须且只能选中一个选择项！");
		} else {
			var gid = $("input[type='checkbox']:checked").val();
			$(this).attr("href", "/sport/ToModifyServlet?gid=" + gid)
		}
	})
	$("#remove").click(function() {
		if ($("input[type='checkbox']:checked").length == 0) {
			alert("必须选中一个或多个选择项！");
		} else {
			var gid = "";
			$("input[type='checkbox']:checked").each(function() {
				gid += $(this).val() + "*";
			})
			$(this).attr("href", "/sport/RemoveGoodsServlet?gid=" + gid)
		}
	})
})