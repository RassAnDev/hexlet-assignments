<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- BEGIN -->
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <title>User</title>
        <meta charset="UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We"
            crossorigin="anonymous">
    </head>
    <body>
    <table>
            <tr>
            <td>${user.get("id")}</td>
            <td>${user.get("firstName")} ${user.get("lastName")} ${user.get("email")}
            <a href='/users/delete?id=${user.get("id")}'>Удалить пользователя</a></td>
            </tr>
    </table>
    </body>
</html>
<!-- END -->
