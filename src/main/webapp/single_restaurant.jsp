<%@include file="header.jsp"%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style>
    .input_time {
        margin-inline: 1%;
    }
</style>

<section class="breadcrumb breadcrumb_bg2">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <div class="breadcrumb_iner">
                    <div class="breadcrumb_iner_item">
                        <h2>${restaurant.getName()}</h2>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

<section class="food_menu">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-lg-12">
                <div class="single-member">
                    <div class="row restaurant_item_row">
                        <div class="col-lg-12">
                            <div class="single_food_item media">
                                <img src="${restaurant.getImageUrl()}"
                                     class="img-responsive" alt="...">
                                <div class="media-body align-self-center">
                                    <h3>${restaurant.getName()}</h3>
                                    <p>${restaurant.getAddress()}</p>
                                    <h5><fmt:message key="restaurant.rating"/> ${restaurant.getRating()}</h5>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-12">
                            <div class="single_food_item" style="padding: 3%">
                               <h3><fmt:message key="restaurant.available"/></h3>
                                <br>
                                <div class="single_food_item media" style="width: 100%; border: none">
                                    <form method="POST" action="${pageContext.request.contextPath}/reserve">
                                        <input type="hidden" name="restaurant" value="${restaurant.getId()}">
                                        <c:forEach var="time" items="${date_time}">
                                            <c:choose>
                                                <c:when test="${time.booked == false}">
                                                    <input type="submit" class="btn btn-outline-secondary input_time" value="${time.getTime()}" name="time">
                                                </c:when>
                                                <c:otherwise>
                                                    <input type="submit" class="btn btn-outline-secondary input_time" value="${time.getTime()}" disabled>
                                                </c:otherwise>
                                            </c:choose>
                                        </c:forEach>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    </div>
</section>
</body>
</html>
<%@include file="footer.jsp"%>
