<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>

<style>
    .user_profile {
        width: 60%;
        border: 1px solid black;
        border-radius: 16px;
        margin: 3% auto 0;
        justify-content: center;
        text-align: center;
        padding: 2%;
    }
</style>
<section class="breadcrumb breadcrumb_bg2">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <div class="breadcrumb_iner">
                    <div class="breadcrumb_iner_item">
                        <h2><fmt:message key="label.profile"/> </h2>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

<div>
    <div class="user_profile">
        <p>Name: ${user.getFirstName()}</p>
        <p>Phone: ${user.getMobile()}</p>
        <p>Email: ${user.getEmail()}</p>
    </div>
</div>


</body>
</html>
