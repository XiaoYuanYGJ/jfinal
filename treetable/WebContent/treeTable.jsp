<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script type="text/javascript" src="statics/js/jquery.js"></script>
<script type="text/javascript" src="statics/js/jquery.treetable.js"></script>
<link rel="stylesheet" href="statics/css/jquery.treetable.css">
<link rel="stylesheet"
	href="statics/css/jquery.treetable.theme.default.css">
 
<script type="text/javascript">
	// 用于拼接treeTable
	var str = "";

	$(function() {

		$.ajax({
			type : 'post',
			url : 'statics/json/data.json',
			dataType : 'json',
			success : function(data) {
				$.each(data, function(i, n) {
					
					// 最高级封装
					str = str + "<tr data-tt-id=\""+n.id+"\"><td>" + n.title
							+ "</td><td>" + n.id + "</td></tr>";

					// 判断是否有子节点
					if (n.nodes) {
						utilTree(n.nodes, n.id);
					}

				})
				console.log("封装的树形----》》》》" + str);
				$("#treeTable").append(str);
				$("#treeTable").treetable({

					expandable : true,
					initialState : "collapsed", // 初始化，collapsed：为折叠；expanded为展开
					clickableNodeNames : true, // 点击节点名称也打开子节点
					indent : 30
				// 每个分支缩进的像素数

				})
			}

		})

	})

	// data数据为子节点数据，id为父节点编号
	function utilTree(data, id) {
		// data为子节点数据，则表明为jsonArray数据
		$
				.each(
						data,
						function(i, n) {
							
							// 子节点封装
							str = str
									+ "<tr data-tt-id=\""+n.id+"\" data-tt-parent-id=\""+id+"\"><td>"
									+ n.title + "</td><td>" + n.id
									+ "</td></tr>";

							// 判断还有子节点，则调用自身方法
							if (data.nodes) {
								utilTree(data.nodes, data.id);
							}

						})

	}
</script>

</head>
<body>

	<div>
		<table class="table-striped table" id="treeTable" style="width: 80%">
			<tr>
				<td>模块名称</td>
				<td>标识码</td>
				<td>新增</td>
				<td>删除</td>
			</tr>
		</table>

	</div>

</body>
</html>