<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>福州市数字图书馆系统</title>
<style type="text/css">
body { font: 12px 宋体;}
#div1 { width: 50%; margin: auto; border: #000 solid 1px;}
h3 { background-color: #069; color: #FFF; text-align: center; margin: 0px; padding: 10px;}
#table1 { line-height: 40px; margin: 10px; width: 100%;}
</style>
</head>

<body>
<div id="div1">
	<h3>删除图书类型</h3>
	<form name="" action="deleteType.do" method="post">
    	<table id="table1">
        	<tr>
            	<td width="30%">图书类型名称：</td>
                <td width="70%">
                	<select name="type.id">
 							<c:forEach items="${list}" var="type">
								<option value="${type.id}">${type.name}</option>
							</c:forEach>
                    </select>
                </td>
            </tr>
        	<tr>
            	<td>&nbsp;</td>
                <td><input name="" type="submit" value="确定" /><input name="" type="reset" value="重置" /></td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
