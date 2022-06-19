<%@include file="header.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<section class="breadcrumb breadcrumb_bg2">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <div class="breadcrumb_iner">
                    <div class="breadcrumb_iner_item">
                        <h2>${restaurant.getName()}</h2>
                        <h4>${restaurant.getAddress()}</h4>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

<form method="POST">
    <p>Time: </p>
    <input type="number">
    <input type="submit" value="Confirm">
</form>

</body>
</html>
<%@include file="footer.jsp"%>
