<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ page session="true" %>
<%@ page isELIgnored="false" %>

<fmt:setBundle basename="language"/>
<fmt:setLocale value="${sessionScope.language}" scope="session"/>

<style>
    <%@include file="res/css/style.css"%>
</style>

<html lang="${sessionScope.language}">
<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"/>
    <link rel="icon" href='res/img/logo.png'/>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <!-- themify CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/gh/lykmapipo/themify-icons@0.1.2/css/themify-icons.css" type="text/css"/>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.1/css/all.min.css" type="text/css"/>
    <link rel="stylesheet" href="res/css/style.css" type="text/css"/>
</head>
<body>
<header class="main_menu home_menu">
    <div class="container">
        <div class="row align-items-center">
            <div class="col-lg-12">
                <nav class="navbar navbar-expand-lg navbar-light">
                    <a class="navbar-brand" href="/">
                        <img src="res/img/logo.png" alt="logo"/>
                    </a>
                    <button class="navbar-toggler" type="button" data-toggle="collapse"
                            data-target="#navbarSupportedContent"
                            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>

                    <div class="collapse navbar-collapse main-menu-item justify-content-end"
                         id="navbarSupportedContent">
                        <ul class="navbar-nav">
                            <li class="nav-item">
                                <a class="nav-link" href="/"><fmt:message key="button.home"/></a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="restaurants"><fmt:message key="button.restaurants"/></a>
                            </li>
                            <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle" href="blog.html" id="navbarDropdown" role="button"
                                   data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    <fmt:message key="button.categories"/>
                                </a>
                                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                    <a class="dropdown-item" href="blog.html">Blog</a>
                                    <a class="dropdown-item" href="single-blog.html">Single blog</a>
                                </div>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="map"><fmt:message key="button.map"/></a>
                            </li>
                        </ul>
                    </div>
                    <div class="social_icon d-none d-lg-block">
                        <a href="#" class="single_social_icon"><i class="fa fa-search"></i></a>
                        <a href="login" class="single_social_icon"><i class="fa fa-user"></i></a>
                        <select onchange="window.location.href = '?sessionLocale='.concat(this.value)">
                            <c:choose>
                                <c:when test="${sessionScope.language == 'en'}">
                                    <option value="en" selected>EN</option>
                                    <option value="ru">RU</option>
                                </c:when>
                                <c:otherwise>
                                    <option value="en">EN</option>
                                    <option value="ru" selected>RU</option>
                                </c:otherwise>
                            </c:choose>
                        </select>
                    </div>
                </nav>
            </div>
        </div>
    </div>
</header>
