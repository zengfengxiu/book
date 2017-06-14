<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
	<h3>修改读者</h3>
	<form name="" action="updateReader.do" method="post">
		<input name="reader.id" value="${reader.id}" type="hidden" />
    	<table id="table1">
        	<tr>
            	<td width="30%">读者编号：</td>
                <td width="70%"><input name="reader.no" value="${reader.no}" type="text"  readonly="readonly" /></td>
            </tr>
        	<tr>
            	<td>读者姓名：</td>
                <td><input name="reader.name" value="${reader.name}" type="text" /></td>
            </tr>
        	<tr>
            	<td>电话：</td>
                <td><input name="reader.phone" value="${reader.phone}" type="text"/></td>
            </tr>
        	<tr>
            	<td>地址：</td>
                <td><input name="reader.address" value="${reader.address}" type="text"/></td>
            </tr>
        	<tr>
            	<td>备注：</td>
                <td><input name="reader.remark" value="${reader.remark}" type="text" /></td>
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
