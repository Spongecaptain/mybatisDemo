<%@ page isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<script  type="text/javascript">
    function myFunction(user)
    {
        document.write(user+"<br/>");
    }
</script>
<body>

<h2>How to iterate list on JSP in Spring MVC</h2>

<p><b>Simple List:</b><p>

    ${list}

<p><b>Iterated List:</b><p>

<ol>
    <c:forEach var="user" items="${list}">
        <%--        注释部分用于遍历时在文档上输出，不过我们这里不需要显示，而仅仅是调用 JavaScript 函数--%>
        <%--        User <c:out value="${user.toString()}"/><p/>--%>
        <script>
            myFunction("${user.toString()}");
        </script>
    </c:forEach>
</ol>

</body>
</html>