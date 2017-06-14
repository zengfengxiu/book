<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	width: 100%;
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
</head>

<body>
	<div id="div1">
		<h3>查询结果</h3>
		<table id="table1">
			<tr>
				<td width="10%">图书编号</td>
				<td width="25%">图书名称</td>
				<td width="25%">出版社</td>
				<td width="10%">作者</td>
				<td width="10%">图书类型</td>
				<td width="10%">价格</td>
				<td width="10%">备注</td>
			</tr>
			<c:forEach items="${bookList}" var="book">
				<tr>
					<td>${book.no}</td>
					<td>${book.name}</td>
					<td>${book.publisher}</td>
					<td>${book.author}</td>
					<td>${book.type.name}</td>
					<td>${book.price}</td>
					<td>${book.remark}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<p>
		页号：${pageNo} / ${totalPages}
		<a href="listBook.do?pageNo=1">首页</a>
		<c:if test="${pageNo>1}">
			<a href="listBook.do?pageNo=${pageNo-1}">上一页</a>
		</c:if>
		<c:if test="${pageNo<totalPages}">
			<a href="listBook.do?pageNo=${pageNo+1}">下一页</a>
		</c:if>
		<a href="listBook.do?pageNo=${totalPages}">尾页</a>
	</p>
</body>
</html>
