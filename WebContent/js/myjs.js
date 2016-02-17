$(function() {
	$("#edit").click(function() {
		if ($("input[type='checkbox']:checked").length != 1) {
			alert("必须且只能选中一个选择项！");
		} else {
			var gid = $("input[type='checkbox']:checked").val();
			$(this).attr("href", "/sport/ToModifyServlet?gid=" + gid)
		}
	})
})