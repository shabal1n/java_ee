<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ page session="true" %>
<%@ page isELIgnored="false" %>

<fmt:setBundle basename="language"/>
<fmt:setLocale value="${sessionScope.language}" scope="session"/>

<html lang="${sessionScope.language}">
<head>
    <style>
        body {
            display: flex;
            align-items: center;
            background-image: url("res/img/banner_bg.png");
        }

        #registration_container {
            background-color: white;
            width: 40%;
            height: 50%;
            border: 1px solid lightgray;
            padding: 5%;
            border-radius: 5px;
            margin: 0 auto;
        }
    </style>
    <title>Bookout</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<div id="registration_container">
    <form method="POST">
        <!-- Email input -->
        <div class="form-outline mb-4">
            <input type="email" id="form2Example1" class="form-control" name="email"/>
            <label class="form-label" for="form2Example1"><fmt:message key="login.email"/></label>
        </div>

        <!-- Password input -->
        <div class="form-outline mb-4">
            <input type="password" id="form2Example2" class="form-control" name="password"/>
            <label class="form-label" for="form2Example2"><fmt:message key="login.password"/></label>
        </div>

        <!-- 2 column grid layout for inline styling -->
        <div class="row mb-4">
            <div class="col d-flex justify-content-center">
                <!-- Checkbox -->
                <div class="form-check">
                    <input class="form-check-input" type="checkbox" value="" id="form2Example31" checked/>
                    <label class="form-check-label" for="form2Example31"> <fmt:message key="login.remember"/> </label>
                </div>
            </div>

            <div class="col">
                <!-- Simple link -->
                <a href="#!"><fmt:message key="login.forgot"/></a>
            </div>
        </div>

        <!-- Submit button -->
        <button type="submit" class="btn btn-primary btn-block mb-4"><fmt:message key="login.sign"/></button>

        <!-- Register buttons -->
        <div class="text-center">
            <p><fmt:message key="login.member"/> <a href="registration"><fmt:message key="login.register"/></a></p>
        </div>
    </form>
</div>
</body>
</html>
