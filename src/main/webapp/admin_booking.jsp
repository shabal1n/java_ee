<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style>
    table, th, td {
        border: 1px solid black;
    }
</style>

<html>
<head>
    <title>Reservations</title>
</head>
<body>
    <div>
        <table>
            <tr>
                <td>Name</td>
                <td>Phone</td>
                <td>Date</td>
                <td>Persons</td>
            </tr>
            <c:forEach var="booking" items="${reservations}">
                <tr>
                    <td>${booking.getUserName()}</td>
                    <td>${booking.getUserPhone()}</td>
                    <td>${booking.getDateAndTime()}</td>
                    <td>${booking.getNumOfPersons()}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>
