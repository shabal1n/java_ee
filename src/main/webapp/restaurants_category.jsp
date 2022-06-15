<%@include file="header.jsp" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">

<head>
    <!-- Required meta tags -->
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"/>
    <title>Restaurants</title>
</head>

<body>
<!-- breadcrumb start-->
<section class="breadcrumb breadcrumb_bg">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <div class="breadcrumb_iner">
                    <div class="breadcrumb_iner_item">
                        <h2><fmt:message key="button.restaurants"/></h2>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- breadcrumb start-->

<!-- food menu part start-->
<section class="food_menu">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-lg-12">
                <div class="single-member">
                    <div class="row restaurant_item_row">
                        <c:forEach var="restaurant" items="${restaurants}">
                            <div class="col-sm-6">
                                <div class="single_food_item media">
                                    <img src="${restaurant.getImageUrl()}"
                                         class="img-responsive" alt="...">
                                    <div class="media-body align-self-center">
                                        <h3>${restaurant.getName()}</h3>
                                        <p>${restaurant.getAddress()}</p>
                                        <h5>Rating: ${restaurant.getRating()}</h5>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                </div>
            </div>
        </div>
    </div>
    </div>
</section>
<!-- food menu part end-->
</body>

</html>
<%@include file="footer.jsp" %>