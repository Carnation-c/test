<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>用户注册</title>
</head>
<body>
<form action="${pageContext.request.contextPath }/registerServlet" method="post">
    ${msg }
    <table>
        <tr>
            <td>用&nbsp;户&nbsp;名&nbsp;：</td>
            <td><input type="text" name="username" value=""/></td>
        </tr>
        <tr>
            <td>密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码&nbsp;：</td>
            <td><input type="password" name="password" /></td>
        </tr>
    </table>
    <input type="submit" value="注册"/><br/>
</form>
</body>
</html>