<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>福州市数字图书馆系统</title>
<style type="text/css">
body {
	font: 12px 宋体;
}

#div1 {
	width: 80%;
	margin: auto;
	border: #000 solid 1px;
}

h3 {
	background-color: #069;
	color: #FFF;
	text-align: center;
	margin: 0px;
	padding: 10px;
}

#table1 {
	line-height: 20px;
	margin: 10px;
	width: 100%;
}

p {
	text-align: center;
}

a {
	color: #00F;
	text-decoration: none;
}
</style>

<script>
	function setValue(chk, no) {
		var readerNo = document.getElementById("readerNo");
		if (chk.checked) {
			readerNo.value = no;
		} else {
			readerNo.value = "";
		}
	}

	function doSubmit() {
		var readerNo = document.getElementById("readerNo");
		if (readerNo.value == "") {
			alert("请选择会员！");
			return;
		}
		form1.submit();
	}
</script>
</head>

<body>
	<div id="div1">
		<h3>请选择会员</h3>
		<form name="form1" action="addReturn.do" method="post">
			<input type="hidden" name="borrow.bookNo" value="${borrow.bookNo}" />
			<input type="hidden" id="readerNo" name="borrow.readerNo" />
			<table id="table1">
				<tr>
					<td width="5%">&nbsp;</td>
					<td width="15%">会员编号</td>
					<td width="15%">会员名称</td>
					<td width="15%">书籍编号</td>
					<td width="20%">书籍名称</td>
					<td width="15%">借书日期</td>
					<td width="15%">操作员</td>
				</tr>
				<c:forEach items="${brList}" var="br">
					<tr>
						<td><input name="" type="checkbox"
							onclick="setValue(this, '${br.readerNo}');" /></td>
						<td>${br.readerNo}</td>
						<td>${br.readerName}</td>
						<td>${br.bookNo}</td>
						<td>${br.bookName}</td>
						<td><fmt:formatDate value="${br.borrowDate}"
								pattern="yyyy-MM-dd" /></td>
						<td>${br.oper}</td>
					</tr>
				</c:forEach>
				<tr>
					<td colspan="7" style="text-align: center;"><input name=""
						type="button" value="确定" onclick="doSubmit();" /><input name=""
						type="reset" value="重置" /></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>
