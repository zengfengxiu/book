<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>福州市数字图书馆系统</title>
<style type="text/css">
body { font: 12px 宋体;}
#div1 { width: 80%; margin: auto; border: #000 solid 1px;}
h3 { background-color: #069; color: #FFF; text-align: center; margin: 0px; padding: 10px;}
#table1 { line-height: 40px; margin: 10px; width: 100%;}
</style>
</head>

<body>
<div id="div1">
	<h3>修改图书</h3>
	<form name="" action="updateBook.do" method="post">
	<input name="book.id" value="${book.id}" type="hidden" />
    	<table id="table1">
        	<tr>
            	<td width="15%">图书编号：</td>
                <td width="35%"><input name="book.no" type="text" value="${book.no}" readonly="readonly" /></td>
            	<td width="15%">图书名称：</td>
                <td width="35%"><input name="book.name" type="text" value="${book.name}" /></td>
            </tr>
        	<tr>
            	<td>图书类型：</td>
                <td>
                	<select name="book.type.id">
                	<option value="-1">不限</option>
 							<c:forEach items="${typeList}" var="type">
								<option value="${type.id}">${type.name}</option>
							</c:forEach>
                    </select>
                </td>
            	<td>作者：</td>
                <td><input name="book.author" type="text" value="${book.author}" /></td>
            </tr>
        	<tr>
            	<td>价格：</td>
                <td><input name="book.price" type="text" value="${book.price}" /></td>
            	<td>数量：</td>
                <td><input name="book.quantity" type="text" value="${book.quantity}" /></td>
            </tr>
        	<tr>
            	<td>出版社：</td>
                <td><input name="book.publisher" type="text" value="${book.publisher}" /></td>
            	<td>备注：</td>
                <td><input name="book.remark" type="text" value="${book.remark}" /></td>
            </tr>
        	<tr>
            	<td>&nbsp;</td>
                <td><input name="" type="submit" value="确定"  /><input name="" type="reset" value="重置" /></td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
