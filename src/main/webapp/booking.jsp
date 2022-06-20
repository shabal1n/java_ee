<%@include file="header.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style>
    form {
        justify-content: center;
        padding: 3%;
        text-align: center;
    }

    .container_inputs {
        margin: 0 auto;
        display: flex;
        flex-direction: column;
        justify-content: center;
        width: 50%;
    }

    .container_inputs div {
        display: flex;
        flex-direction: row;
        margin-block: 3%;
    }

    label {
        margin-right: 5%;
    }
</style>

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
    <input type="hidden" value="${restaurant.getId()}" name="restaurant">
    <input type="hidden" value="${dateTime.getId()}" name="dateTime">
    <div class="container_inputs">
        <p>Book a table</p>
        <div>
            <p>Date and time: ${dateTime.getDateTime()}</p>
        </div>
        <div>
            <label for="persons">Persons: </label>
            <input type="number" id="persons" name="persons" value="1">
        </div>
        <input type="submit" value="Confirm">
    </div>
</form>

</body>
</html>
<%@include file="footer.jsp" %>
