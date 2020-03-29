
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>学习预约</title>
</head>
<head>
    <style type="text/css">
        #head
        {
            margin: 0 auto;
            position: relative;
            top:200px;
            display: flex;
            flex-direction: column;
            border:1px solid wheat;
            width: 200px;
            height: 300px;
            background-color:moccasin;
            color:linen;

        }
        select
        {
            margin-top: 30px;
        }
        h3
        {
            color:sandybrown;
            font-weight: bolder;
            text-align: center;
        }
        #submit
        {
            width: 40px;
            position: relative;
            left:80px;
            top:100px;
            color:linen;
            background-color:coral;
        }
        select
        {
            background-color:lightyellow;
        }
    </style>
</head>
<body>
<form action="${pageContext.request.contextPath }/studyServlet" method="post">
<div id="head">
    <h3>相关预约</h3>
    <select name="study">
        <option value="4">学习</option>
        <option value="5">自习</option>
        <option value="6">辅导</option>
    </select>
    <input  id="submit" type="submit" value="预约"/>
</div>
</form>
</body>
</html>
