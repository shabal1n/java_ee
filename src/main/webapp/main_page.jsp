<%@include file="header.jsp"%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<section class="banner_part">
    <div class="container">
        <div class="row align-items-center">
            <div class="col-lg-7">
                <div class="banner_text">
                    <div class="banner_text_iner">
                        <h5><fmt:message key="label.title"/></h5>
                        <h1><fmt:message key="label.modern"/></h1>
                        <a href="#" class="btn_1"><fmt:message key="button.book"/></a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- banner part start-->

<!-- about part start-->
<section class="about_part">
    <div class="container">
        <div class="row align-items-center justify-content-center">
            <div class="col-lg-12">
                <div class="about_part_iner">
                    <div class="row align-items-center">
                        <div class="col-lg-7">
                            <div class="about_text">
                                <h5><fmt:message key="label.top"/></h5>
                                <h2>${top1.getName()}</h2>
                                <p>${top1.getAddress()}</p>
                                <h5>Rating: ${top1.getRating()}</h5>
                                <a href="${pageContext.request.contextPath}/book?id=${top1.getId()}" class="btn_3">Book a table</a>
                            </div>
                        </div>
                        <div class="col-lg-5">
                            <div class="about_img">
                                <img src="${top1.getImageUrl()}" alt=""/>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- about part end-->

<!-- food_menu start-->
<section class="food_menu">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-lg-5">
                <div class="section_tittle">
                    <h2><fmt:message key="label.popular"/></h2>
                </div>
            </div>
            <div class="col-lg-12">
                <div class="single-member">
                    <div class="row">
                        <c:forEach var="restaurant" items="${top6}">
                            <div class="col-sm-6" onclick="location.href='${pageContext.request.contextPath}/book?id=${restaurant.getId()}'">
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
</section>
<!-- food_menu part end-->
</body>

</html>
<%@include file="footer.jsp"%>

